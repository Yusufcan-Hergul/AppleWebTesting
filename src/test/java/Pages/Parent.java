package Pages;

import Utilities.GWD;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Parent {

    public void sendKeysFunction(WebElement element, String value){

    }
    public void waitUntilVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scroolIntoView();", element);
    }

    public void scrollDistance(int toWhere){
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("window.scrollBy(0,"+toWhere+")");
    }

    public void scrollToElement(WebElement element, String Middle){

        if (Middle.toLowerCase().contains("mid")){
            JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

            String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                    + "var elementTop = arguments[0].getBoundingClientRect().top;"
                    + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

            js.executeScript(scrollElementIntoMiddle, element);
        }
    }

    public void scrollToElement(WebElement element, double scrollingPrecision){

        String doubleCevirilmisHali = String.valueOf(scrollingPrecision).replace(".",",");

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/"+doubleCevirilmisHali+"));";

        js.executeScript(scrollElementIntoMiddle, element);
    }

    public void clickFunction(WebElement element){ //düz tıklama
        scrollToElement(element);
        waitUntilClickable(element);
        element.click();
    }

    public void clickFunction(WebElement element, String Middle){ //ortalayarak tıklama
        scrollToElement(element, Middle);
        waitUntilClickable(element);
        element.click();
    }

    public void clickFunction(WebElement element, double scrollingPrecision) { //hassas ortalayarak tıklama
        scrollToElement(element, scrollingPrecision);
        waitUntilClickable(element);
        element.click();
    }
    public void waitUntilClickable(WebElement element){
        WebDriverWait wait= new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void verifyContainsText(WebElement element, String text){
        scrollToElement(element, "mid");
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }
    public List<WebElement> waitVisibleListAllElement(List<WebElement> elemetList) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(elemetList));
        return elemetList;
    }
    public void actionFunction(WebElement element){
        Actions actions= new Actions(GWD.getDriver());
        Action action= actions.moveToElement(element).click().build();
        action.perform();
    }
    public void selectFunction(WebElement element, String text){
        waitUntilVisible(element);
        Select menu = new Select(element);
        menu.selectByVisibleText(text);
    }



}
