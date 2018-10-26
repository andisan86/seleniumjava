package com.andisan86.e2etest.unittest;

import com.andisan86.e2etest.pojo.CityProfile;
import com.andisan86.e2etest.scenarios.GetCityProfile;
import com.andisan86.e2etest.transformer.Transformer;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.BufferedReader;
import java.io.FileReader;

public class TestRequestCity {
    private String CITY_PROFILE_JSON_FILE = "src/main/resources/cityprofile.json";

    @Parameters({"baseURI","basePath"})
    @Test(enabled = false)
    public void testPrintCityProfile(String baseURI, String basePath) {
        GetCityProfile getCityProfile = new GetCityProfile(baseURI, basePath);
        getCityProfile.printCityProfile();
    }

    @Test
    public void testCityProfileContent() throws Exception {
        Transformer transformer = new Transformer();
        GetCityProfile getCityProfile = new GetCityProfile();
        BufferedReader reader = getCityProfile.getCityProfileAsReader();
        CityProfile cityProfile = transformer.responseCityProfileToPojo(reader);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getProvinceNameById(cityProfile, "24"), "NUSA TENGGARA TIMUR");
        softAssert.assertEquals(getCityNameById(cityProfile, "09", "01"), "KOTA PEKANBARU");
        softAssert.assertEquals(getCityLocationById(cityProfile, "34", "05"), "3.551869, 117.0794082");
        softAssert.assertAll();
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
                        return city.getCityLocation();
                    }
                }
            }
        }
        return null;
    }

    /*
    public void createCityProfileByProvince() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode provincesNode = mapper.createObjectNode();
        JsonNode provincePropNode = mapper.createArrayNode();
        for (Provinces provinces : Provinces.values()) {
            String provinceId = provinces.getProvinceId();
            List<City.Row> rows = getCityByProvinceIdRows(provinceId);
            JsonNode province = mapper.createObjectNode();
            ((ObjectNode) province).put("provinceId", provinceId);
            ((ObjectNode) province).put("provinceName", DictionaryProvinsi.getProvinsiForId(provinceId));
            JsonNode citiesPropNode = mapper.createArrayNode();
            for (int i = 0; i<rows.size(); i++) {
                String cityKey = rows.get(i).getKey();
                String cityName = stripCityNameFromId(rows.get(i).getValue());
                String cityLocation = geoserviceHelper.getLatitudeLongitude(cityName);
                JsonNode cityNode = mapper.createObjectNode();
                ((ObjectNode) cityNode).put("cityId", cityKey);
                ((ObjectNode) cityNode).put("cityName", cityName);
                ((ObjectNode) cityNode).put("cityLocation", cityLocation);
                ((ArrayNode) citiesPropNode).add(cityNode);
            }
            ((ObjectNode) province).put("cities", citiesPropNode);
            ((ArrayNode) provincePropNode).add(province);
        }
        ((ObjectNode) provincesNode).set("provinces", provincePropNode);
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(provincesNode);
        printToFile(jsonString);
    }

    private List<City.Row> getCityByProvinceIdRows(String provinceId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", provinceId);
        Request request = new Request(BASEURI, BASEPATH);
        Response response = request.postQueryParam(params);
        Transformer transformer = new Transformer();
        City city = transformer.responseCityToPojo(response);
        return city.getRows();
    }

    private void printToFile(String jsonString) {
        try {
            FileWriter file = new FileWriter(CITY_PROFILE_JSON_FILE);
            file.write(jsonString);
            file.flush();
        } catch (Exception e) {
        }
    }

    private String stripCityNameFromId(String cityName) {
        int firstAlphabetIndex = cityName.indexOf(CITY_ID_SEPARATOR) + CITY_ID_FIRST_ALPHABET_INDEX;
        int strLen = cityName.length();
        return cityName.substring(firstAlphabetIndex, strLen);
    }
    */
}
