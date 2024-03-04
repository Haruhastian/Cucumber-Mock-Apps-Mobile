package com.koltiva.hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertyManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Hooks {
 public static AndroidDriver<AndroidElement> driver;

    static Properties props;

    static {
        try {
            props = new PropertyManager().getProps();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


 private final DesiredCapabilities caps = new DesiredCapabilities();

    public Hooks() throws IOException {
    }

    @Before
    public void setupDeviceCapabilities() throws IOException, URISyntaxException {
        Properties props = new PropertyManager().getPropsDevel();
        caps.setCapability("deviceName", props.getProperty("data.deviceName"));
        caps.setCapability("platformName", props.getProperty("data.platformName"));
        caps.setCapability("platformVersion", props.getProperty("data.platformVersion"));
        caps.setCapability("udid",props.getProperty("data.udid"));
        caps.setCapability("app", new File(System.getProperty("user.dir")
                + "/src/test/resources/apk/apk-demo/saucedemo.apk").getAbsolutePath());
        caps.setCapability("appPackage", props.getProperty("data.appPackage"));
        caps.setCapability("appActivity", props.getProperty("data.appActivity"));
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("autoGrantPermissions",true);
        caps.setCapability("noReset", true);

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/h" +
                    "ub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }


    @After(order = 0)
    public void stopAndroidDriver() throws InterruptedException{
        Thread.sleep(3000);
        driver.closeApp();
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }
    }
}
