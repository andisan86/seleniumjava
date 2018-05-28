package com.andisan86.e2etest.web;

import org.openqa.selenium.WebDriver;

public interface DriverSetup {
    WebDriver getWebDriverObject(String browserExeLocation);
}
