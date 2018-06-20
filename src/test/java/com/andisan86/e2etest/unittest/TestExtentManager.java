package com.andisan86.e2etest.unittest;

import com.andisan86.e2etest.utils.ExtentManager;
import com.andisan86.e2etest.utils.PropertyFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Unit tests for ExtentManager
 *
 * @author Andi Santoso
 */
public class TestExtentManager {
    private static PropertyFactory propertyFactory = new PropertyFactory();
    private ExtentReports extentReports;
    private ExtentTest extentTest;

    /**
     * Create ExtentReports
     */
    @Parameters({"extentReportLocation"})
    @BeforeTest
    public void beforeTest(String extentReportLocation) {
        extentReports = ExtentManager.createInstance(extentReportLocation);
    }

    /**
     * Test if ExtentReports object is created
     */
    @Test
    public void testExtentReportsCreated() {
        SoftAssert softAssert = new SoftAssert();
        Assert.assertFalse(ExtentManager.getExtentReports() == null, "ExtentReports is not created");
        softAssert.assertAll();
    }

    /**
     * Test correct default extent config location
     */
    @Test
    public void testExtentConfigLocation() {
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(ExtentManager.getExtentConfigLocation(), propertyFactory.getValueString("extent.config"), "Incorrect report config location");
        softAssert.assertAll();
    }

    /**
     * Test pass status is logged, and test should be marked as Pass
     */
    @Test
    public void testAddPassStep() {
        extentTest = extentReports.createTest("Pass Test Step");
        extentTest.log(Status.PASS, "Pass step");
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(extentTest.getStatus().equals(Status.PASS), "Incorrect status");
        softAssert.assertAll();
    }

    /**
     * Test info status is logged, and test should be marked as Pass
     */
    @Test
    public void testInfoStep() {
        extentTest = extentReports.createTest("Info Test Step");
        extentTest.log(Status.INFO, "Info step");
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(extentTest.getStatus().equals(Status.PASS), "Incorrect status");
        softAssert.assertAll();
    }

    /**
     * Test combinations of pass, fail and info steps are logged. Test should be marked as Fail
     */
    @Test
    public void testFailStep() {
        extentTest = extentReports.createTest("Fail Test Step");
        extentTest.log(Status.PASS, "Pass step");
        extentTest.log(Status.FAIL, "Fail step");
        extentTest.log(Status.INFO, "Info step");
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(extentTest.getStatus().equals(Status.FAIL), "Incorrect status");
        softAssert.assertAll();
    }

    /**
     * Flush ExtentReports
     */
    @AfterTest
    public void afterTest() {
        extentReports.flush();
    }
}
