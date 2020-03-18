package com.doas.jaggaer.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommodityCodeModel {
    
    @JsonProperty("ReportingCommodityCode")
    private String reportingCommodityCode;
    
    @JsonProperty("AdditionalCommodityCodes")
    private List<String> additionalCommodityCodes;

    public String getReportingCommodityCode() {
        return reportingCommodityCode;
    }

    public void setReportingCommodityCode(String reportingCommodityCode) {
        this.reportingCommodityCode = reportingCommodityCode;
    }

    public List<String> getAdditionalCommodityCodes() {
        return additionalCommodityCodes;
    }

    public void setAdditionalCommodityCodes(List<String> additionalCommodityCodes) {
        this.additionalCommodityCodes = additionalCommodityCodes;
    }
    
    

}
