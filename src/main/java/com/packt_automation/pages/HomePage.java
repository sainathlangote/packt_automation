package com.packt_automation.pages;

import org.openqa.selenium.By;

public class HomePage {
    public By navBarElements = By.xpath("//nav[@id='packt-navbar']/*");
    public By allElements = By.xpath("//*");
    public By packtLogo = By.xpath("//img[@alt='Packt Logo']");
    public By browseLibrary = By.xpath("//a[text()=\"Browse Library\" and @class=\"nav-link\" ]");
    public By advancedSearch = By.xpath("//button[text()=\"Advanced Search\"]");
    public By searchTitles = By.xpath("//input[@name=\"query\"]");
    public By searchButton = By.xpath("//button[@type=\"submit\"]");
    public By myLibraryDropdown = By.id("library-dropdown"); //6 dropdown values present
    public By myLibraryDropdownValues = By.xpath("//div[@class=\"dropdown-menu show\"]/a[i]");
    public By recentsDropdown = By.id("recent-dropdown"); //currently no content is in recents dropdown
    public By recentsDropdownValues = By.xpath("//div[@class=\"dropdown-menu show\"]/div");
    //    public By userAccount = By.className("user-account nav-link");
    public By signOut = By.xpath("//a[text()=\"Sign Out\" and @class=\"style-1 d-none d-lg-inline nav-link\"]");

    public By startFreeTrialButton = By.xpath("//a[contains(text(),'Start FREE trial')]");
    public By editYourPreferenceHereLink = By.xpath("//a[contains(text(),\"edit your preferences here\")]");
    public By addToPlaylist = By.xpath("//button[contains(text(),\"Add to Playlist\")]");
    public By cart=By.xpath("//svg[@data-v-0781054e]");
    public By bookTitlesCarousel = By.xpath("//div[@class='carousel-author-date']/preceding-sibling::div//h5");
    public By bookResult = By.xpath("//div[@class='main-content-wrapper']//div[@class='col-sm-9']//h2");
    public By slickArrow =By.xpath("//button[@class='slick-arrow slick-next']");
    public By viewAll=By.xpath("//a[text()='view all']");
    public By slickList=By.xpath("//div[@class='slick-list']");
}
