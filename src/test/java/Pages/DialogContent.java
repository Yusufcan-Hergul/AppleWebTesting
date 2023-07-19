package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;
import java.security.PublicKey;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "a[data-globalnav-item-name='apple']")
    private WebElement anaSayfa;
    @FindBy(css = "a[class='globalnav-link globalnav-submenu-trigger-link globalnav-link-mac']")
    private WebElement macHeader;
    @FindBy(css = "li[class='chapternav-item chapternav-item-compare']")
    private WebElement comparing;
    @FindBy(css = "select[id='selector-0']")
    private WebElement leftSelector;
    @FindBy(css ="select[id='selector-1']")
    private WebElement middleSelector;
    @FindBy(css = "select[id='selector-2']")
    private WebElement rightSelector;
    @FindBy(css = "")
    private WebElement JDFASLKDF;


    WebElement myElement;

    public void findAndSend(String strElement, String value) {

        switch (strElement) {

        }
        sendKeysFunction(myElement, value);
    }

    int cntx = 0;
    int cnty = 0;

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "anaSayfa": myElement = anaSayfa;break;
            case "macHeader": myElement = macHeader;break;
            case "comparing": myElement = comparing;break;

        }
        clickFunction(myElement, "mid");
    }
    int cnt1=0;
    int cnt2=0;
    int cnt3=0;
    public void findAndContainsText(String strElement, String text){

        switch (strElement){

        }
        verifyContainsText(myElement, text);
    }

    public void actionAndClick(String strElement){
        switch (strElement){

        }
        actionFunction(myElement);
    }

    public WebElement getMyElement(String strElement){
        switch (strElement){

        }
        return myElement;
    }

    public void specialFindAndClick(String strElement, double scrollingPrecision) {

        switch (strElement) {//tam olarak hedefe girmesi için
          //  case "anaSayfa": myElement = anaSayfa;break;
        }
        clickFunction(myElement, scrollingPrecision);
    }
       public void findAndSelect(String strElement, String text){
        switch (strElement){
            case "leftSelect": myElement = leftSelector;break;
            case "middleSelect": myElement = middleSelector;break;
            case "rigthSelect": myElement = rightSelector;break;

        }
       }




}
