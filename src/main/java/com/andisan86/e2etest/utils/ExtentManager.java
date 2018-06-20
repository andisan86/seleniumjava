package com.andisan86.e2etest.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.io.File;

/**
 * This class handles initialization of ExtentReports
 *
 * @author Andi Santoso
 */
public class ExtentManager {
    private static PropertyFactory propertyFactory = new PropertyFactory();
    private static ExtentReports extentReports;
    private static String EXTENT_CONFIG_LOCATION;

    /**
     * Create instance of ExtentReports. Synchronized method to avoid thread locking in case we are running parallel
     *
     * @param reportLocation report location
     * @return ExtentReports instance
     */
    public synchronized static ExtentReports createInstance(String reportLocation) {
        EXTENT_CONFIG_LOCATION = propertyFactory.getValueString("extent.config");
        extentReports = new ExtentReports();
        extentReports.attachReporter(createHtmlReporter(reportLocation));
        return extentReports;
    }

    /**
     * Get ExtentReports
     *
     * @return ExtentReports
     */
    public static ExtentReports getExtentReports() {
        return extentReports;
    }

    /**
     * Get extent config location
     *
     * @return extent config location
     */
    public static String getExtentConfigLocation() {
        return EXTENT_CONFIG_LOCATION;
    }

    /**
     * Create HTML reporter instance
     *
     * @return HTML reporter instance
     */
    private static ExtentHtmlReporter createHtmlReporter(String reportLocation) {
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportLocation);
        extentHtmlReporter.loadXMLConfig(new File(EXTENT_CONFIG_LOCATION));
        extentHtmlReporter.setAppendExisting(true);
        return extentHtmlReporter;
    }
}
