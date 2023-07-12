package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MacComparison {

    DialogContent dc= new DialogContent();

    WebDriverWait wait= new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
    @When("Click on the Mac Header and comparing")
    public void clickOnTheMacHeaderAndComparing() {
        dc.findAndClick("MacHeader");
        dc.findAndClick("comparing");
    }

    @And("Select three Mac models through the selector")
    public void selectThreeMacModelsThroughTheSelector() {
    }
}
