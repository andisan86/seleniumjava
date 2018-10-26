package com.andisan86.e2etest.transformer;

public class DictionaryJenjang {
    public enum Jenjangs {
        P("SMP"),
        U("SMA"),
        K("SMK")
        ;

        private String jenjang;

        Jenjangs(String jenjang) {
            this.jenjang = jenjang;
        }

        public String getJenjang() {
            return jenjang;
        }
    }

    public static String getJenjangForId(String jenjangId) {
        return Jenjangs.valueOf(jenjangId).getJenjang();
    }
}
