package com.doas.jaggaer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SourcingEventExportModel {
    
    private String version;
    
    @JsonProperty("Header")
    private HeaderModel header;
    
    @JsonProperty("SourcingEvent")
    private SourcingEventModel sourcingEvent;

    public SourcingEventModel getSourcingEvent() {
        return sourcingEvent;
    }

    public void setSourcingEvent(SourcingEventModel sourcingEvent) {
        this.sourcingEvent = sourcingEvent;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public HeaderModel getHeader() {
        return header;
    }

    public void setHeader(HeaderModel header) {
        this.header = header;
    }

 

}
