package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/"},
        glue = {"Steps","Utilities"}
)
public class TestRunnerAll extends AbstractTestNGCucumberTests{

}
