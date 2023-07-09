package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStep {

    DialogContent dc= new DialogContent();
    WebDriverWait wait= new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    @Given("Go to apple website")
    public void goToAppleWebsite() {
        GWD.getDriver().get("https://www.apple.com/tr/");
        GWD.getDriver().manage().window().maximize();

    }

    @Then("Verify that you are on the rigth site")
    public void verifyThatYouAreOnTheRigthSite() {
        wait.until(ExpectedConditions.urlContains("apple"));
        String webURL= GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(webURL.contains("https://www.apple.com/tr/"));
    }
}
