package stepDefination;



import java.util.List;

import com.modals.Search;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.HomePage;
import pages.JobsPage;
import steps.VerifyHomePage;
import steps.VerifyJobsPage;

public class HomePageStepDef {

	HomePage homepage;
	JobsPage jobsPage;

	@Steps
	VerifyHomePage verifyHomePage;

	@Steps
	VerifyJobsPage verifyJobsPage;

	List<Search> search;


	@Given("user navigates to homepage.")
	public void user_navigates_to_homepage() {
		homepage.open();
	}


	@Then("jobs page renders correctly")
	public void jobs_page_renders_correctly() throws Exception {
		verifyHomePage.navigationBarRendersCorrectly();
		verifyHomePage.searchFieldsRendersCorrectly();
		verifyHomePage.sectorListsRenderedCorrectly();
	}


	@When("user clicks Sign in.")
	public void user_clicks_sign_in() throws Exception {
		homepage.clickSignInLink();
	}

	@When("user clicks Create account.")
	public void user_clicks_create_account() throws Exception {
		homepage.clickOnCreateAccountLink();
	}

	@Then("user navigates to sign in page.")
	public void user_navigates_to_sign_in_page() throws Exception {
		homepage.verifyUserRedirectsToSignInPage();

	}

	@Then("user navigates to create account page.")
	public void user_navigates_to_create_account_page() throws Exception {
		homepage.verifyUserRedirectsToSignInPage();

	}


	@When("user verify navigation bar .")
	public void user_verify_navigation_bar() throws Exception {
		homepage.verifyNavigationBarIsPresent();
	}

	@Then("navigation bar should have all the links functional.")
	public void navigation_bar_should_have_all_the_links_functional() throws Exception {
		homepage.verifyNavigationBarLinks();
	}

	@Then("user goes to the correct page on clicking.")
	public void user_goes_to_the_correct_page_on_clicking() throws Exception {
		homepage.clickNavigationBarLinksAndVerify();
	}

	@Given("user verify sector section is visible on home page.")
	public void user_verify_sector_section_is_visible_on_home_page() throws Exception {
		homepage.verifyBrowseBySectorSectionIsPresent();
	}

	@When("user click on one of the link.")
	public void user_click_on_one_of_the_link() throws Exception {
		homepage.clickLinkBrowserBySector();
	}


	@Then("user see job details, with an apply button.")
	public void user_see_job_details_with_an_apply_button() throws Exception {
		verifyJobsPage.clickJobFromJobList();
		verifyJobsPage.verifyApplyButtonisPresent();
	}

	@Given("user can see the search bar")
	public void user_can_see_the_search_bar() throws Exception {
		homepage.verifySearchKeyWordBoxIsPresent();
		homepage.verifySearchLocationBoxIsPresent();
		homepage.verifySearchRadialLocationDropDownIsPresent();
		homepage.verifySearchButtonIsPresent();
	}

	@When("user search for the job")
	public void user_search_for_the_job(DataTable dataTable) {
		search = dataTable.asList(Search.class);
	}


	@Then("user relevant details from the serach results")
	public void user_relevant_details_from_the_serach_results() throws Exception {
		for (Search searchTerm : search) {
			homepage.enterSearchKeyWord(searchTerm.getKeyword());
			homepage.enterSearchLocation(searchTerm.getLocation());
			homepage.selectRadius(searchTerm.getRadius());
			homepage.clickSearch();
			jobsPage.verifySearchResults(searchTerm.getKeyword());
			verifyHomePage.clickHomeNavigationLink();

		}
	}




}
