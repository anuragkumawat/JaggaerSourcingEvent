package com.doas.jaggaer.models;

import java.util.Random;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SourcingEventResponseHeader {

    @JsonProperty("MessageId")
    private String messageId;
    
    @JsonProperty("RelatedMessageId")
    private String relatedMessageId;
    
    @JsonProperty("Timestamp")
    private String timeStamp;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getRelatedMessageId() {
        return relatedMessageId;
    }

    public void setRelatedMessageId(String relatedMessageId) {
        this.relatedMessageId = relatedMessageId;
    }

    public String getTimeStamp() {      
        
        return timeStamp;
                
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    
    public static SourcingEventResponseHeader getNewInstance(String relatedMessageId) {

        SourcingEventResponseHeader sourcingEventResponseHeader = new SourcingEventResponseHeader();
        Random rand = new Random();
        sourcingEventResponseHeader.setMessageId(String.valueOf(rand.nextInt(1000)));
        
        sourcingEventResponseHeader.setRelatedMessageId(relatedMessageId);
        
        DateTime dateTime = DateTime.now();
        String currentDateTime = dateTime.toString("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        sourcingEventResponseHeader.setTimeStamp(currentDateTime);        
        return sourcingEventResponseHeader;
    }
    
}
