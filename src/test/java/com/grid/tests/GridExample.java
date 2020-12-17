package com.grid.tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Test class that contains a parallel test that will run in Chrome and Firefox
 * with Selenium Grid
 */
public class GridExample {

        @Parameters({"browserType"}) // parameter is set in testng.xml
        @Test
        public void navigateToGmailTest(String browserType) throws MalformedURLException, InterruptedException {

            DesiredCapabilities dr = null;

            if(browserType.equals("firefox")) {
                dr=DesiredCapabilities.firefox();
                dr.setBrowserName("firefox");
                dr.setVersion("");
                dr.setPlatform(Platform.LINUX);
                FirefoxOptions options = new FirefoxOptions();
                options.merge(dr);
            }
            else {
                dr=DesiredCapabilities.chrome();
                dr.setBrowserName("chrome");
                dr.setVersion("");
                dr.setPlatform(Platform.LINUX);
                ChromeOptions options = new ChromeOptions();
                options.merge(dr);
            }

            RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
            driver.navigate().to("http://gmail.com");

            Thread.sleep(20000);
            driver.close();
            driver.quit();
        }

}
