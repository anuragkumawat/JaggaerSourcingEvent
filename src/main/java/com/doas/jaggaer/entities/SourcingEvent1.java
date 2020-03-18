//package com.doas.jaggaer.entities;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//import com.doas.jaggaer.models.SourcingEventModel;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import io.swagger.annotations.ApiModel;
//
//
//@Entity
//@ApiModel(description = "All details about the sourcing event")
//public class SourcingEvent {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_JG_STAGING")
//    private String pk;
//    
//    @Column(name = "event_number")
//    private String eventNumber;
//    
//    @Column(name = "event_type")
//    private String eventType;
//    
//    @Column(name = "event_title")
//    private String eventTitle;
//    
//    @Column(name = "event_status")
//    private String eventStatus;
//    
//    @Column(name = "work_group")
//    private String workGroup;
//    
//    @Column(name = "stage_number")
//    private int stageNumber;
//    
//    @Column(name = "description")
//    private String description;
//    
//    
//    @JsonManagedReference(value="eventDate")
//    @OneToOne(mappedBy = "sourcingEvent", cascade = CascadeType.ALL)
//    private EventDate eventDate;
//    
//    @JsonManagedReference(value="paymentDetail")
//    @OneToOne(mappedBy = "sourcingEvent", cascade = CascadeType.ALL)
//    private PaymentDetail paymentDetail;
//    
//    @JsonManagedReference(value="businessUnitAssociation")
//    @OneToOne(mappedBy = "sourcingEvent", cascade = CascadeType.ALL)
//    private BusinessUnitAssociation businessUnitAssociation;
//    
//    @JsonManagedReference(value="commodityCode")
//    @OneToOne(mappedBy = "sourcingEvent", cascade = CascadeType.ALL)
//    private CommodityCode commodityCode;
//
//
//    public String getEventNumber() {
//        return eventNumber;
//    }
//
//    public void setEventNumber(String eventNumber) {
//        this.eventNumber = eventNumber;
//    }
//
//    public String getEventType() {
//        return eventType;
//    }
//
//    public void setEventType(String eventType) {
//        this.eventType = eventType;
//    }
//
//    public String getEventTitle() {
//        return eventTitle;
//    }
//
//    public void setEventTitle(String eventTitle) {
//        this.eventTitle = eventTitle;
//    }
//
//    public String getEventStatus() {
//        return eventStatus;
//    }
//
//    public void setEventStatus(String eventStatus) {
//        this.eventStatus = eventStatus;
//    }
//
//    public String getWorkGroup() {
//        return workGroup;
//    }
//
//    public void setWorkGroup(String workGroup) {
//        this.workGroup = workGroup;
//    }
//
//    public int getStageNumber() {
//        return stageNumber;
//    }
//
//    public void setStageNumber(int stageNumber) {
//        this.stageNumber = stageNumber;
//    }
//    
//    
//    
//    public BusinessUnitAssociation getBusinessUnitAssociation() {
//        return businessUnitAssociation;
//    }
//
//    public void setBusinessUnitAssociation(BusinessUnitAssociation businessUnitAssociation) {
//        this.businessUnitAssociation = businessUnitAssociation;
//    }
//
//
//    public EventDate getEventDate() {
//        return eventDate;
//    }
//
//    public void setEventDate(EventDate eventDate) {
//        this.eventDate = eventDate;
//    }
//
//    public PaymentDetail getPaymentDetail() {
//        return paymentDetail;
//    }
//
//    public void setPaymentDetail(PaymentDetail paymentDetail) {
//        this.paymentDetail = paymentDetail;
//    }
//
//    public CommodityCode getCommodityCode() {
//        return commodityCode;
//    }
//
//    public void setCommodityCode(CommodityCode commodityCode) {
//        this.commodityCode = commodityCode;
//    }
//
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public static SourcingEvent getNewInstance(SourcingEventModel sourcingEventModel) {
//        SourcingEvent sourcingEvent = new SourcingEvent();
//        sourcingEvent.setEventNumber(sourcingEventModel.getEventNumber());
//        sourcingEvent.setEventTitle(sourcingEventModel.getEventTitle());
//        sourcingEvent.setEventStatus(sourcingEventModel.getEventStatus());
//        sourcingEvent.setEventType(sourcingEventModel.getEventType());
//        sourcingEvent.setStageNumber(sourcingEventModel.getStageNumber());
//        sourcingEvent.setWorkGroup(sourcingEventModel.getWorkGroup());
//        sourcingEvent.setDescription(sourcingEventModel.getDescription());
//        sourcingEvent.setPaymentDetail(PaymentDetail.getNewInstance(sourcingEvent, sourcingEventModel));
//        sourcingEvent.setEventDate(EventDate.getNewInstance(sourcingEvent, sourcingEventModel));
//        sourcingEvent.setBusinessUnitAssociation(BusinessUnitAssociation.getNewInstance(sourcingEvent, sourcingEventModel));
//        sourcingEvent.setCommodityCode(CommodityCode.getNewInstance(sourcingEvent, sourcingEventModel));
//        return sourcingEvent;
//    }
//    
//    public static SourcingEvent copyInstance(SourcingEvent sourcingEvent, SourcingEventModel sourcingEventModel) {
//        sourcingEvent.setEventNumber(sourcingEventModel.getEventNumber());
//        sourcingEvent.setEventTitle(sourcingEventModel.getEventTitle());
//        sourcingEvent.setEventStatus(sourcingEventModel.getEventStatus());
//        sourcingEvent.setEventType(sourcingEventModel.getEventType());
//        sourcingEvent.setStageNumber(sourcingEventModel.getStageNumber());
//        sourcingEvent.setWorkGroup(sourcingEventModel.getWorkGroup());
//        sourcingEvent.setDescription(sourcingEventModel.getDescription());
//        sourcingEvent.setEventDate(EventDate.copyInstance(sourcingEvent.getEventDate(), sourcingEventModel.getEventDates()));
//        sourcingEvent.setPaymentDetail(PaymentDetail.copyInstance(sourcingEvent.getPaymentDetail(), sourcingEventModel.getPaymentDetails()));
//        sourcingEvent.setBusinessUnitAssociation(BusinessUnitAssociation.copyInstance(sourcingEvent.getBusinessUnitAssociation(), sourcingEventModel.getBusinessUnitAssociations()));
//        sourcingEvent.setCommodityCode(CommodityCode.copyInstance(sourcingEvent.getCommodityCode(), sourcingEventModel.getCommodityCodes()));
//        return sourcingEvent;
//    }
//
//    
//    
//    
//    
//}
