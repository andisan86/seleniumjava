package com.andisan86.e2etest.unittest;

import com.andisan86.e2etest.transformer.DictionaryJenjang;
import com.andisan86.e2etest.transformer.DictionaryProvinsi;
import com.andisan86.e2etest.transformer.DictionaryStatus;
import com.andisan86.e2etest.utils.ElasticsearchHelper;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;
import java.util.Map;

public class TestIndexToElasticsearch {
    private String INDEX_NAME = "";
    private String INDEX_TYPE = "";
    private Map<String, Object> INDEX_CONTENT;
    private String INDEX_ID = "";

    @Parameters({"indexName", "indexType"})
    @BeforeTest
    public void beforeTest(String indexName, String indexType) {
        INDEX_NAME = indexName;
        INDEX_TYPE = indexType;
        INDEX_CONTENT = new HashMap<String, Object>();
        INDEX_CONTENT.put("npsn", "20106976");
        INDEX_CONTENT.put("jenjang", DictionaryJenjang.getJenjangForId("P"));
        INDEX_CONTENT.put("nama", "SMP LABSCHOOL KEBAYORAN");
        INDEX_CONTENT.put("provinsi", DictionaryProvinsi.getProvinsiForId("01"));
        INDEX_CONTENT.put("kota", "KOTA JAKARTA SELATAN");
        INDEX_CONTENT.put("status", DictionaryStatus.getStatusForId("S"));
        INDEX_CONTENT.put("jm_pes", "221");
        INDEX_CONTENT.put("rata_17", "90.32");
        INDEX_CONTENT.put("rata_16", "90.41");
        INDEX_CONTENT.put("rata_15", "92.68");
        INDEX_CONTENT.put("location", "-6.2615, 106.8106");
        ElasticsearchHelper.connectToEs();
        ElasticsearchHelper.createIndex(indexName);
        ElasticsearchHelper.createMappingSchoolSmp(indexName, indexType);
    }

    @Test
    public void testPostToEs() {
        IndexResponse indexResponse = ElasticsearchHelper.indexToEs(INDEX_NAME, INDEX_TYPE, INDEX_CONTENT);
        INDEX_ID = indexResponse.getId();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(indexResponse.status().getStatus(), 201, "Invalid status");
        softAssert.assertAll();
    }

    //@Test(dependsOnMethods = "testPostToEs")
    public void testGetIndexFromEs() {
        GetResponse getResponse = ElasticsearchHelper.getIndex(INDEX_NAME,INDEX_TYPE, INDEX_ID);
        String responseIndexId = getResponse.getId();
        String responseNpsn = getResponse.getSource().get("npsn").toString();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseIndexId, INDEX_ID, "Incorrect index id");
        softAssert.assertEquals(responseNpsn, "20106976", "Incorrect npsn value");
        softAssert.assertAll();
    }

    //@Test(dependsOnMethods = "testGetIndexFromEs")
    public void testDeleteIndexFromEs() {
        DeleteResponse deleteResponse = ElasticsearchHelper.deleteIndex(INDEX_NAME, INDEX_TYPE, INDEX_ID);
        String responseIndexId = deleteResponse.getId();
        String responseStatus = deleteResponse.status().toString();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseIndexId, INDEX_ID, "Incorrect index id");
        softAssert.assertEquals(responseStatus, "OK", "Invalid status");
        softAssert.assertAll();
    }

    @AfterTest
    public void afterTest() {
        ElasticsearchHelper.closeEsConnection();
    }
}
