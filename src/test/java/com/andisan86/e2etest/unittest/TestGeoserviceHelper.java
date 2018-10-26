package com.andisan86.e2etest.unittest;

import com.andisan86.e2etest.utils.GeoserviceHelper;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestGeoserviceHelper {

    @Parameters("location")
    @Test
    public void testGeoservice(String location) {
        GeoserviceHelper geoserviceHelper = new GeoserviceHelper();
        String latLng = geoserviceHelper.getLatitudeLongitude(location);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(latLng.isEmpty());
        softAssert.assertAll();
    }
}
