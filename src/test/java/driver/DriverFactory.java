package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getChromeDriver(){
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation;

        if(OS.isFamilyMac()) {
            chromeDriverLocation = "/Users/longl/Desktop/drivers/chromedriver";
        } else if (OS.isFamilyWindows()) {
            chromeDriverLocation = "\\Users\\longl\\Desktop\\chromedriver_win32\\chromedriver.exe";
        } else {
            throw new RuntimeException("Error !!!");
        }
        String chromeAbsoluteLocation = currentProjectLocation.concat(chromeDriverLocation);
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        //Set up Chrome option
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15L));
        return driver;
    }
}
