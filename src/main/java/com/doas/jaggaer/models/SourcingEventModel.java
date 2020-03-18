package com.doas.jaggaer.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SourcingEventModel {
    
    @JsonProperty("EventNumber")
    private String eventNumber;
    
    @JsonProperty("EventType")
    private String eventType;
    
    @JsonProperty("EventTitle")
    private String eventTitle;
    
    @JsonProperty("EventStatus")
    private String eventStatus;
    
    @JsonProperty("WorkGroupCode")
    private String workGroupCode;
    
    @JsonProperty("Description")
    private String description;
    
    @JsonProperty("EventDates")
    private EventDateModel eventDates;
    
    @JsonProperty("PaymentDetails")
    private PaymentDetailModel paymentDetails;
    
    @JsonProperty("CommodityCodes")
    private CommodityCodeModel commodityCodes;
    
    @JsonProperty("Users")
    private User user;
    
    @JsonProperty("Items")
    private List<ProductItem> items;
    

    public List<ProductItem> getItems() {
        return items;
    }

    public void setItems(List<ProductItem> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(String eventNumber) {
        this.eventNumber = eventNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventDateModel getEventDates() {
        return eventDates;
    }

    public void setEventDates(EventDateModel eventDates) {
        this.eventDates = eventDates;
    }

    public CommodityCodeModel getCommodityCodes() {
        return commodityCodes;
    }

    public void setCommodityCodes(CommodityCodeModel commodityCodes) {
        this.commodityCodes = commodityCodes;
    }

    public PaymentDetailModel getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetailModel paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getWorkGroupCode() {
        return workGroupCode;
    }

    public void setWorkGroupCode(String workGroupCode) {
        this.workGroupCode = workGroupCode;
    }

    
    
}
