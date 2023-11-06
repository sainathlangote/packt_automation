package com.packt_automation.pages;

import com.packt_automation.utility.BaseClass;
import com.packt_automation.utility.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseClass {
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By signinbutton = By.xpath("//a[text()='Sign in']");
    public By findOutForMore = By.xpath("//a[text()='Find out more ']");
    public By emailId = By.id("login-input-email");
    public By password = By.id("login-input-password");
    public By signinbutton2 = By.xpath("//span[text()='Sign In']");
    public By loginbutton = By.xpath("//button[@type='submit']");


    public void login(String emailId, String password) {

        System.out.println(driver.getTitle());
        scrollToElement(signinbutton);
        click(signinbutton);
        System.out.println(driver.getTitle());
        enterText(this.emailId, emailId);
        enterText(this.password, password);
        click(signinbutton2);
        System.out.println(driver.getTitle());
    }

}
