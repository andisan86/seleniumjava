package com.andisan86.e2etest.unittest;

import com.andisan86.e2etest.api.RequestLogin;
import com.andisan86.e2etest.utils.PropertyFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Unit test for Request Login class
 */
public class TestRequestLogin {
    private RequestLogin requestLogin;
    private PropertyFactory propertyFactory;

    /**
     * Create Request Login object
     */
    @BeforeTest
    public void beforeTest() {
        propertyFactory = new PropertyFactory();
        requestLogin = new RequestLogin(propertyFactory.getValueString("test.baseuri"), propertyFactory.getValueString("test.basepath"));
    }

    /**
     * Test Request Login object
     * @param baseURI expected base URI
     * @param basePath expected base path
     */
    @Parameters({"baseURI","basePath"})
    @Test
    public void testRequestLogin(String baseURI, String basePath) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(requestLogin.getBaseURI(), baseURI);
        softAssert.assertEquals(requestLogin.getBasePath(), basePath);
        softAssert.assertAll();
    }
}
