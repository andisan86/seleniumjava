package com.andisan86.e2etest.unittest;

import com.andisan86.e2etest.api.Request;
import com.andisan86.e2etest.transformer.Transformer;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Map;

public class TestRequestTransformer {
    private String BASEURI;
    private String BASEPATH;

    @Parameters({"baseURI","basePath"})
    @BeforeTest
    public void beforeTest(String baseUri, String basePath) {
        BASEURI = baseUri;
        BASEPATH = basePath;
    }

    @Test(dataProvider = "request_city_params", dataProviderClass = TestData.class)
    public void testRequestTransformerCity(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        boolean actualSuccessStatus = transformer.responseCityToPojo(response).getSuccess();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSuccessStatus, "Failed request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_smp_params", dataProviderClass = TestData.class)
    public void testRequestTransformerSchoolSmp(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        boolean actualSuccessStatus = transformer.responseSchoolSmpToPojo(response).getSuccess();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSuccessStatus, "Failed request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_smp_details_params", dataProviderClass = TestData.class)
    public void testRequestTransformerSchoolSmpDetails(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        boolean actualSuccessStatus = transformer.responseSchoolSmpDetailsToPojo(response).getSuccess();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSuccessStatus, "Failed request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_ipa_params", dataProviderClass = TestData.class)
    public void testRequestTransformerSchoolSmaIpa(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        boolean actualSuccessStatus = transformer.responseSchoolSmaIpaToPojo(response).getSuccess();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSuccessStatus, "Failed request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_ipa_details_params", dataProviderClass = TestData.class)
    public void testRequestTransformerSchoolSmaIpaDetails(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        boolean actualSuccessStatus = transformer.responseSchoolSmaIpaDetailsToPojo(response).getSuccess();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSuccessStatus, "Failed request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_ips_params", dataProviderClass = TestData.class)
    public void testRequestTransformerSchoolSmaIps(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        boolean actualSuccessStatus = transformer.responseSchoolSmaIpsToPojo(response).getSuccess();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSuccessStatus, "Failed request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_ips_details_params", dataProviderClass = TestData.class)
    public void testRequestTransformerSchoolSmaIpsDetails(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        boolean actualSuccessStatus = transformer.responseSchoolSmaIpsDetailsToPojo(response).getSuccess();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSuccessStatus, "Failed request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_bahasa_params", dataProviderClass = TestData.class)
    public void testRequestTransformerSchoolSmaBahasa(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        boolean actualSuccessStatus = transformer.responseSchoolSmaBahasaToPojo(response).getSuccess();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSuccessStatus, "Failed request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_sma_bahasa_details_params", dataProviderClass = TestData.class)
    public void testRequestTransformerSchoolSmaBahasaDetails(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        boolean actualSuccessStatus = transformer.responseSchoolSmaBahasaDetailsToPojo(response).getSuccess();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSuccessStatus, "Failed request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_smk_params", dataProviderClass = TestData.class)
    public void testRequestTransformerSchoolSmk(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        boolean actualSuccessStatus = transformer.responseSchoolSmkToPojo(response).getSuccess();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSuccessStatus, "Failed request");
        softAssert.assertAll();
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_smk_details_params", dataProviderClass = TestData.class)
    public void testRequestTransformerSchoolSmkDetails(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        boolean actualSuccessStatus = transformer.responseSchoolSmkDetailsToPojo(response).getSuccess();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSuccessStatus, "Failed request");
        softAssert.assertAll();
    }
}
