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
        "rows",
        "totalRows"
})
public class SchoolSmpDetails {

    @JsonProperty("success")
    private Boolean success;
    @JsonProperty("rows")
    private List<Row> rows = null;
    @JsonProperty("totalRows")
    private Integer totalRows;
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

    @JsonProperty("rows")
    public List<Row> getRows() {
        return rows;
    }

    @JsonProperty("rows")
    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    @JsonProperty("totalRows")
    public Integer getTotalRows() {
        return totalRows;
    }

    @JsonProperty("totalRows")
    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
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
            "kd_jenjang",
            "kd_studi",
            "kd_bhs",
            "kd_uji",
            "nm_uji",
            "nm_pendek",
            "urutan",
            "urutan_studi",
            "urutan_unp",
            "n_17",
            "n_16",
            "n_15",
            "highlight"
    })
    public class Row {

        @SerializedName("kd_jenjang")
        private String kdJenjang;
        @SerializedName("kd_studi")
        private String kdStudi;
        @SerializedName("kd_bhs")
        private String kdBhs;
        @SerializedName("kd_uji")
        private String kdUji;
        @SerializedName("nm_uji")
        private String nmUji;
        @SerializedName("nm_pendek")
        private String nmPendek;
        @SerializedName("urutan")
        private String urutan;
        @SerializedName("urutan_studi")
        private String urutanStudi;
        @SerializedName("urutan_unp")
        private String urutanUnp;
        @SerializedName("n_17")
        private String n17;
        @SerializedName("n_16")
        private String n16;
        @SerializedName("n_15")
        private String n15;
        @SerializedName("highlight")
        private String highlight;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("kd_jenjang")
        public String getKdJenjang() {
            return kdJenjang;
        }

        @JsonProperty("kd_jenjang")
        public void setKdJenjang(String kdJenjang) {
            this.kdJenjang = kdJenjang;
        }

        @JsonProperty("kd_studi")
        public String getKdStudi() {
            return kdStudi;
        }

        @JsonProperty("kd_studi")
        public void setKdStudi(String kdStudi) {
            this.kdStudi = kdStudi;
        }

        @JsonProperty("kd_bhs")
        public String getKdBhs() {
            return kdBhs;
        }

        @JsonProperty("kd_bhs")
        public void setKdBhs(String kdBhs) {
            this.kdBhs = kdBhs;
        }

        @JsonProperty("kd_uji")
        public String getKdUji() {
            return kdUji;
        }

        @JsonProperty("kd_uji")
        public void setKdUji(String kdUji) {
            this.kdUji = kdUji;
        }

        @JsonProperty("nm_uji")
        public String getNmUji() {
            return nmUji;
        }

        @JsonProperty("nm_uji")
        public void setNmUji(String nmUji) {
            this.nmUji = nmUji;
        }

        @JsonProperty("nm_pendek")
        public String getNmPendek() {
            return nmPendek;
        }

        @JsonProperty("nm_pendek")
        public void setNmPendek(String nmPendek) {
            this.nmPendek = nmPendek;
        }

        @JsonProperty("urutan")
        public String getUrutan() {
            return urutan;
        }

        @JsonProperty("urutan")
        public void setUrutan(String urutan) {
            this.urutan = urutan;
        }

        @JsonProperty("urutan_studi")
        public String getUrutanStudi() {
            return urutanStudi;
        }

        @JsonProperty("urutan_studi")
        public void setUrutanStudi(String urutanStudi) {
            this.urutanStudi = urutanStudi;
        }

        @JsonProperty("urutan_unp")
        public String getUrutanUnp() {
            return urutanUnp;
        }

        @JsonProperty("urutan_unp")
        public void setUrutanUnp(String urutanUnp) {
            this.urutanUnp = urutanUnp;
        }

        @JsonProperty("n_17")
        public String getN17() {
            return n17;
        }

        @JsonProperty("n_17")
        public void setN17(String n17) {
            this.n17 = n17;
        }

        @JsonProperty("n_16")
        public String getN16() {
            return n16;
        }

        @JsonProperty("n_16")
        public void setN16(String n16) {
            this.n16 = n16;
        }

        @JsonProperty("n_15")
        public String getN15() {
            return n15;
        }

        @JsonProperty("n_15")
        public void setN15(String n15) {
            this.n15 = n15;
        }

        @JsonProperty("highlight")
        public String getHighlight() {
            return highlight;
        }

        @JsonProperty("highlight")
        public void setHighlight(String highlight) {
            this.highlight = highlight;
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
