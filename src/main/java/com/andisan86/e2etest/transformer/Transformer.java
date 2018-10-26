package com.andisan86.e2etest.transformer;

import com.andisan86.e2etest.pojo.*;
import com.google.gson.Gson;
import io.restassured.response.Response;

import java.io.Reader;

public class Transformer {

    public City responseCityToPojo(Response response) {
        return new Gson().fromJson(response.getBody().asString(), City.class);
    }

    public SchoolSmp responseSchoolSmpToPojo(Response response) {
        return new Gson().fromJson(response.getBody().asString(), SchoolSmp.class);
    }

    public SchoolSmp responseSchoolSmpToPojo(String response) {
        return new Gson().fromJson(response, SchoolSmp.class);
    }

    public SchoolSmpDetails responseSchoolSmpDetailsToPojo(Response response) {
        return new Gson().fromJson(response.getBody().asString(), SchoolSmpDetails.class);
    }

    public SchoolSmaIpa responseSchoolSmaIpaToPojo(Response response) {
        return new Gson().fromJson(response.getBody().asString(), SchoolSmaIpa.class);
    }

    public SchoolSmaIpaDetails responseSchoolSmaIpaDetailsToPojo(Response response) {
        return new Gson().fromJson(response.getBody().asString(), SchoolSmaIpaDetails.class);
    }

    public SchoolSmaIps responseSchoolSmaIpsToPojo(Response response) {
        return new Gson().fromJson(response.getBody().asString(), SchoolSmaIps.class);
    }

    public SchoolSmaIpsDetails responseSchoolSmaIpsDetailsToPojo(Response response) {
        return new Gson().fromJson(response.getBody().asString(), SchoolSmaIpsDetails.class);
    }

    public SchoolSmaBahasa responseSchoolSmaBahasaToPojo(Response response) {
        return new Gson().fromJson(response.getBody().asString(), SchoolSmaBahasa.class);
    }

    public SchoolSmaBahasaDetails responseSchoolSmaBahasaDetailsToPojo(Response response) {
        return new Gson().fromJson(response.getBody().asString(), SchoolSmaBahasaDetails.class);
    }

    public SchoolSmk responseSchoolSmkToPojo(Response response) {
        return new Gson().fromJson(response.getBody().asString(), SchoolSmk.class);
    }

    public SchoolSmkDetails responseSchoolSmkDetailsToPojo(Response response) {
        return new Gson().fromJson(response.getBody().asString(), SchoolSmkDetails.class);
    }

    public CityProfile responseCityProfileToPojo(Reader response) { return new Gson().fromJson(response, CityProfile.class); }
}
