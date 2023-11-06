package com.packt_automation;

import com.packt_automation.pages.HomePage;
import com.packt_automation.pages.LoginPage;
import com.packt_automation.utility.BaseClass;
import com.packt_automation.utility.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;

public class HomePageTest extends BaseClass {
    PropertyHandling propertyHandling;
    LoginPage loginpage;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeClass
    public void beforeClass() throws IOException {
        propertyHandling = new PropertyHandling();
        launchBrowser(propertyHandling.getproperty("browser"));
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.navigate().to(propertyHandling.getproperty("url"));
        loginPage = new LoginPage(driver);
        loginPage.login(propertyHandling.getproperty("emailId"), propertyHandling.getproperty("password"));

    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void verifyAllElements() throws InterruptedException {
        homePage = new HomePage();
        System.out.println("Title is : " + driver.getTitle());
        waitForElement(homePage.packtLogo);
        List<WebElement> list = driver.findElements(homePage.allElements);

//        System.out.println("Size of list is " + list.size());
        int cnt = 1;
        for (WebElement ele : list) {
            System.out.println("Name of element is outside if " + ele.getText());
            System.out.println(ele.getTagName());
            System.out.println(ele.getCssValue("color"));
            System.out.println(ele.getCssValue("background-color"));
            System.out.println(ele.getCssValue("border"));
            System.out.println(ele.getCssValue("border-radius"));
            System.out.println(ele.getCssValue("display"));
            System.out.println(ele.getCssValue("height"));
//            checkElementAttributes(ele);
            System.out.println("Element Position: X= " + ele.getLocation().getX() + "%10s%" + "Element Position: Y= " + ele.getLocation().getY());
            System.out.println("Count is " + cnt);
            cnt++;
        }
    }

    public void checkElementAttributes(WebElement element) {
        int elementPositionX = element.getLocation().getX();
        int elementPositionY = element.getLocation().getY();
        System.out.println("Element Position: X=" + elementPositionX + ", Y=" + elementPositionY);

        String elementColor = element.getCssValue("color");
        System.out.println("Element Color: " + elementColor);

        String elementText = element.getText();
        if (!elementText.isBlank()) {
            System.out.println("Element Text: " + elementText);
        }
    }

    @Test
    public void checkAllModule() throws InterruptedException {
        homePage = new HomePage();
        System.out.println("Landed on homepage " + homePage);
        waitForElement(homePage.navBarElements);
        List<WebElement> allModules = driver.findElements(homePage.navBarElements);
        System.out.println(allModules.size());
        String homePage = driver.getTitle();
        for (WebElement module : allModules) {
//            String url = module.getAttribute("href");
            module.click();
            System.out.println("Page title is " + driver.getTitle());
            Thread.sleep(4000);
            driver.navigate().back();
            System.out.println(driver.getTitle());


        }
    }

    @Test
    public void ClickAndGetTitleOfElements() {
        homePage = new HomePage();

        List<WebElement> allModules = driver.findElements(homePage.navBarElements);
        System.out.println(allModules.size());

        for (WebElement element : allModules) {
            try {
                element.click();
                System.out.println("Clicked on element with tag: " + element.getTagName());
                System.out.println("Title attribute: " + element.getAttribute("title"));
            } catch (Exception e) {
                System.out.println("Unable to click on element with tag: " + element.getTagName());
            }
        }

    }
}





