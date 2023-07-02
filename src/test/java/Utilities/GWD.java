package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.impl.SimpleLogger;


import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD {
    public static WebDriver driver;

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static ThreadLocal<String> threadBrowseName = new ThreadLocal<>();

    public static WebDriver getDriver() {
        //extend report türkçe bilgi çalışmaması sebebiyle kondu
        Locale.setDefault(new Locale("EN"));

        Logger.getLogger("").setLevel(Level.SEVERE);
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Error");

        if (threadBrowseName.get() == null)
            threadBrowseName.set("chrome"); //paralel çalıştırma yoksa chrome ile başlat


        if (threadDriver.get() == null) {

            String browseName = threadBrowseName.get();
            switch (browseName) {

                case "chrome":
                    //            System.setProperty(ChromeDriverService.CHROME_DRIVER_WHITELISTED_IPS_PROPERTY, "true");
                    WebDriverManager.chromedriver().setup();
                    threadDriver.set(new ChromeDriver());
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    threadDriver.set(new FirefoxDriver());
                    break;

                // case "safari":
//                    WebDriverManager.safaridriver().setup();
//                    threadDriver.set(new SafariDriver());
//                    break;
//
//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    threadDriver.set(new EdgeDriver());
//                    break;
//
//                case "opera":
//                    WebDriverManager.operadriver().setup();
//                    threadDriver.set(new OperaDriver());
//                    break;
//
//                case "brave":
//
//                    break;


            }
        }
        return threadDriver.get();
    }

    public static void quitDriver() {
    Bekle(5);

    if (threadDriver.get() != null){
        threadDriver.get().quit();

        WebDriver driver = threadDriver.get();
        driver = null;
        threadDriver.set(driver);
    }
    }

    public static void Bekle(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
