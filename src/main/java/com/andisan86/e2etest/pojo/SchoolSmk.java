package com.andisan86.e2etest.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "success",
        "totalRows",
        "rows"
})
public class SchoolSmk {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("totalRows")
    private Integer totalRows;
    @JsonProperty("rows")
    private List<Row> rows = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("totalRows")
    public Integer getTotalRows() {
        return totalRows;
    }

    @JsonProperty("totalRows")
    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    @JsonProperty("rows")
    public List<Row> getRows() {
        return rows;
    }

    @JsonProperty("rows")
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "jenjang",
            "kd_prop",
            "nm_prop",
            "kd_rayon",
            "nm_rayon",
            "kd_sek",
            "kd_sek_int",
            "npsn",
            "nm_sek",
            "jns_sek",
            "sts_sek",
            "kd_unbk",
            "iiun",
            "kd_studi",
            "jm_pes",
            "rt_1",
            "rt_2",
            "rt_3",
            "rt_4",
            "rt_5",
            "rt_6",
            "rerata",
            "iiun_17",
            "rata_17",
            "kode",
            "rata_16",
            "iiun_16",
            "rata_15",
            "iiun_15"
    })
    public class Row {

        @SerializedName("jenjang")
        private String jenjang;
        @SerializedName("kd_prop")
        private String kdProp;
        @SerializedName("nm_prop")
        private String nmProp;
        @SerializedName("kd_rayon")
        private String kdRayon;
        @SerializedName("nm_rayon")
        private String nmRayon;
        @SerializedName("kd_sek")
        private String kdSek;
        @SerializedName("kd_sek_int")
        private String kdSekInt;
        @SerializedName("npsn")
        private String npsn;
        @SerializedName("nm_sek")
        private String nmSek;
        @SerializedName("jns_sek")
        private String jnsSek;
        @SerializedName("sts_sek")
        private String stsSek;
        @SerializedName("kd_unbk")
        private String kdUnbk;
        @SerializedName("iiun")
        private String iiun;
        @SerializedName("kd_studi")
        private String kdStudi;
        @SerializedName("jm_pes")
        private String jmPes;
        @SerializedName("rt_1")
        private String rt1;
        @SerializedName("rt_2")
        private String rt2;
        @SerializedName("rt_3")
        private String rt3;
        @SerializedName("rt_4")
        private String rt4;
        @SerializedName("rt_5")
        private String rt5;
        @SerializedName("rt_6")
        private String rt6;
        @SerializedName("rerata")
        private String rerata;
        @SerializedName("iiun_17")
        private String iiun17;
        @SerializedName("rata_17")
        private String rata17;
        @SerializedName("kode")
        private String kode;
        @SerializedName("rata_16")
        private String rata16;
        @SerializedName("iiun_16")
        private String iiun16;
        @SerializedName("rata_15")
        private String rata15;
        @SerializedName("iiun_15")
        private String iiun15;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("jenjang")
        public String getJenjang() {
            return jenjang;
        }

        @JsonProperty("jenjang")
        public void setJenjang(String jenjang) {
            this.jenjang = jenjang;
        }

        @JsonProperty("kd_prop")
        public String getKdProp() {
            return kdProp;
        }

        @JsonProperty("kd_prop")
        public void setKdProp(String kdProp) {
            this.kdProp = kdProp;
        }

        @JsonProperty("nm_prop")
        public String getNmProp() {
            return nmProp;
        }

        @JsonProperty("nm_prop")
        public void setNmProp(String nmProp) {
            this.nmProp = nmProp;
        }

        @JsonProperty("kd_rayon")
        public String getKdRayon() {
            return kdRayon;
        }

        @JsonProperty("kd_rayon")
        public void setKdRayon(String kdRayon) {
            this.kdRayon = kdRayon;
        }

        @JsonProperty("nm_rayon")
        public String getNmRayon() {
            return nmRayon;
        }

        @JsonProperty("nm_rayon")
        public void setNmRayon(String nmRayon) {
            this.nmRayon = nmRayon;
        }

        @JsonProperty("kd_sek")
        public String getKdSek() {
            return kdSek;
        }

        @JsonProperty("kd_sek")
        public void setKdSek(String kdSek) {
            this.kdSek = kdSek;
        }

        @JsonProperty("kd_sek_int")
        public String getKdSekInt() {
            return kdSekInt;
        }

        @JsonProperty("kd_sek_int")
        public void setKdSekInt(String kdSekInt) {
            this.kdSekInt = kdSekInt;
        }

        @JsonProperty("npsn")
        public String getNpsn() {
            return npsn;
        }

        @JsonProperty("npsn")
        public void setNpsn(String npsn) {
            this.npsn = npsn;
        }

        @JsonProperty("nm_sek")
        public String getNmSek() {
            return nmSek;
        }

        @JsonProperty("nm_sek")
        public void setNmSek(String nmSek) {
            this.nmSek = nmSek;
        }

        @JsonProperty("jns_sek")
        public String getJnsSek() {
            return jnsSek;
        }

        @JsonProperty("jns_sek")
        public void setJnsSek(String jnsSek) {
            this.jnsSek = jnsSek;
        }

        @JsonProperty("sts_sek")
        public String getStsSek() {
            return stsSek;
        }

        @JsonProperty("sts_sek")
        public void setStsSek(String stsSek) {
            this.stsSek = stsSek;
        }

        @JsonProperty("kd_unbk")
        public String getKdUnbk() {
            return kdUnbk;
        }

        @JsonProperty("kd_unbk")
        public void setKdUnbk(String kdUnbk) {
            this.kdUnbk = kdUnbk;
        }

        @JsonProperty("iiun")
        public String getIiun() {
            return iiun;
        }

        @JsonProperty("iiun")
        public void setIiun(String iiun) {
            this.iiun = iiun;
        }

        @JsonProperty("kd_studi")
        public String getKdStudi() {
            return kdStudi;
        }

        @JsonProperty("kd_studi")
        public void setKdStudi(String kdStudi) {
            this.kdStudi = kdStudi;
        }

        @JsonProperty("jm_pes")
        public String getJmPes() {
            return jmPes;
        }

        @JsonProperty("jm_pes")
        public void setJmPes(String jmPes) {
            this.jmPes = jmPes;
        }

        @JsonProperty("rt_1")
        public String getRt1() {
            return rt1;
        }

        @JsonProperty("rt_1")
        public void setRt1(String rt1) {
            this.rt1 = rt1;
        }

        @JsonProperty("rt_2")
        public String getRt2() {
            return rt2;
        }

        @JsonProperty("rt_2")
        public void setRt2(String rt2) {
            this.rt2 = rt2;
        }

        @JsonProperty("rt_3")
        public String getRt3() {
            return rt3;
        }

        @JsonProperty("rt_3")
        public void setRt3(String rt3) {
            this.rt3 = rt3;
        }

        @JsonProperty("rt_4")
        public String getRt4() {
            return rt4;
        }

        @JsonProperty("rt_4")
        public void setRt4(String rt4) {
            this.rt4 = rt4;
        }

        @JsonProperty("rt_5")
        public String getRt5() {
            return rt5;
        }

        @JsonProperty("rt_5")
        public void setRt5(String rt5) {
            this.rt5 = rt5;
        }

        @JsonProperty("rt_6")
        public String getRt6() {
            return rt6;
        }

        @JsonProperty("rt_6")
        public void setRt6(String rt6) {
            this.rt6 = rt6;
        }

        @JsonProperty("rerata")
        public String getRerata() {
            return rerata;
        }

        @JsonProperty("rerata")
        public void setRerata(String rerata) {
            this.rerata = rerata;
        }

        @JsonProperty("iiun_17")
        public String getIiun17() {
            return iiun17;
        }

        @JsonProperty("iiun_17")
        public void setIiun17(String iiun17) {
            this.iiun17 = iiun17;
        }

        @JsonProperty("rata_17")
        public String getRata17() {
            return rata17;
        }

        @JsonProperty("rata_17")
        public void setRata17(String rata17) {
            this.rata17 = rata17;
        }

        @JsonProperty("kode")
        public String getKode() {
            return kode;
        }

        @JsonProperty("kode")
        public void setKode(String kode) {
            this.kode = kode;
        }

        @JsonProperty("rata_16")
        public String getRata16() {
            return rata16;
        }

        @JsonProperty("rata_16")
        public void setRata16(String rata16) {
            this.rata16 = rata16;
        }

        @JsonProperty("iiun_16")
        public String getIiun16() {
            return iiun16;
        }

        @JsonProperty("iiun_16")
        public void setIiun16(String iiun16) {
            this.iiun16 = iiun16;
        }

        @JsonProperty("rata_15")
        public String getRata15() {
            return rata15;
        }

        @JsonProperty("rata_15")
        public void setRata15(String rata15) {
            this.rata15 = rata15;
        }

        @JsonProperty("iiun_15")
        public String getIiun15() {
            return iiun15;
        }

        @JsonProperty("iiun_15")
        public void setIiun15(String iiun15) {
            this.iiun15 = iiun15;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}
