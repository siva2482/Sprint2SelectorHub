package TestRunner;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Sprint2SelectorHub\\src\\test\\java\\Feature\\selectorhub.feature",
		glue={"StepDef"},
		plugin= {"pretty","html:target/html","json:target/report.json"},
		monochrome=true,dryRun=false
		)
public class TestRunner {

}
