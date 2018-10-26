package com.andisan86.e2etest.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class GeoserviceHelper {
    private String GOOGLE_APIKEY = "AIzaSyCMKt0w2HOUmy-CwLaCKu_5miFo1LFPbOI";
    private Gson gson;

    public GeoserviceHelper() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public String getLatitudeLongitude(String location) {
        String latLng = "";
        try {
            GeocodingResult[] geocodingResults = getGeocodingResult(location);
            String lat = getLocationLatitude(geocodingResults);
            String lng = getLocationLongitude(geocodingResults);
            latLng = lat + ", " + lng;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latLng;
    }

    private GeocodingResult[] getGeocodingResult(String location) throws Exception {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(GOOGLE_APIKEY)
                .build();
        return GeocodingApi.geocode(context, location).await();
    }

    private String getLocationLatitude(GeocodingResult[] results) {
        return gson.toJson(results[0].geometry.location.lat);
    }

    private String getLocationLongitude(GeocodingResult[] results) {
        return gson.toJson(results[0].geometry.location.lng);
    }
}
