package com.packt_automation;

import com.packt_automation.pages.HomePage;
import com.packt_automation.pages.LoginPage;
import com.packt_automation.utility.BaseClass;
import com.packt_automation.utility.PropertyHandling;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClickAndGetTitleOfElements extends BaseClass {
    PropertyHandling propertyHandling;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeClass
    public void beforeClass() throws IOException {
        propertyHandling = new PropertyHandling();
        launchBrowser(propertyHandling.getproperty("browser"));
        driver.get(propertyHandling.getproperty("url"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver);
        loginPage.login(propertyHandling.getproperty("emailId"), propertyHandling.getproperty("password"));
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void clickAndGetTitle() throws InterruptedException {
        List<By> elementList = new ArrayList<>();
        homePage = new HomePage();
        elementList.add(homePage.packtLogo);
        elementList.add(homePage.browseLibrary);
        elementList.add(homePage.searchTitles);
        elementList.add(homePage.myLibraryDropdown);
        elementList.add(homePage.recentsDropdown);
        elementList.add(homePage.signOut);
        elementList.add(homePage.cart);
        System.out.println("Size of list is " + elementList.size());

        for (By ele : elementList) {
            Thread.sleep(2000);
            click(ele);
            System.out.println(driver.getTitle());
            waitForElement(homePage.packtLogo);

        }
    }
}




