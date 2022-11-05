package api_learning;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrownser {
    public static void main(String[] args) {
        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation;

        if(OS.isFamilyMac()) {
            chromeDriverLocation = "/src/test/resources/drivers/chromedriver";
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
        driver.get(" https://google.com.vn");

        try{
            Thread.sleep(3000);
        } catch (Exception ignored){}
        driver.quit();
    }

    }
