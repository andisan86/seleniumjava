package com.andisan86.e2etest.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * This class handles browser request and attempt to create a webdriver of that browser.
 *
 * @author Andi Santoso
 */
public class InitBrowser {
    /**
     * Enum of supported driver types: FIREFOX, CHROME, HEADLESS (Chrome variant)
     */
    public enum DriverType implements DriverSetup {
        FIREFOX {
            public WebDriver getWebDriverObject(String browserExeLocation) {
                System.setProperty("webdriver.gecko.driver", browserExeLocation);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(Arrays.asList("--start-maximized"));
                return new FirefoxDriver(firefoxOptions);
            }
        },
        CHROME {
            public WebDriver getWebDriverObject(String browserExeLocation) {
                System.setProperty("webdriver.chrome.driver", browserExeLocation);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(Arrays.asList("--start-maximized"));
                return new ChromeDriver(chromeOptions);
            }
        },
        HEADLESS {
            public WebDriver getWebDriverObject(String browserExeLocation) {
                System.setProperty("webdriver.chrome.driver", browserExeLocation);
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(Arrays.asList("--start-maximized"));
                chromeOptions.addArguments("headless");
                return new ChromeDriver(chromeOptions);
            }
        }
    }

    private String browserName;
    private String browserExeLocation;
    private DriverType driverType;
    protected int DEFAULT_IMPLICIT_WAIT_SECONDS = 10;

    /**
     * Constructor
     *
     * @param browserName browser name
     * @param browserExeLocation browser executable location
     */
    public InitBrowser(String browserName, String browserExeLocation) {
        this.browserName = browserName;
        this.browserExeLocation = browserExeLocation;
        driverType = DriverType.valueOf(browserName.toUpperCase());
    }

    /**
     * Create webdriver with 10 seconds implicit wait
     * @return webdriver
     */
    public WebDriver getWebDriver() {
        WebDriver webDriver = driverType.getWebDriverObject(browserExeLocation);
        webDriver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
        return webDriver;
    }

    /**
     * Get browser executable location
     * @return browser executable location
     */
    public String getBrowserExeLocation() { return browserExeLocation; }

    /**
     * Get browser name
     * @return browser name
     */
    public String getBrowserName() { return browserName; }
}
