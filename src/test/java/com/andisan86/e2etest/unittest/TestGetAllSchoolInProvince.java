package com.andisan86.e2etest.unittest;

import com.andisan86.e2etest.pojo.SchoolSmp;
import com.andisan86.e2etest.transformer.Transformer;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class TestGetAllSchoolInProvince {
    private String testResponseSchoolSmp;

    @BeforeTest
    public void beforeTest() {
        testResponseSchoolSmp = "{\n" +
                "    \"success\": true,\n" +
                "    \"totalRows\": 1344,\n" +
                "    \"rows\": [\n" +
                "        {\n" +
                "            \"jenjang\": \"P\",\n" +
                "            \"kd_prop\": \"01\",\n" +
                "            \"nm_prop\": \"DKI\",\n" +
                "            \"kd_rayon\": \"04\",\n" +
                "            \"nm_rayon\": \"KOTA JAKARTA SELATAN\",\n" +
                "            \"kd_sek\": \"314\",\n" +
                "            \"kd_sek_int\": \"10104314\",\n" +
                "            \"npsn\": \"20106976\",\n" +
                "            \"nm_sek\": \"SMP LABSCHOOL KEBAYORAN\",\n" +
                "            \"jns_sek\": \"1\",\n" +
                "            \"sts_sek\": \"S\",\n" +
                "            \"kd_unbk\": \"1\",\n" +
                "            \"iiun\": \"UNBK\",\n" +
                "            \"kd_studi\": \"TEST\",\n" +
                "            \"jm_pes\": \"221\",\n" +
                "            \"rt_1\": \"89.04\",\n" +
                "            \"rt_2\": \"87.17\",\n" +
                "            \"rt_3\": \"96.17\",\n" +
                "            \"rt_4\": \"88.88\",\n" +
                "            \"rt_5\": \"1.0\",\n" +
                "            \"rt_6\": \"2.0\",\n" +
                "            \"rerata\": \"90.32\",\n" +
                "            \"iiun_17\": \"<B>UNBK</B>\",\n" +
                "            \"rata_17\": \"90.32\",\n" +
                "            \"kode\": \"0104314\",\n" +
                "            \"rata_16\": \" 90.41\",\n" +
                "            \"iiun_16\": \"<B>UNBK</B>\",\n" +
                "            \"rata_15\": \" 92.08\",\n" +
                "            \"iiun_15\": \"<B> 96.69</B>\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    @Test
    public void testResponseSchoolSmp() {
        Transformer transformer = new Transformer();
        SchoolSmp schoolSmp = transformer.responseSchoolSmpToPojo(testResponseSchoolSmp);
        List<SchoolSmp.Row> schoolSmpRows = schoolSmp.getRows();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(schoolSmp.getSuccess(), "Incorrect success value");
        softAssert.assertEquals(schoolSmp.getTotalRows(), Integer.valueOf(1344), "Incorrect totalRows value");
        for (int i = 0; i < schoolSmpRows.size(); i++) {
            softAssert.assertEquals(schoolSmpRows.get(i).getJenjang(), "P", "Incorrect jenjang value");
            softAssert.assertEquals(schoolSmpRows.get(i).getKdProp(), "01", "Incorrect kd_prop value");
            softAssert.assertEquals(schoolSmpRows.get(i).getNmProp(), "DKI", "Incorrect nm_prop value");
            softAssert.assertEquals(schoolSmpRows.get(i).getKdRayon(), "04", "Incorrect kd_rayon");
            softAssert.assertEquals(schoolSmpRows.get(i).getNmRayon(), "KOTA JAKARTA SELATAN", "Incorrect nm_rayon");
            softAssert.assertEquals(schoolSmpRows.get(i).getKdSek(), "314", "Incorrect kd_sek");
            softAssert.assertEquals(schoolSmpRows.get(i).getKdSekInt(), "10104314", "Incorrect kd_sek_int");
            softAssert.assertEquals(schoolSmpRows.get(i).getNpsn(), "20106976", "Incorrect npsn");
            softAssert.assertEquals(schoolSmpRows.get(i).getNmSek(), "SMP LABSCHOOL KEBAYORAN", "Incorrect nm_sek");
            softAssert.assertEquals(schoolSmpRows.get(i).getJnsSek(), "1", "Incorrect jns_sek");
            softAssert.assertEquals(schoolSmpRows.get(i).getStsSek(), "S", "Incorrect sts_sek");
            softAssert.assertEquals(schoolSmpRows.get(i).getKdUnbk(), "1", "Incorrect kd_unbk");
            softAssert.assertEquals(schoolSmpRows.get(i).getIiun(), "UNBK", "Incorrect iiun");
            softAssert.assertEquals(schoolSmpRows.get(i).getKdStudi(), "TEST", "Incorrect kd_studi");
            softAssert.assertEquals(schoolSmpRows.get(i).getJmPes(), "221", "Incorrect jm_pes");
            softAssert.assertEquals(schoolSmpRows.get(i).getRt1(), "89.04", "Incorrect rt_1");
            softAssert.assertEquals(schoolSmpRows.get(i).getRt2(), "87.17", "Incorrect rt_2");
            softAssert.assertEquals(schoolSmpRows.get(i).getRt3(), "96.17", "Incorrect rt_3");
            softAssert.assertEquals(schoolSmpRows.get(i).getRt4(), "88.88", "Incorrect rt_4");
            softAssert.assertEquals(schoolSmpRows.get(i).getRt5(), "1.0", "Incorrect rt_5");
            softAssert.assertEquals(schoolSmpRows.get(i).getRt6(), "2.0", "Incorrect rt_6");
            softAssert.assertEquals(schoolSmpRows.get(i).getRerata(), "90.32", "Incorrect rerata");
            softAssert.assertEquals(schoolSmpRows.get(i).getIiun17(), "<B>UNBK</B>", "Incorrect iiun_17");
            softAssert.assertEquals(schoolSmpRows.get(i).getRata17(), "90.32", "Incorrect rata_17");
            softAssert.assertEquals(schoolSmpRows.get(i).getKode(), "0104314", "Incorrect kode");
            softAssert.assertEquals(schoolSmpRows.get(i).getIiun16(), "<B>UNBK</B>", "Incorrect iiun_16");
            softAssert.assertEquals(schoolSmpRows.get(i).getRata16(), " 90.41", "Incorrect rata_16");
            softAssert.assertEquals(schoolSmpRows.get(i).getIiun15(), "<B> 96.69</B>", "Incorrect iiun_15");
            softAssert.assertEquals(schoolSmpRows.get(i).getRata15(), " 92.08", "Incorrect rata_15");
        }
        softAssert.assertAll();
    }
}
