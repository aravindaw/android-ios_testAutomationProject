package com.viewQwest.app.scripts;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.MalformedURLException;
import java.net.URL;

public class StartDriver {
    public static IOSDriver iosDriver;
    public static AndroidDriver androidDriver;
    public static AppiumDriver driver;
    public static Enums device;

    @Parameters({"OS"})
    @Step("Before Suite: Setup the environment variables and start the app")
    @BeforeSuite
    public void setUp(String OS) throws MalformedURLException, ConfigurationException {


        CompositeConfiguration config = new CompositeConfiguration();
        config.addConfiguration(new PropertiesConfiguration("src/main/resources/config.properties"));

//        File app=new File(config.getProperty("APK_PATH").toString().trim());

        DesiredCapabilities capabilities = new DesiredCapabilities();
//

        if (OS.equals("IOS")) {
            capabilities.setCapability("autoAcceptAlerts", true);
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("showIOSLog", true);
            capabilities.setCapability("platformVersion", config.getProperty("IOS_PLATFORM_VERSION").toString().trim());
            capabilities.setCapability("locationContextEnabled", true);
            capabilities.setCapability("deviceName", config.getProperty("IOS_DEVICE_NAME").toString().trim());
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("app", config.getProperty("IOS_APP_PATH").toString().trim());
            iosDriver = new IOSDriver(new URL("http://"+config.getProperty("IOS_APPIUM_SERVER").toString().trim()+":4723/wd/hub"), capabilities);
            driver = iosDriver;
            device= Enums.IOS;


        } else {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getProperty("DEVICE_NAME").toString().trim());
            capabilities.setCapability("app", config.getProperty("APK_PATH").toString().trim());
            capabilities.setCapability("appActivity", config.getProperty("APP_ACTIVITY").toString().trim());
            capabilities.setCapability("appPackage", config.getProperty("APP_PACKAGE").toString().trim());
            capabilities.setCapability("adv", config.getProperty("AVD").toString().trim());
            androidDriver = new AndroidDriver(new URL("http://" + config.getProperty("APPIUM_SERVER") + ":4723/wd/hub"), capabilities);
            driver = androidDriver;
            device= Enums.ANDROID;

        }


    }

    @Step("After Suite: Close the driver and app")
    @AfterSuite
    public void teardown() {
        //close the app
        try {
            iosDriver.quit();
            androidDriver.quit();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
