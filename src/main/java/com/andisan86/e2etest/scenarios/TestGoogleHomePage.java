package com.andisan86.e2etest.scenarios;

import com.andisan86.e2etest.pom.GoogleHomePage;
import com.andisan86.e2etest.web.InitBrowser;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Test Google Home Page
 *
 * @author Andi Santoso
 */
public class TestGoogleHomePage {
    private WebDriver webDriver;
    private GoogleHomePage googleHomePage;
    private static Logger LOGGER = LogManager.getLogger(TestGoogleHomePage.class);

    /**
     * Create browser session
     *
     * @param browserName browser name
     * @param browserExeLocation browser executable location
     * @param url URL
     */
    @Parameters({"browserName","browserExeLocation", "url"})
    @BeforeTest
    public void beforeTest(String browserName, String browserExeLocation, String url) {
        LOGGER.info("Begin test by initiate browser: " + browserName);
        InitBrowser browser = new InitBrowser(browserName, browserExeLocation);
        webDriver = browser.getWebDriver();
        webDriver.get(url);
    }

    /**
     * Test Google Home Page
     */
    @Test
    public void testGoogleHomePage() {
        LOGGER.info("Test Google Home Page");
        googleHomePage = new GoogleHomePage(webDriver);
        SoftAssert softAssert = new SoftAssert();
        // verification
        softAssert.assertEquals(googleHomePage.getPageTitle(), "Google", "Page title is not Google");
        softAssert.assertTrue(googleHomePage.getSearchButton().isDisplayed(), "Search button is not displayed");
        softAssert.assertTrue(googleHomePage.getSearchButton().isEnabled(), "Search button is not enabled");
        softAssert.assertTrue(googleHomePage.getSearchField().isDisplayed(), "Search field is not displayed");
        softAssert.assertTrue(googleHomePage.getSearchField().isEnabled(), "Search field is not enabled");
        softAssert.assertAll();
    }

    /**
     * Destroy browser session
     */
    @AfterTest
    public void afterTest() {
        LOGGER.info("Finish test");
        webDriver.close();
    }
}

