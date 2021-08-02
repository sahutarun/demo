package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.enums.Navigation;
import com.exceptions.BrowseBySectorException;
import com.exceptions.NavigationBarException;
import com.exceptions.PageRedirectException;
import com.exceptions.SearchException;
import com.global.Config.TopNavigationUrls;
import com.global.LocalConfig;

import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import utils.VerifyBrokenLinks;

public class HomePage extends PageObject {

	@FindBy(how=How.ID, using="primary-nav")
	public WebElementFacade navigationBar;

	@FindBy(how=How.XPATH, using="//nav[@id='primary-nav']//li/a")
	public List<WebElementFacade> navigationBarLinks;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Home')]")
	public WebElementFacade navigationBarHomeLink;

	@FindBy(how=How.XPATH, using="//span[contains(text(),'Browse jobs by Sector')]")
	public WebElementFacade browseBySectorLabel;

	@FindBy(how=How.XPATH, using="//div[@class='browse__items']/ul/li")
	public List<WebElementFacade> browseBySectorLinks;

	@FindBy(how=How.ID, using="keywords")
	public WebElementFacade searchBarKeyword;

	@FindBy(how=How.ID, using="location")
	public WebElementFacade searchBarLocation;

	@FindBy(how=How.ID, using="RadialLocation")
	public WebElementFacade searchBarRadialLocationDropDown;

	@FindBy(how=How.XPATH, using="//input[@value='Search']")
	public WebElementFacade searchButton;

	@FindBy(how=How.XPATH, using="//a[contains(text(),'Sign in')]")
	public WebElementFacade signInLink;

	@FindBy(how=How.XPATH, using="//a[contains(text(),'Create account')]")
	public WebElementFacade createAccountLink;

	JobsPage jobsPage;


	/**
	 * This will open the home page of the app
	 * page url picked from serenity.properties file
	 * 
	 */
	public void openHomePage(){
		open();
		getDriver().manage().window().maximize();
	}
	
	/**
	 * Validate if the navigation bar is present and visible on screen
	 * 
	 */
	public void verifyNavigationBarIsPresent() throws Exception{
		try{
			navigationBar.isVisible();
		}catch(Exception e){
			throw new NavigationBarException("Navigation Bar is not visbible on page "+navigationBar);
		}
	}
	
	/**
	 * Click home navigation link
	 */
	public void clickNavHomeLink() throws Exception{
		navigationBarHomeLink.click();
	}

	/**
	 * Validate if the textBox searchByKeyword is visible and present on screen
	 * 
	 */
	public void verifySearchKeyWordBoxIsPresent() throws Exception{
		try{
			searchBarKeyword.isVisible();
		}catch(Exception e){
			throw new SearchException("Search Keyword textBox is not visbible on page" + e.getMessage());
		}
	}

	/**
	 * Validate if the textBox searchByLocation is visible and present on screen
	 * 
	 */
	public void verifySearchLocationBoxIsPresent() throws Exception{
		try{
			searchBarLocation.isVisible();
		}catch(Exception e){
			throw new SearchException("Search Location textBox is not visbible on page" + e.getMessage());
		}
	}

	/**
	 * Validate if the dropdown search by location is visible and present on screen
	 * 
	 */
	public void verifySearchRadialLocationDropDownIsPresent() throws Exception{
		try{
			searchBarRadialLocationDropDown.isVisible();
		}catch(Exception e){
			throw new SearchException("Search RadialLocation dropdown is not visbible on page" + e.getMessage());
		}
	}

	/**
	 * Validate if the button search is visible and present on screen
	 * 
	 */
	public void verifySearchButtonIsPresent() throws Exception{
		try{
			searchButton.isVisible();
		}catch(Exception e){
			throw new SearchException("Search button is not visbible on page" + e.getMessage());
		}
	}

	/**
	 * Validate if the search button is visible and present on screen
	 * 
	 */
	public void verifyBrowseBySectorSectionIsPresent() throws Exception{
		if(browseBySectorLinks.size()>0){
		}else{
			throw new BrowseBySectorException("Browse By Sector links are not present");
		}
	}

	/**
	 * Click link sign in 
	 */
	public void clickSignInLink() throws Exception{
		signInLink.click();
	}

	/**
	 * Click link create account 
	 * 
	 */
	public void clickOnCreateAccountLink() throws Exception{
		createAccountLink.click();
	}

	/**
	 * Validate if a user is redirecting to Sign in page
	 * 
	 */
	public void verifyUserRedirectsToSignInPage() throws Exception{
		try {
		Assert.assertEquals("User not navigated to signin page", LocalConfig.baseUrl+TopNavigationUrls.SignIn, getDriver().getCurrentUrl());
		}catch(Exception e) {
			throw new PageRedirectException("Unable to navigatie to signin age");
		}
	
	}

	/**
	 * Validate if a user is redirecting to Create account page
	 * 
	 */
	public void verifyUserRedirectsToCreateAccountPage() throws Exception{
		try {
		Assert.assertEquals("User not navigated to create account page", LocalConfig.baseUrl+TopNavigationUrls.CreateAccount, getDriver().getCurrentUrl());
	}catch(Exception e) {
		throw new PageRedirectException("Unable to navigation to page");
	}
	}

