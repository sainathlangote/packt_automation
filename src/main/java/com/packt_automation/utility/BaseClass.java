package com.packt_automation.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public boolean result;

    public void launchBrowser(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver(setChromeOptions());
                break;
            case "edge":
                driver = new ChromeDriver(setChromeOptions());
                driver.manage().window().maximize();
                break;
            case "firefox":
//                WebDriverManager.firefoxdriver().setup();
                driver.manage().window().maximize();
                break;
            default:
                driver = new ChromeDriver(setChromeOptions());
                driver.manage().window().maximize();
        }
    }
    public void scrollToElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        WebElement element=driver.findElement(by);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void click(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitForElement(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean isDisplayed(By by) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            result = driver.findElement(by).isDisplayed();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void enterText(By by, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            driver.findElement(by).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ChromeOptions setChromeOptions() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("incognito");
//		        option.setHeadless(false);

        return option;
    }

    public FirefoxOptions setFirefoxOptions() {
        FirefoxOptions option = new FirefoxOptions();
        option.addArguments("start-maximized");
        option.addArguments("--remote-allow-origins=*");
//		        option.addArguments("incognito");
//		        option.setHeadless(true);

        return option;
    }

    public EdgeOptions setEdgeOptions() {
        EdgeOptions option = new EdgeOptions();
        option.addArguments("start-maximized");
        option.addArguments("--remote-allow-origins=*");
        option.addArguments("incognito");

        return option;
    }

    public void scroll(int scrollAmount){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + scrollAmount + ")");
    }

}
