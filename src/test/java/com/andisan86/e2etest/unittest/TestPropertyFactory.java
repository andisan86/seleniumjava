package com.andisan86.e2etest.unittest;

import com.andisan86.e2etest.utils.PropertyFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Unit test for PropertyFactory
 */
public class TestPropertyFactory {
    private PropertyFactory propertyFactory;

    @BeforeTest
    public void beforeTest() {
        this.propertyFactory = new PropertyFactory();
    }

    /**
     * Test PropertyFactory
     * <b>PASS</b> if property value is same as expected
     * <b>FAIL</b> if property value is not same as expected value
     *
     * @param expectedPropertyKey expected property key
     * @param expectedPropertyValue expected property value
     */
    @Parameters({"expectedPropertyKey", "expectedPropertyValue"})
    @Test
    public void testPropertyFactory(String expectedPropertyKey, String expectedPropertyValue) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(propertyFactory.getValueString(expectedPropertyKey), expectedPropertyValue, "Incorrect property value");
        softAssert.assertAll();
    }
}

