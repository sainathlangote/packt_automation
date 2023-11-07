package com.packt_automation.pages;

import org.openqa.selenium.By;

public class ViewAllBookPage {
    public By viewAll= By.xpath("//a[contains(text(),\"View All\")]");
    public By resetAllFilter= By.className("reset-button");
    public By publishedYearDropdown= By.xpath("//div[contains(text(),\"Published Year\")]");
    public By  publishedYear2021= By.xpath("//div[contains(text(),\"2021\") and @class=\"value\"]");
    public By browseLibrary = By.xpath("//nav[@id='packt-navbar']/div[1]/a");
    public By resetAllBtn = By.xpath("//button[text()='Reset All']");
    public By publishedYear = By.xpath("//div[text()='Published Year']");
    public By yearToSelect = By.xpath("//div[text()='2021']");
    public By searchTextField = By.xpath("//div[@class='page-header']//input");
    public By searchBtn = By.xpath("//div[@class='page-header']//input/following-sibling::img");
    public By bookResults = By.xpath("//div[@class='page-right']/div[1]/div//div[@class='product-title mb-3']");
    public By pagination = By.xpath("//div[@class='page-right']/div[2]//button");
    public By nextPage = By.xpath("//div[@class='page-right']/div[2]//button[text()='>']");
}
