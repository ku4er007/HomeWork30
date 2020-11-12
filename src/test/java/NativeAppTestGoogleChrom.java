import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.HomePage;

import java.net.URL;

public class NativeAppTestGoogleChrom {
    AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3 API 30 - android 11");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }

    @Test
    public void test() throws Exception {
        HomePage homePage = new HomePage(appiumDriver);
        homePage.navigate();
        homePage.clickOnAgileButton();
        homePage.enterEmail();
        homePage.enterPassword();
        homePage.checkLogoutButton();





    }



}