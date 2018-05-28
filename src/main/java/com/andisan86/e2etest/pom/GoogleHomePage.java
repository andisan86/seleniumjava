package com.andisan86.e2etest.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Google Page PageFactory
 *
 * @author Andi Santoso
 */
public class GoogleHomePage {
    WebDriver webDriver;
    String pageTitle;

    @FindBy(id = "lst-ib")
    WebElement searchField;

    @FindBy(name = "btnK")
    WebElement searchButton;

    /**
     * Constructor
     *
     * @param webDriver web driver
     */
    public GoogleHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Get page title
     * @return page title
     */
    public String getPageTitle() {
        return webDriver.getTitle();
    }

    /**
     * Get search button
     * @return search button
     */
    public WebElement getSearchButton() {
        return searchButton;
    }

    /**
     * Get search field
     * @return search field
     */
    public WebElement getSearchField() {
        return searchField;
    }

    /**
     * Click search field
     */
    public void clickSearchField() { searchField.click(); }

    /**
     * Type search field
     *
     * @param text text
     */
    public void typeSearchField(String text) { searchField.sendKeys(text); }

    /**
     * Click search button
     */
    public void clickSearchButton() { searchButton.click(); }
}
