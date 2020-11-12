package ui;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends BasePage {


    public HomePage(AppiumDriver driver) {
        appiumDriver = driver;
    }

    public void navigate() {
        appiumDriver.get("http://demo.guru99.com/");
    }

    public Object clickOnAgileButton() {
        appiumDriver.findElement(By.xpath("//a[contains(text(),'Agile Project')]")).click();
        return this;
    }


    public void enterEmail() {
        appiumDriver.findElement(By.xpath("//input[@type='text']")).sendKeys("1303");

    }

    public void enterPassword() {
        appiumDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("Guru99" + Keys.ENTER);

    }


    public void checkLogoutButton() {
        appiumDriver.findElement(By.xpath("//a[contains(text(),'Log out')]"));

    }
}
