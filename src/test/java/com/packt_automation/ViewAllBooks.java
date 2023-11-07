package com.packt_automation;

import com.packt_automation.pages.HomePage;
import com.packt_automation.pages.LoginPage;
import com.packt_automation.pages.ViewAllBookPage;
import com.packt_automation.utility.BaseClass;
import com.packt_automation.utility.PropertyHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewAllBooks extends BaseClass {

    PropertyHandling propertyHandling;
    LoginPage loginPage;
    HomePage homePage;
    ViewAllBookPage viewAllBookPage;

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
    public void searchBooks() throws InterruptedException {

        viewAllBookPage = new ViewAllBookPage();
        click(viewAllBookPage.viewAll);
        click(viewAllBookPage.browseLibrary);
        click(viewAllBookPage.resetAllFilter);
        click(viewAllBookPage.publishedYearDropdown);
        click(viewAllBookPage.publishedYear2021);

        List<String> searchText = new ArrayList<>();
        searchText.add("Python");
        searchText.add("Paint");
        searchText.add("Secure");
        searchText.add("Tableau");

        for (String text : searchText) {
            System.out.println("-------------------------------------------------------------");
            System.out.println(text);
            System.out.println("-------------------------------------------------------------");
            waitForElement(viewAllBookPage.searchTextField);
            driver.findElement(viewAllBookPage.searchTextField).clear();
            enterText(viewAllBookPage.searchTextField, text);
            Thread.sleep(1000);
            click(viewAllBookPage.searchBtn);
            waitForElement(viewAllBookPage.bookResults);
            List<WebElement> pagination = driver.findElements(viewAllBookPage.pagination);
            System.out.println("Number of pages are " + pagination.size());

            List<WebElement> nameOfBooks;

            for (int j = 1; j <= pagination.size(); j++) {
                System.out.println("------------------------------------------------------------");
                System.out.println("Page no " + j);
                System.out.println("------------------------------------------------------------");
                nameOfBooks = driver.findElements(viewAllBookPage.bookResults);
                for (int i = 0; i < nameOfBooks.size(); i++) {
                    nameOfBooks = driver.findElements(viewAllBookPage.bookResults);

                    WebElement ele = nameOfBooks.get(i);
                    Thread.sleep(1000);
                    System.out.println(ele.getText());
                    Thread.sleep(1000);
                }
                driver.findElement(By.xpath("//div[@class='pagination-wrapper']/div/button[" + j + "]")).click();
                Thread.sleep(2000);
            }
            Thread.sleep(5000);
        }

    }
}


