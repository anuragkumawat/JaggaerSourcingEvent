package com.doas.jaggaer.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SourcingEventResponse {
    
    @JsonProperty("Status")
    private SourcingEventResponseStatus status;
    
    @JsonProperty("Error")
    private SourcingEventResponseError error;

   
    
    public SourcingEventResponseStatus getStatus() {
        return status;
    }



    public void setStatus(SourcingEventResponseStatus status) {
        this.status = status;
    }



    public SourcingEventResponseError getError() {
        return error;
    }



    public void setError(SourcingEventResponseError error) {
        this.error = error;
    }



    public static SourcingEventResponse getNewInstance(int statusCode, String statusText, String errorMessage) {
        SourcingEventResponse sourcingEventResponse = new SourcingEventResponse();
        sourcingEventResponse.setStatus(SourcingEventResponseStatus.getNewInstance(statusCode, statusText));
        if(errorMessage != null) {
            sourcingEventResponse.setError(SourcingEventResponseError.getNewInstance(errorMessage));            
        }
        return sourcingEventResponse;
    }

}
