package com.packt_automation;

import com.packt_automation.pages.HomePage;
import com.packt_automation.pages.LoginPage;
import com.packt_automation.utility.BaseClass;
import com.packt_automation.utility.PropertyHandling;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;

public class CarouselOfBooks extends BaseClass {
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
    public void checkTitles() throws InterruptedException {
        homePage = new HomePage();

        scrollToElement(homePage.slickList);
        Thread.sleep(5000);
        List<WebElement> bookCarousel = driver.findElements(homePage.bookTitlesCarousel);
        System.out.println("Total no of books "+bookCarousel.size());
        int cnt = 1;
        /*bookCarousel.forEach(book->{
            System.out.println(book.getText());
           cnt++;
        });*/
        for (WebElement book:bookCarousel) {
//            if(cnt>bookCarousel.size()){

            System.out.println(book.getText());


            try {
                if (cnt % 3 == 0 &&  driver.findElement(homePage.slickArrow).isDisplayed()) {
                    click(homePage.slickArrow);
                    waitForElement(homePage.slickArrow);

                }
            }catch (Exception e){
                System.out.println(" ");
            }
//            Thread.sleep(5000);
            waitForElement(homePage.slickArrow);
            cnt++;
//                break;
//            }
        }


        /*waitForElement(homePage.viewAll);


//        bookCarousel.get(1);
        for (WebElement book : bookCarousel) {

            scrollToElement(homePage.slickArrow);
//            scroll(150);
            try {
                waitForElement(homePage.bookTitlesCarousel);
                book.click();
//                scroll(-300);
                waitForElement(homePage.bookResult);

                waitForElement(homePage.bookResult);
                System.out.println(book.getText());
                System.out.println(driver.findElement(homePage.bookResult).getText());

                String expectedBook = book.getText();
                String actualBook = driver.findElement(homePage.bookResult).getText();
                if (expectedBook.contains(actualBook)) {
                    System.out.println("Test case pass");
                } else {
                    System.err.println("Test case failed");
                }
                System.out.println(cnt);
                cnt=cnt+1;

            } catch (Exception e) {
                e.printStackTrace();
            }

        }*/
    }
}
