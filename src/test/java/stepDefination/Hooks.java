package stepDefination;

import com.global.LocalConfig;

import io.cucumber.java.Before;
import net.thucydides.core.util.EnvironmentVariables;

public class Hooks {
	
	EnvironmentVariables environmentVariables;
	
	@Before
	public void setUp(){
		LocalConfig config = new LocalConfig();
		config.baseUrl =  environmentVariables.getProperties().getProperty("webdriver.base.url");
	}

}
