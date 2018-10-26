package com.andisan86.e2etest.transformer;

public class DictionaryProvinsi {
    public enum Provinsis {
        P01("DKI JAKARTA"),
        P02("JAWA BARAT"),
        P03("JAWA TENGAH"),
        P04("DI YOGYAKARTA"),
        P05("JAWA TIMUR"),
        P06("ACEH"),
        P07("SUMATERA UTARA"),
        P08("SUMATERA BARAT"),
        P09("RIAU"),
        P10("JAMBI"),
        P11("SUMATERA SELATAN"),
        P12("LAMPUNG"),
        P13("KALIMANTAN BARAT"),
        P14("KALIMANTAN TENGAH"),
        P15("KALIMANTAN SELATAN"),
        P16("KALIMANTAN TIMUR"),
        P17("SULAWESI UTARA"),
        P18("SULAWESI TENGAH"),
        P19("SULAWESI SELATAN"),
        P20("SULAWESI TENGGARA"),
        P21("MALUKU"),
        P22("BALI"),
        P23("NUSA TENGGARA BARAT"),
        P24("NUSA TENGGARA TIMUR"),
        P25("PAPUA"),
        P26("BENGKULU"),
        P27("MALUKU UTARA"),
        P28("BANGKA BELITUNG"),
        P29("GORONTALO"),
        P30("BANTEN"),
        P31("KEPULAUAN RIAU"),
        P32("SULAWESI BARAT"),
        P33("PAPUA BARAT"),
        P34("KALIMANTAN UTARA"),
        ;

        private String provinsi;

        Provinsis(String provinsi) {
            this.provinsi = provinsi;
        }

        public String getProvinsi() {
            return provinsi;
        }
    }

    public static String getProvinsiForId(String provinsiId) {
        return Provinsis.valueOf("P" + provinsiId).getProvinsi();
    }
}
