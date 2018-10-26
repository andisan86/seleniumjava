package com.andisan86.e2etest.scenarios;

import com.andisan86.e2etest.api.Request;
import com.andisan86.e2etest.constants.Provinces;
import com.andisan86.e2etest.pojo.City;
import com.andisan86.e2etest.transformer.DictionaryProvinsi;
import com.andisan86.e2etest.transformer.Transformer;
import com.andisan86.e2etest.utils.GeoserviceHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.response.Response;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetCityProfile {
    private String BASEURI;
    private String BASEPATH;
    private GeoserviceHelper geoserviceHelper;
    private String CITY_ID_SEPARATOR = ".";
    private int CITY_ID_FIRST_ALPHABET_INDEX = 2;
    private String CITY_PROFILE_JSON_FILE = "src/main/resources/cityprofile.json";

    public GetCityProfile() {
    }

    public GetCityProfile(String baseURI, String basePath) {
        BASEURI = baseURI;
        BASEPATH = basePath;
        geoserviceHelper = new GeoserviceHelper();
    }

    public void printCityProfile() {
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
        String jsonString = "";
        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(provincesNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        printToFile(jsonString);
    }

    public BufferedReader getCityProfileAsReader() throws Exception {
        return new BufferedReader(new FileReader(CITY_PROFILE_JSON_FILE));
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
}
