package com.andisan86.e2etest.constants;

public enum SmaType {
    SMA_TYPE_IPA("A"),
    SMA_TYPE_IPS("S"),
    SMA_TYPE_BAHASA("B")
    ;

    private String smaTypeId;

    SmaType(String smaTypeId) {
        this.smaTypeId = smaTypeId;
    }

    public String getSmaTypeId() {
        return smaTypeId;
    }
}
