package com.andisan86.e2etest.unittest;

import com.andisan86.e2etest.api.Request;
import com.andisan86.e2etest.constants.Variables;
import com.andisan86.e2etest.pojo.SchoolSmp;
import com.andisan86.e2etest.transformer.Transformer;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class TestRequestSchoolPagination {
    private String BASEURI;
    private String BASEPATH;

    @Parameters({"baseURI","basePath"})
    @BeforeTest
    public void beforeTest(String baseUri, String basePath) {
        BASEURI = baseUri;
        BASEPATH = basePath;
    }

    @Parameters({"baseURI","basePath"})
    @Test(dataProvider = "request_smp_params", dataProviderClass = TestData.class)
    public void testRequestSchoolSmpPagination(Map<String, String> params) {
        Request request = new Request(BASEURI, BASEPATH);
        params.put("start", Variables.getSearchStart());
        params.put("limit", Variables.getSearchLimit());
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        SchoolSmp schoolSmp = transformer.responseSchoolSmpToPojo(response);
        int totalRows = schoolSmp.getTotalRows();
        int maxPageNum = (int)Math.ceil(totalRows/Variables.getUpperSearchLimitDouble());
        System.out.println(totalRows);
        System.out.println(maxPageNum);
        //for (int start = 0; start < maxPageNum*Variables.getUpperSearchLimitInt(); start = start+Variables.getUpperSearchLimitInt()) {
        //    System.out.println(start + " --- limit: " + Variables.getSearchLimit());
        //}
        int start = 0;
        do {
            System.out.println("start: " + start + "  ---  limit: " + Variables.getSearchLimit());
            start = start + Variables.getUpperSearchLimitInt();
        } while(start < maxPageNum*Variables.getUpperSearchLimitInt());
    }
}
