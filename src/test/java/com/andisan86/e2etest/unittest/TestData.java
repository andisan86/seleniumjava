package com.andisan86.e2etest.unittest;

import org.testng.annotations.DataProvider;
import java.util.HashMap;
import java.util.Map;

public class TestData {
    @DataProvider(name = "request_city_params")
    public Object[][] createRequestCityParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", "01");
        return new Object[][] {
                {params},
        };
    }

    @DataProvider(name = "request_smp_params")
    public Object[][] createRequestSmpParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", "01");
        params.put("jenjang", "P");
        return new Object[][] {
                {params},
        };
    }

    @DataProvider(name = "request_smp_details_params")
    public Object[][] createRequestSmpDetailsParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", "01");
        params.put("jenjang", "P");
        params.put("kd_rayon", "04");
        params.put("kd_sek", "314");
        params.put("kd_studi", "");
        return new Object[][] {
                {params},
        };
    }

    @DataProvider(name = "request_sma_ipa_params")
    public Object[][] createRequestSmaIpaParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", "01");
        params.put("jenjang", "P");
        params.put("kd_studi", "A");
        return new Object[][] {
                {params},
        };
    }

    @DataProvider(name = "request_sma_ipa_details_params")
    public Object[][] createRequestSmaIpaDetailsParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", "01");
        params.put("jenjang", "U");
        params.put("kd_rayon", "04");
        params.put("kd_sek", "008");
        params.put("kd_studi", "A");
        return new Object[][] {
                {params},
        };
    }

    @DataProvider(name = "request_sma_ips_params")
    public Object[][] createRequestSmaIpsParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", "01");
        params.put("jenjang", "U");
        params.put("kd_studi", "S");
        return new Object[][] {
                {params},
        };
    }

    @DataProvider(name = "request_sma_ips_details_params")
    public Object[][] createRequestSmaIpsDetailsParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", "01");
        params.put("jenjang", "U");
        params.put("kd_rayon", "04");
        params.put("kd_sek", "008");
        params.put("kd_studi", "S");
        return new Object[][] {
                {params},
        };
    }

    @DataProvider(name = "request_sma_bahasa_params")
    public Object[][] createRequestSmaBahasaParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", "01");
        params.put("jenjang", "U");
        params.put("kd_studi", "B");
        return new Object[][] {
                {params},
        };
    }

    @DataProvider(name = "request_sma_bahasa_details_params")
    public Object[][] createRequestSmaBahasaDetailsParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", "01");
        params.put("jenjang", "U");
        params.put("kd_rayon", "01");
        params.put("kd_sek", "048");
        params.put("kd_studi", "B");
        return new Object[][] {
                {params},
        };
    }

    @DataProvider(name = "request_smk_params")
    public Object[][] createRequestSmkParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", "01");
        params.put("jenjang", "K");
        params.put("kd_studi", "");
        return new Object[][] {
                {params},
        };
    }

    @DataProvider(name = "request_smk_details_params")
    public Object[][] createRequestSmkDetailsParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("kd_prop", "01");
        params.put("jenjang", "K");
        params.put("kd_rayon", "01");
        params.put("kd_sek", "071");
        params.put("kd_studi", "");
        return new Object[][] {
                {params},
        };
    }
}
