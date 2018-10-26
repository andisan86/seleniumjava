package com.andisan86.e2etest.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "provinces"
})
public class Provinces {

    @JsonProperty("provinces")
    private List<Province> provinces = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("provinces")
    public List<Province> getProvinces() {
        return provinces;
    }

    @JsonProperty("provinces")
    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "cityId",
            "cityName",
            "cityLocation"
    })
    public class City {

        @JsonProperty("cityId")
        private String cityId;
        @JsonProperty("cityName")
        private String cityName;
        @JsonProperty("cityLocation")
        private String cityLocation;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("cityId")
        public String getCityId() {
            return cityId;
        }

        @JsonProperty("cityId")
        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        @JsonProperty("cityName")
        public String getCityName() {
            return cityName;
        }

        @JsonProperty("cityName")
        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        @JsonProperty("cityLocation")
        public String getCityLocation() {
            return cityLocation;
        }

        @JsonProperty("cityLocation")
        public void setCityLocation(String cityLocation) {
            this.cityLocation = cityLocation;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "provinceId",
            "provinceName",
            "cities"
    })
    public class Province {

        @JsonProperty("provinceId")
        private String provinceId;
        @JsonProperty("provinceName")
        private String provinceName;
        @JsonProperty("cities")
        private List<City> cities = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("provinceId")
        public String getProvinceId() {
            return provinceId;
        }

        @JsonProperty("provinceId")
        public void setProvinceId(String provinceId) {
            this.provinceId = provinceId;
        }

        @JsonProperty("provinceName")
        public String getProvinceName() {
            return provinceName;
        }

        @JsonProperty("provinceName")
        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        @JsonProperty("cities")
        public List<City> getCities() {
            return cities;
        }

        @JsonProperty("cities")
        public void setCities(List<City> cities) {
            this.cities = cities;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}
