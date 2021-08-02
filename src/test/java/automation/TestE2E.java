package automation;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = ".",
glue={"stepDefination"},
plugin = {"rerun:rerun/rerun.txt"},
tags="@e2e")
public class TestE2E {

}
