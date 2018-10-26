package com.andisan86.e2etest.constants;

public enum Jenjang {
    JENJANG_SMP("P"),
    JENJANG_SMA("U"),
    JENJANG_SMK("K")
    ;

    private String jenjangId;

    Jenjang(String jenjangId) {
        this.jenjangId = jenjangId;
    }

    public String getJenjangId() {
        return jenjangId;
    }
}
