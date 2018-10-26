package com.andisan86.e2etest.unittest;

import com.andisan86.e2etest.api.Request;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Map;

public class TestRequestSchool {
    private String BASEURI;
    private String BASEPATH;

    @Parameters({"baseURI","basePath"})
    @BeforeTest
    public void beforeTest(String baseUri, String basePath) {
        BASEURI = baseUri;
        BASEPATH = basePath;
    }

    @Test(dataProvider = "request_city_params", dataProviderClass = TestData.class)
    public void testRequestCity(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        int actualStatusCode = request.postQueryParam(params).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, 200, "Failed city request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_smp_params", dataProviderClass = TestData.class)
    public void testRequestSmp(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        int actualStatusCode = request.postQueryParam(params).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, 200, "Failed SMP request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_smp_details_params", dataProviderClass = TestData.class)
    public void testRequestSmpDetails(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        int actualStatusCode = request.postQueryParam(params).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, 200, "Failed SMP Details request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_ipa_params", dataProviderClass = TestData.class)
    public void testRequestSmaIpa(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        int actualStatusCode = request.postQueryParam(params).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, 200, "Failed SMA IPA request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_ipa_details_params", dataProviderClass = TestData.class)
    public void testRequestSmaIpaDetails(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        int actualStatusCode = request.postQueryParam(params).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, 200, "Failed SMA IPA Details request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_ips_params", dataProviderClass = TestData.class)
    public void testRequestSmaIps(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        int actualStatusCode = request.postQueryParam(params).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, 200, "Failed SMA IPS request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_ips_details_params", dataProviderClass = TestData.class)
    public void testRequestSmaIpsDetails(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        int actualStatusCode = request.postQueryParam(params).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, 200, "Failed SMA IPS Details request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_bahasa_params", dataProviderClass = TestData.class)
    public void testRequestSmaBahasa(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        int actualStatusCode = request.postQueryParam(params).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, 200, "Failed SMA Bahasa request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_bahasa_details_params", dataProviderClass = TestData.class)
    public void testRequestSmaBahasaDetails(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        int actualStatusCode = request.postQueryParam(params).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, 200, "Failed SMA Bahasa Details request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_smk_params", dataProviderClass = TestData.class)
    public void testRequestSmk(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        int actualStatusCode = request.postQueryParam(params).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, 200, "Failed SMK request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_smk_details_params", dataProviderClass = TestData.class)
    public void testRequestSmkDetails(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        int actualStatusCode = request.postQueryParam(params).getStatusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualStatusCode, 200, "Failed SMK Details request");
        softAssert.assertAll();
    }
}
