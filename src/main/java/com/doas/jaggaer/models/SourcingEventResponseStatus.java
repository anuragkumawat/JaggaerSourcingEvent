package com.doas.jaggaer.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SourcingEventResponseStatus {

    @JsonProperty("StatusCode")
    private int statusCode;
    
    @JsonProperty("StatusText")
    private String statusText;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }
    
    
    public static SourcingEventResponseStatus getNewInstance(int statusCode, String statusText) {

        SourcingEventResponseStatus sourcingEventResponseStatus = new SourcingEventResponseStatus();
        sourcingEventResponseStatus.setStatusCode(statusCode);
        sourcingEventResponseStatus.setStatusText(statusText);
        return sourcingEventResponseStatus;
    }
    
}
