package steps;

import net.thucydides.core.annotations.Step;
import pages.HomePage;

public class VerifyHomePage {
	
	HomePage homepage;
	
	@Step
	public void navigationBarRendersCorrectly() throws Exception{
		homepage.verifyNavigationBarIsPresent();
		}
	
	@Step
	public void searchFieldsRendersCorrectly() throws Exception{
		homepage.verifySearchKeyWordBoxIsPresent();
		homepage.verifySearchLocationBoxIsPresent();
		homepage.verifySearchRadialLocationDropDownIsPresent();
		homepage.verifySearchButtonIsPresent();
		}
	
	@Step
	public void sectorListsRenderedCorrectly() throws Exception{
		homepage.verifyBrowseBySectorSectionIsPresent();

		}
	
	@Step
	public void searchKeyWordBoxIsPresent() throws Exception{
		homepage.verifySearchKeyWordBoxIsPresent();
		}
	
	@Step
	public void searchLocationBoxIsPresent() throws Exception{
		homepage.verifySearchLocationBoxIsPresent();
		}
	
	@Step
	public void searchRadialLocationDropDownIsPresent() throws Exception{
		homepage.verifySearchRadialLocationDropDownIsPresent();
		}
	
	@Step
	public void SearchButtonIsPresent() throws Exception{
		homepage.verifySearchButtonIsPresent();
		}
	
	@Step
	public void clickHomeNavigationLink() throws Exception{
		homepage.clickNavHomeLink();
		}
	
	
	

}
