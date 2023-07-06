package StepDefinitions;

import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentTestManager;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void before(){
        System.out.println("Senaryo başladı");
    }

    @After
    public void after(Scenario scenario){

        System.out.println("Senaryo bitti");
        System.out.println("Scenario sonucu="+ scenario.getStatus());
        System.out.println("Scenario is failed? ="+ scenario.isFailed());

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");

        if (scenario.isFailed()){

            TakesScreenshot screenshot = (TakesScreenshot) GWD.getDriver();
            File ekranDosyası = screenshot.getScreenshotAs(OutputType.FILE);

    //        ExtentTestManager.getTest().addScreenCaptureFromBase64String(getBase64Screenshot());
           try {
               FileUtils.copyFile(ekranDosyası,
                       new File("target/FailedScreenShots/"+ scenario.getId()+date.format(formatter)+".png"));
           }catch (IOException e){
               e.printStackTrace();
           }
        }
        GWD.quitDriver();
    }
    public String getBase64Screenshot(){
        return ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
