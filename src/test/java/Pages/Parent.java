package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Parent {

    public void sendKeysFunction(WebElement element, String value){

    }
    public void waitUntilVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scroolToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scroolIntoView();", element);
    }

    public void scroolDistance(int toWhere){
        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();
        js.executeScript("window.scrollBy(0,"+toWhere+")");
    }

    public void scroolToElement(WebElement element, String Middle){

        if (Middle.toLowerCase().contains("mid")){
            JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

            String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                    + "var ElementTop = arguments[0].getBoundingClientRect().top;"
                    + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

            js.executeScript(scrollElementIntoMiddle, element);
        }
    }

    public void scroolToElement(WebElement element, double scrollingPrecision){

        String doubleCevirilmisHali = String.valueOf(scrollingPrecision).replace(".",",");

        JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/"+doubleCevirilmisHali+"));";

        js.executeScript(scrollElementIntoMiddle, element);
    }





}
