package com.andisan86.e2etest.constants;

import org.testng.annotations.DataProvider;
import java.util.HashMap;
import java.util.Map;

public class Variables {
    static final String SEARCH_START = "0";
    static final String SEARCH_LIMIT = "100";
    static final double UPPER_SEARCH_LIMIT_DOUBLE = 100.0;
    static final int UPPER_SEARCH_LIMIT_INT = 100;

    public static String getSearchStart() {
        return SEARCH_START;
    }

    public static String getSearchLimit() {
        return SEARCH_LIMIT;
    }

    public static double getUpperSearchLimitDouble() { return UPPER_SEARCH_LIMIT_DOUBLE; }

    public static int getUpperSearchLimitInt() { return UPPER_SEARCH_LIMIT_INT; }

    @DataProvider(name = "data_provinces")
    public Object[][] createDateProvinces() {
        Map<String, String> params1 = new HashMap<String, String>();
        Map<String, String> params2 = new HashMap<String, String>();
        Map<String, String> params3 = new HashMap<String, String>();
        Map<String, String> params4 = new HashMap<String, String>();
        Map<String, String> params5 = new HashMap<String, String>();
        Map<String, String> params6 = new HashMap<String, String>();
        Map<String, String> params7 = new HashMap<String, String>();
        Map<String, String> params8 = new HashMap<String, String>();
        Map<String, String> params9 = new HashMap<String, String>();
        Map<String, String> params10 = new HashMap<String, String>();
        Map<String, String> params11 = new HashMap<String, String>();
        Map<String, String> params12 = new HashMap<String, String>();
        Map<String, String> params13 = new HashMap<String, String>();
        Map<String, String> params14 = new HashMap<String, String>();
        Map<String, String> params15 = new HashMap<String, String>();
        Map<String, String> params16 = new HashMap<String, String>();
        Map<String, String> params17 = new HashMap<String, String>();
        Map<String, String> params18 = new HashMap<String, String>();
        Map<String, String> params19 = new HashMap<String, String>();
        Map<String, String> params20 = new HashMap<String, String>();
        Map<String, String> params21 = new HashMap<String, String>();
        Map<String, String> params22 = new HashMap<String, String>();
        Map<String, String> params23 = new HashMap<String, String>();
        Map<String, String> params24 = new HashMap<String, String>();
        Map<String, String> params25 = new HashMap<String, String>();
        Map<String, String> params26 = new HashMap<String, String>();
        Map<String, String> params27 = new HashMap<String, String>();
        Map<String, String> params28 = new HashMap<String, String>();
        Map<String, String> params29 = new HashMap<String, String>();
        Map<String, String> params30 = new HashMap<String, String>();
        Map<String, String> params31 = new HashMap<String, String>();
        Map<String, String> params32 = new HashMap<String, String>();
        Map<String, String> params33 = new HashMap<String, String>();
        Map<String, String> params34 = new HashMap<String, String>();
        params1.put("kd_prop", Provinces.PROVINCE_01.getProvinceId());
        params1.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params2.put("kd_prop", Provinces.PROVINCE_02.getProvinceId());
        params2.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params3.put("kd_prop", Provinces.PROVINCE_03.getProvinceId());
        params3.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params4.put("kd_prop", Provinces.PROVINCE_04.getProvinceId());
        params4.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params5.put("kd_prop", Provinces.PROVINCE_05.getProvinceId());
        params5.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params6.put("kd_prop", Provinces.PROVINCE_06.getProvinceId());
        params6.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params7.put("kd_prop", Provinces.PROVINCE_07.getProvinceId());
        params7.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params8.put("kd_prop", Provinces.PROVINCE_08.getProvinceId());
        params8.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params9.put("kd_prop", Provinces.PROVINCE_09.getProvinceId());
        params9.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params10.put("kd_prop", Provinces.PROVINCE_10.getProvinceId());
        params10.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params11.put("kd_prop", Provinces.PROVINCE_11.getProvinceId());
        params11.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params12.put("kd_prop", Provinces.PROVINCE_12.getProvinceId());
        params12.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params13.put("kd_prop", Provinces.PROVINCE_13.getProvinceId());
        params13.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params14.put("kd_prop", Provinces.PROVINCE_14.getProvinceId());
        params14.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params15.put("kd_prop", Provinces.PROVINCE_15.getProvinceId());
        params15.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params16.put("kd_prop", Provinces.PROVINCE_16.getProvinceId());
        params16.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params17.put("kd_prop", Provinces.PROVINCE_17.getProvinceId());
        params17.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params18.put("kd_prop", Provinces.PROVINCE_18.getProvinceId());
        params18.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params19.put("kd_prop", Provinces.PROVINCE_19.getProvinceId());
        params19.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params20.put("kd_prop", Provinces.PROVINCE_20.getProvinceId());
        params20.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params21.put("kd_prop", Provinces.PROVINCE_21.getProvinceId());
        params21.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params22.put("kd_prop", Provinces.PROVINCE_22.getProvinceId());
        params22.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params23.put("kd_prop", Provinces.PROVINCE_23.getProvinceId());
        params23.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params24.put("kd_prop", Provinces.PROVINCE_24.getProvinceId());
        params24.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params25.put("kd_prop", Provinces.PROVINCE_25.getProvinceId());
        params25.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params26.put("kd_prop", Provinces.PROVINCE_26.getProvinceId());
        params26.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params27.put("kd_prop", Provinces.PROVINCE_27.getProvinceId());
        params27.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params28.put("kd_prop", Provinces.PROVINCE_28.getProvinceId());
        params28.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params29.put("kd_prop", Provinces.PROVINCE_29.getProvinceId());
        params29.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params30.put("kd_prop", Provinces.PROVINCE_30.getProvinceId());
        params30.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params31.put("kd_prop", Provinces.PROVINCE_31.getProvinceId());
        params31.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params32.put("kd_prop", Provinces.PROVINCE_32.getProvinceId());
        params32.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params33.put("kd_prop", Provinces.PROVINCE_33.getProvinceId());
        params33.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());
        params34.put("kd_prop", Provinces.PROVINCE_34.getProvinceId());
        params34.put("jenjang", Jenjang.JENJANG_SMP.getJenjangId());

        return new Object[][] {
                {params1},
                {params2},
                {params3},
                {params4},
                {params5},
                {params6},
                {params7},
                {params8},
                {params9},
                {params10},
                {params11},
                {params12},
                {params13},
                {params14},
                {params15},
                {params16},
                {params17},
                {params18},
                {params19},
                {params20},
                {params21},
                {params22},
                {params23},
                {params24},
                {params25},
                {params26},
                {params27},
                {params28},
                {params29},
                {params30},
                {params31},
                {params32},
                {params33},
                {params34},
        };
    }
}
