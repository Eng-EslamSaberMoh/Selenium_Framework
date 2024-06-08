package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = {"src/test/java/features"},
glue = {"stepDefinitions"}
,plugin = {"pretty","html:target/cucumber_html_reports/report.html"})
public class TestRunner extends TestBase{

}
