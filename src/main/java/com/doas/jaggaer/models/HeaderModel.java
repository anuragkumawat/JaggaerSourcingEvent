package com.doas.jaggaer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeaderModel {
    
    @JsonProperty("MessageId")
    private String messageId;
    
    @JsonProperty("Timestamp")
    private String timeStamp;

    @JsonProperty("Authentication")
    private AuthenticationModel authentication;

    
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public AuthenticationModel getAuthentication() {
        return authentication;
    }

    public void setAuthentication(AuthenticationModel authentication) {
        this.authentication = authentication;
    }
    
    

}