	/**
	 * Validate the broken links
	 * 
	 */
	public void verifyNavigationBarLinks() throws Exception{
		try{	
			if(navigationBarLinks.size()>0){ //execute only when the links present in the section else throw exception
				for(int i=0;i<navigationBarLinks.size();i++)
				{
					WebElement ele = navigationBarLinks.get(i);
					if(ele.isDisplayed()){  //check if the element is visible on screen
						String url= ele.getAttribute("href");
						List<String> brokenLinks = VerifyBrokenLinks.validateLinks(url);
						if(brokenLinks!=null){
							for(String links:brokenLinks){
								System.out.println("broken links are: "+links); 
							}
						}
					}
				}
			}else{
				throw new NavigationBarException("Navigation Bar links are not present on page");
			}
		}catch(Exception e){
			throw new NavigationBarException("Navigation Bar is not visbible on page "+navigationBarLinks);
		}
	}

	/**
	 * Validate links on navigation bar are correct
	 * 
	 */
	public void clickNavigationBarLinksAndVerify() throws Exception{
		try{	
			if(navigationBarLinks.size()>0){ //execute only when the links present in navigation else throw exception
				for(int i=0;i<navigationBarLinks.size();i++)
				{
					WebElementFacade ele = navigationBarLinks.get(i);
					if(ele.isDisplayed()) { //check if the element is visible on screen
						String linkName = ele.getText();
						ele.click();
						verifyLinks(linkName);
					}
				}
			}else{
				throw new NavigationBarException("Navigation Bar links are not present on page");
			}
		}catch(Exception e){
			throw new NavigationBarException("Navigation Bar is not visbible on page" +navigationBarLinks);
		}
	}

	/**
	 * Validate correct url redirection
	 *
	 * @param linkName
	 * 
	 */
	public void verifyLinks(String linkName){
		String completeErrorList = "";
		List<String> errorList = new ArrayList<String>();
		if(linkName.equalsIgnoreCase(Navigation.Home.getValue())) {
			if(getDriver().getCurrentUrl().equals(LocalConfig.baseUrl+TopNavigationUrls.Home)
					) {

			}else {
				errorList.add("Clicking on Home did not redirect to Home page"); // error message added to list to do soft assert in case redirection fails
			}

		}if(linkName.equalsIgnoreCase(Navigation.FindAJob.getValue())) {
			if(getDriver().getCurrentUrl().equals(LocalConfig.baseUrl+TopNavigationUrls.FindAJob)
					) {

			}else {
				errorList.add("Clicking on Find a job did not redirect to jobs page");
			}

		}if(linkName.equalsIgnoreCase(Navigation.JobAlerts.getValue())) {
			if(getDriver().getCurrentUrl().equals(LocalConfig.baseUrl+TopNavigationUrls.JobAlerts)
					) {

			}else {
				errorList.add("Clicking on Job alerts did not redirect to Job alerts page");
			}

		}if(linkName.equalsIgnoreCase(Navigation.SearchRecruiters.getValue())) {
			if(getDriver().getCurrentUrl().equals(LocalConfig.baseUrl+TopNavigationUrls.SearchRecruiters)
					) {

			}else {
				errorList.add("Clicking on Search recruiters did not redirect to Search recruiters page");
			}
		}
		if(linkName.equalsIgnoreCase(Navigation.JobsBlog.getValue())) {
			if(getDriver().getCurrentUrl().equals(LocalConfig.baseUrl+TopNavigationUrls.JobsBlog)
					) {

			}else {
				errorList.add("Clicking onJobs blog did not redirect to Jobs blog page");
			}
		}

		for (String str : errorList) {
			completeErrorList += str + "\n"; // add all the errors in list for soft assertion
		}
		if (completeErrorList.equalsIgnoreCase(""))
			;
		else
			throw new NavigationBarException(completeErrorList);

	}

	/**
	 * Click the link available on BrowseBySector
	 *
	 * @return linkName
	 */
	public String clickLinkBrowserBySector() throws Exception{
		String linkName=null;
		try{	
			if(browseBySectorLinks.size()>0){
				WebElementFacade ele = navigationBarLinks.get(1);
				if(ele.isDisplayed()) {
					linkName = ele.getText();
					ele.click();
				}
			}else{
				throw new BrowseBySectorException("Browse by section is not visible on page");
			}
		}catch(Exception e){
			throw new BrowseBySectorException("Unable to click on browse by section is not visible on page" + e.getMessage());
		}
		return linkName;
	}
	
	/**
	 * Enter text in search textBox
	 *
	 * @param keyword
	 * 
	 */
	public void enterSearchKeyWord(String keyword) throws Exception{
		try{
			searchBarKeyword.type(keyword);
		}catch(Exception e){
			throw new SearchException("Not able to enter search keyword" + e.getMessage());
		}
	}
	
	/**
	 * Enter text in search textBox
	 *
	 * @param location
	 * 
	 */
	public void enterSearchLocation(String location) throws Exception{
		try{
			searchBarLocation.type(location);
		}catch(Exception e){
			throw new SearchException("Not able to enter search location" + e.getMessage());
		}
	}
	
	/**
	 * Select the radius from the drop down
	 *
	 * @param radius
	 * 
	 */
	public void selectRadius(String radius) throws Exception{
		try{
			searchBarRadialLocationDropDown.selectByValue(radius);
		}catch(Exception e){
			throw new SearchException("Not able to enter search location" + e.getMessage());
		}
	}
	
	
	/**
	 * Click on search button
	 *	
	 */
	public void clickSearch() throws Exception{
		try{
			searchButton.click();;
		}catch(Exception e){
			throw new SearchException("Not able to click search button" + e.getMessage());
		}
	}
	


}






