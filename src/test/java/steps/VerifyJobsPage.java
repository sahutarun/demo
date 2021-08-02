package steps;

import org.junit.Assert;

import com.exceptions.LinkNotVisibleException;

import net.thucydides.core.annotations.Step;
import pages.JobsPage;

public class VerifyJobsPage {

	JobsPage jobsPage;

	@Step
	public void clickJobFromJobList() throws Exception{
		jobsPage.verifyJobsListAndClick();
	}

	@Step
	public void verifyApplyButtonisPresent() throws Exception{
		try {
			Assert.assertTrue("Verify apply button",jobsPage.verifyApplyButton());
		}catch(Exception e) {
			throw new LinkNotVisibleException("Apply button not present on page");
		}
	}

}


