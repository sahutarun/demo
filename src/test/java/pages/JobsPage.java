package pages;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.exceptions.LinkNotVisibleException;
import com.exceptions.PageHeadingException;
import com.exceptions.SearchException;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class JobsPage extends PageObject {

	@FindBy(how=How.ID, using="browsing")
	public WebElementFacade pageHeading;

	@FindBy(how=How.XPATH, using="//ul[@id='listing']/li[@class='lister__item cf lister__item--display-logo-in-listing lister__item--display-logo-in-listing']")
	public List<WebElementFacade> jobsListing;

	@FindBy(how=How.XPATH, using="//ul[@id='listing']/li[@class='lister__item cf lister__item--display-logo-in-listing lister__item--display-logo-in-listing']//a")
	public List<WebElementFacade> jobsListLink;

	@FindBy(how=How.XPATH, using="//h3[@class='lister__header']")
	public List<WebElementFacade> searchResultItemTitle;

	@FindBy(how=How.XPATH, using="//div[@class='block fix-text job-description']//p")
	public List<WebElementFacade> jobDescription;

	@FindBy(how=How.XPATH, using="(//a[contains(text(),'Apply')])[1]")
	public WebElementFacade Apply;

	
	
	/**
	 * Get page label text
	 *
	 * @return text of the label
	 */
	public String getJobsPageHeading() throws Exception{
		try{
			return pageHeading.getText();
		}catch(Exception e){
			throw new PageHeadingException("Jobs Page Heading is not visbible on page " + e.getMessage());
		}
	}

	/**
	 * Check jobs list and click the link
	 *
	 */
	public void verifyJobsListAndClick() throws Exception{
		try{
			if(jobsListing.size()>0){
				WebElementFacade ele = jobsListLink.get(1);
				if(ele.isDisplayed()) {
					ele.click();
				}
			}else{
				throw new LinkNotVisibleException("No Jobs are available on page");
			}
		}catch(Exception e){
			throw new LinkNotVisibleException("Unable to click on jobs " + e.getMessage());
		}
	}

	/**
	 * Validate the apply button
	 *
	 * @return boolean value
	 */
	public boolean verifyApplyButton() throws Exception{
		boolean isPresent = false;
		try {
			if(Apply.isDisplayed()) {
				isPresent = true;
			}
			return isPresent;
		}catch(Exception e) {
			throw new LinkNotVisibleException("Apply button not present on Jobs page " + e.getMessage());
		}	
	}

	/**
	 * Validate search results
	 *
	 * @param keyword to search
	 * 
	 */
	public void verifySearchResults(String keyword) throws Exception{
		boolean keyWordNotPresent = true;
		try{
			if(searchResultItemTitle.size()>0) { // check if the search result is not empty else throw exception
				for(int i=0;i<searchResultItemTitle.size();i++) {
					if(searchResultItemTitle.get(i).isDisplayed()) { // check if the search result is displayed else throw exception
						String searchResult = searchResultItemTitle.get(i).getText();
						if(searchResult.contains(keyword)) { // if the searchResult contains keyword make the condition and false
							keyWordNotPresent = false ;
						}
						if(keyWordNotPresent) { //execute only when searchResult to do have keyword
							searchResultItemTitle.get(i).click();  // click to open the search result page and check that description should have the keyword else throw exception 
							if(searchTextInJobDescription(keyword)){

							}else {
								throw new SearchException("Not search results avalable on page");
							}
						}
					}
				}
			}else {
				throw new SearchException("Not search results avalable on page");

			}
		}catch(Exception e){
			throw new SearchException("Not able to click search button" + e.getMessage());
		}
	}

	/**
	 * Validate search keyword in job description page
	 *
	 * @param keyword to search
	 * @return boolean value
	 */
	public boolean searchTextInJobDescription(String keyword) {
		boolean keywordfoundInDescription = false;
		try {
			if(jobDescription.size()>0) {
				for(int i=0;i<=jobDescription.size();i++) {
					if(jobDescription.get(i).getText().contains(keyword))
						keywordfoundInDescription = true;
					break;
				}
			}else {
				throw new SearchException("Not able to click search button");
			}
		}catch(Exception e) {
			throw new SearchException("Not able to click search button" + e.getMessage());
		}
		return keywordfoundInDescription;
	}

}
