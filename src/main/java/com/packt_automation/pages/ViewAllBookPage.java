package com.packt_automation.pages;

import org.openqa.selenium.By;

public class ViewAllBookPage {
    public By viewAll= By.xpath("//a[contains(text(),\"View All\")]");
    public By resetAllFilter= By.className("reset-button");
    public By publishedYearDropdown= By.xpath("//div[contains(text(),\"Published Year\")]");
    public By  publishedYear2021= By.xpath("//div[contains(text(),\"2021\") and @class=\"value\"]");

}
