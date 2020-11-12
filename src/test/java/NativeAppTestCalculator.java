import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class NativeAppTestCalculator {

    AppiumDriver appiumDriver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3 API 30 - android 11");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("platformName", "Android");

        appiumDriver = new AndroidDriver(serverAddress, capabilities);
    }

    @Test
    public void testSum() throws Exception {

        WebElement two = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_2')]"));
        two.click();
        WebElement plus = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'op_add')]"));
        plus.click();
        WebElement three = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_3')]"));
        three.click();
        WebElement equalTo = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'eq')]"));
        equalTo.click();
        WebElement results = appiumDriver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'result_final')]"));
        results.click();

        assertEquals(results.getText(), "5");
    }

    @Test
    public void testMultiplication() throws Exception {
        WebElement two = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_5')]"));
        two.click();
        WebElement plus = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'op_mul')]"));
        plus.click();
        WebElement three = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_3')]"));
        three.click();
        WebElement equalTo = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'eq')]"));
        equalTo.click();
        WebElement results = appiumDriver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'result_final')]"));
        results.click();

        assertEquals(results.getText(), "15");
    }

    @Test
    public void testDivision() throws Exception {
        WebElement two = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_2')]"));
        two.click();
        WebElement one = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_1')]"));
        one.click();
        WebElement divis = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'op_div')]"));
        divis.click();
        WebElement three = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_7')]"));
        three.click();
        WebElement equalTo = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'eq')]"));
        equalTo.click();
        WebElement results = appiumDriver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'result_final')]"));
        results.click();

        assertEquals(results.getText(), "3");
    }

    @Test
    public void testFractionalNumbers() throws Exception {
        WebElement two = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_5')]"));
        two.click();
        WebElement point = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'dec_point')]"));
        point.click();
        WebElement six = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_6')]"));
        six.click();
        WebElement plus = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'op_div')]"));
        plus.click();
        WebElement three = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_2')]"));
        three.click();
        WebElement equalTo = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'eq')]"));
        equalTo.click();
        WebElement results = appiumDriver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'result_final')]"));
        results.click();

        assertEquals(results.getText(), "2.8");

    }

    @Test
    public void testPercentageOfNumber() throws Exception {
        WebElement five = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_5')]"));
        five.click();
        WebElement zero1 = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_0')]"));
        zero1.click();
        WebElement zero2 = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_0')]"));
        zero2.click();
        WebElement minus = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'op_sub')]"));
        minus.click();
        WebElement nine = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_9')]"));
        nine.click();
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE); //hi i am flipping the screen
        WebElement pct = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'op_pct')]"));
        pct.click();
        WebElement equalTo = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'eq')]"));
        equalTo.click();
        WebElement results = appiumDriver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'result_final')]"));
        results.click();
        assertEquals(results.getText(), "455");

    }
}
