package com.packt_automation;

import com.packt_automation.pages.HomePage;
import com.packt_automation.pages.LoginPage;
import com.packt_automation.utility.BaseClass;
import com.packt_automation.utility.PropertyHandling;
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

}





