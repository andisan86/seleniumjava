package com.andisan86.e2etest.unittest;

import com.andisan86.e2etest.web.InitBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Unit test for Test Browser
 */
public class TestBrowser {
    private WebDriver webDriver;

    /**
     * Test Browser.
     * <b>PASS</b> if browser name and executable location is same as expected.
     * <b>FAIL</b> if browser name and executable location is not same as expected.
     *
     * @param browserName browser name.
     * @param browserExeLocation browser executable location.
     */
    @Parameters({"browserName", "browserExeLocation"})
    @Test
    public void testBrowser(String browserName, String browserExeLocation) {
        SoftAssert softAssert = new SoftAssert();
        InitBrowser browser = new InitBrowser(browserName, browserExeLocation);
        softAssert.assertEquals(browser.getBrowserName().toUpperCase(), browserName.toUpperCase(), "Incorrect browser name");
        softAssert.assertEquals(browser.getBrowserExeLocation(), browserExeLocation, "Incorrect browser location");
        softAssert.assertAll();
        this.webDriver = browser.getWebDriver();
    }

    /**
     * Test WebDriver.
     * <b>PASS</b> if web driver is not null.
     * <b>FAIL</b> if web driver is null.
     */
    @Test(dependsOnMethods = {"testBrowser"})
    public void testWebDriver() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(webDriver == null, "WebDriver is not created");
        softAssert.assertAll();
    }

    @AfterTest
    public void afterTest() {
        webDriver.close();
    }
}
