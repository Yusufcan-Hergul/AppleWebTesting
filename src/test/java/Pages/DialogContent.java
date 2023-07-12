package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;
import java.security.PublicKey;

public class DialogContent extends Parent{

    public DialogContent(){
        PageFactory.initElements(GWD.getDriver(), this);
    }
    @FindBy (css = "a[data-globalnav-item-name='apple']")
    private WebElement anaSayfa;







    @FindBy (css = "button[id='globalnav-menubutton-link-mac']")
    private WebElement MacHeader;

    @FindBy (css = "li[class='chapternav-item chapternav-item-compare']")
    private WebElement comparing;


    WebElement myElement;

    public void findAndSend(String strElement, String value){

        switch (strElement){

        }
        sendKeysFunction(myElement, value);
    }
    int cntx=0;
    int cnty=0;
    public void findAndClick(String strElement){

        switch (strElement){
            case "anaSayfa" : myElement = myElement = anaSayfa; break;


            case "macHeader": myElement = MacHeader; break;
            case "comparing": myElement = comparing; break;

        }
        clickFunction(myElement,"mid");
    }












}
