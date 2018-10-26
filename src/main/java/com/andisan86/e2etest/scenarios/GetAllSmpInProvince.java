package com.andisan86.e2etest.scenarios;

import com.andisan86.e2etest.api.Request;
import com.andisan86.e2etest.constants.Variables;
import com.andisan86.e2etest.pojo.CityProfile;
import com.andisan86.e2etest.pojo.GeoPoint;
import com.andisan86.e2etest.pojo.SchoolSmp;
import com.andisan86.e2etest.transformer.Transformer;
import com.andisan86.e2etest.utils.ElasticsearchHelper;
import io.restassured.response.Response;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllSmpInProvince {
    private String BASEURI;
    private String BASEPATH;
    private String INDEX_NAME = "";
    private String INDEX_TYPE = "";
    private static Logger LOGGER = LogManager.getLogger(ElasticsearchHelper.class);
    private CityProfile cityProfile;

    @Parameters({"baseURI","basePath","indexName","indexType"})
    @BeforeTest
    public void beforeTest(String baseUri, String basePath, String indexName, String indexType) throws Exception {
        BASEURI = baseUri;
        BASEPATH = basePath;
        INDEX_NAME = indexName;
        INDEX_TYPE = indexType;
        ElasticsearchHelper.connectToEs();
        ElasticsearchHelper.createIndex(indexName);
        ElasticsearchHelper.createMappingSchoolSmp(indexName, indexType);
        cityProfile = getCityProfile();
    }

    @Test(dataProvider = "data_provinces", dataProviderClass = Variables.class)
    public void importSchoolSmpDataToEs(Map<String, String> params) {
        int start = 0;
        int maxPageNum = Variables.getUpperSearchLimitInt();
        do {
            SchoolSmp schoolSmp = null;
            Throwable t = null;
            Request request = null;
            Response response = null;
            Transformer transformer = new Transformer();
            try {
                request = new Request(BASEURI, BASEPATH);
                params.put("start", Integer.toString(start));
                params.put("limit", Integer.toString(maxPageNum));
                response = request.postQueryParam(params);
                schoolSmp = transformer.responseSchoolSmpToPojo(response);
                int totalRows = schoolSmp.getTotalRows();
                maxPageNum = (int)Math.ceil(totalRows/Variables.getUpperSearchLimitDouble());
            } catch (Exception e) {
                t = e;
                LOGGER.error(e);
            } finally {
                if (t == null) {
                    List<SchoolSmp.Row> rows = schoolSmp.getRows();
                    int rowSize = rows.size();
                    if (!rows.isEmpty()) {
                        for (int i = 0; i < rowSize; i++) {
                            Map<String, Object> indexContent = new HashMap<String, Object>();
                            indexContent.put("npsn", rows.get(i).getNpsn());
                            indexContent.put("jenjang", rows.get(i).getJenjang());
                            indexContent.put("nama", rows.get(i).getNmSek());
                            String provinsiId = rows.get(i).getKdProp();
                            String provinsi = getProvinceNameById(cityProfile, provinsiId);
                            indexContent.put("provinsi", provinsi);
                            String kotaId = rows.get(i).getKdRayon();
                            String kota = getCityNameById(cityProfile, provinsiId, kotaId);
                            indexContent.put("kota", kota);
                            indexContent.put("status", rows.get(i).getStsSek());
                            indexContent.put("jm_pes", rows.get(i).getJmPes());
                            indexContent.put("rata_17", rataStringToDouble(rows.get(i).getRata17()));
                            indexContent.put("rata_16", rataStringToDouble(rows.get(i).getRata16()));
                            indexContent.put("rata_15", rataStringToDouble(rows.get(i).getRata15()));
                            indexContent.put("location", getCityLocationById(cityProfile, provinsiId, kotaId));
                            ElasticsearchHelper.indexToEs(INDEX_NAME, INDEX_TYPE, indexContent);
                        }
                    }
                }
            }
            start = start + Variables.getUpperSearchLimitInt();
        } while(start < maxPageNum*Variables.getUpperSearchLimitInt());
    }

    private Double rataStringToDouble(String rataString) {
        rataString.trim();
        if (rataString.equalsIgnoreCase("-")) {
            return 0.0;
        } else {
            return Double.valueOf(rataString);
        }
    }

    private CityProfile getCityProfile() throws Exception {
        Transformer transformer = new Transformer();
        GetCityProfile getCityProfile = new GetCityProfile();
        BufferedReader reader = getCityProfile.getCityProfileAsReader();
        return transformer.responseCityProfileToPojo(reader);
    }

    private String getProvinceNameById(CityProfile cityProfile, String provinceId) {
        for (CityProfile.Province province : cityProfile.getProvinces()) {
            if (province.getProvinceId().equalsIgnoreCase(provinceId)) {
                return province.getProvinceName();
            }
        }
        return null;
    }

    private String getCityNameById(CityProfile cityProfile, String provinceId, String cityId) {
        for (CityProfile.Province province : cityProfile.getProvinces()) {
            if (province.getProvinceId().equalsIgnoreCase(provinceId)) {
                for (CityProfile.City city : province.getCities()) {
                    if (city.getCityId().equalsIgnoreCase(cityId)) {
                        return city.getCityName();
                    }
                }
            }
        }
        return null;
    }

    private String getCityLocationById(CityProfile cityProfile, String provinceId, String cityId) {
        for (CityProfile.Province province : cityProfile.getProvinces()) {
            if (province.getProvinceId().equalsIgnoreCase(provinceId)) {
                for (CityProfile.City city : province.getCities()) {
                    if (city.getCityId().equalsIgnoreCase(cityId)) {
                        //List<Double> latLonDouble = parseLatLonString(city.getCityLocation());
                        //return new GeoPoint(latLonDouble.get(0), latLonDouble.get(1));
                        return city.getCityLocation();
                    }
                }
            }
        }
        return null;
    }

    private List<Double> parseLatLonString(String latLon) {
        int indexOfComma = latLon.indexOf(",");
        String lat = latLon.substring(0, indexOfComma);
        String lon = latLon.substring(indexOfComma+1, latLon.length());
        List<Double> latLonDouble = new ArrayList<Double>();
        latLonDouble.add(Double.valueOf(lat));
        latLonDouble.add(Double.valueOf(lon));
        return latLonDouble;
    }

/*
    @Test(dependsOnMethods = "getSchoolSmpData")
    public void importSchoolSmpDataToEs() {
        for (int i = 0; i < ROW_SIZE; i++) {
            Map indexContent = new HashMap<String, Object>();
            indexContent.put("npsn", ROWS.get(i).getNpsn());
            indexContent.put("jenjang", ROWS.get(i).getJenjang());
            indexContent.put("nama", ROWS.get(i).getNmSek());
            indexContent.put("provinsi", ROWS.get(i).getKdProp());
            indexContent.put("kota", ROWS.get(i).getKdRayon());
            indexContent.put("status", ROWS.get(i).getStsSek());
            indexContent.put("jm_pes", ROWS.get(i).getJmPes());
            indexContent.put("rata_17", ROWS.get(i).getRata17());
            indexContent.put("rata_16", ROWS.get(i).getRata16());
            indexContent.put("rata_15", ROWS.get(i).getRata15());
            ElasticsearchHelper.indexToEs(INDEX_NAME, INDEX_TYPE, indexContent);
        }
    }
*/
    @AfterTest
    public void afterTest() {
        ElasticsearchHelper.closeEsConnection();
    }
}
