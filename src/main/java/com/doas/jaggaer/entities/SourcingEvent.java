package com.doas.jaggaer.entities;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.doas.jaggaer.models.CommodityCodeModel;
import com.doas.jaggaer.models.ProductItem;
import com.doas.jaggaer.models.SourcingEventModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;


@Entity
@Table(name="JAG_EVENT_STAGING")
@ApiModel(description = "All details about the sourcing event")
public class SourcingEvent {
    
    @Id
    @SequenceGenerator(name="seq", sequenceName="SEQ_JAG_STAGING")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name="JAG_EVENT_STAGING_PK")
    private Long jagEventStagingPK;
    
    @Column(name = "EVENTNUMBER")
    private String eventNumber;
    
    @Column(name = "EVENTTYPE")
    private String eventType;
    
    @Column(name = "EVENTTITLE")
    private String eventTitle;
    
    @Column(name = "EVENTSTATUS")
    private String eventStatus;
    
    @Column(name = "WORKGROUPCODE")
    private String workGroupCode;

    @Column(name = "DESCRIPTION")
    private String description;
    
    @Column(name = "RELEASEDATE")
    private Timestamp releaseDate;
    
    @Column(name = "OPENDATE")
    private Timestamp openDate;
    
    @Column(name = "CLOSEDATE")
    private Timestamp closeDate;
    
    @Column(name = "ESTIMATEDVALUE")
    private String estimatedValue;
    
    @Column(name = "CREATOR_NAME")
    private String creatorName;
    
    @Column(name = "CREATOR_EMAIL")
    private String creatorEmail;
    
    @Column(name = "CREATOR_PHONE")
    private String creatorPhone;
    
    @JsonManagedReference(value="commoditycode")
    @OneToMany(mappedBy = "jagEventStagingFK", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<CommodityCode> commodityCodes = new ArrayList<CommodityCode>();

    
    public String getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(String eventNumber) {
        this.eventNumber = eventNumber;
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

    public String getWorkGroupCode() {
        return workGroupCode;
    }

    public void setWorkGroupCode(String workGroupCode) {
        this.workGroupCode = workGroupCode;
    }

    public List<CommodityCode> getCommodityCodes() {
        return commodityCodes;
    }

    public void setCommodityCodes(List<CommodityCode> commodityCodes) {
        this.commodityCodes = commodityCodes;
    }

    public void setJagEventStagingPK(Long jagEventStagingPK) {
        this.jagEventStagingPK = jagEventStagingPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Timestamp getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Timestamp openDate) {
        this.openDate = openDate;
    }

    public Timestamp getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Timestamp closeDate) {
        this.closeDate = closeDate;
    }

    public Long getJagEventStagingPK() {
        return jagEventStagingPK;
    }

    public String getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(String estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorEmail() {
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    public String getCreatorPhone() {
        return creatorPhone;
    }

    public void setCreatorPhone(String creatorPhone) {
        this.creatorPhone = creatorPhone;
    }
    
    
    public static SourcingEvent getNewInstance(SourcingEventModel sourcingEventModel) throws ParseException {
        SourcingEvent sourcingEvent = new SourcingEvent();
        sourcingEvent.setEventNumber(sourcingEventModel.getEventNumber());
        sourcingEvent.setEventTitle(sourcingEventModel.getEventTitle());
        sourcingEvent.setEventStatus(sourcingEventModel.getEventStatus());
        sourcingEvent.setEventType(sourcingEventModel.getEventType());
        sourcingEvent.setWorkGroupCode(sourcingEventModel.getWorkGroupCode());
        sourcingEvent.setDescription(sourcingEventModel.getDescription());
        
        if(sourcingEventModel.getEventDates().getReleaseDate() != null) {
            sourcingEvent.setReleaseDate(convertDate(sourcingEventModel.getEventDates().getTimeZone(), sourcingEventModel.getEventDates().getReleaseDate()));
        }
        if(sourcingEventModel.getEventDates().getOpenDate() != null) {
            sourcingEvent.setOpenDate(convertDate(sourcingEventModel.getEventDates().getTimeZone(), sourcingEventModel.getEventDates().getOpenDate()));
        }
        if(sourcingEventModel.getEventDates().getCloseDate() != null) {
            sourcingEvent.setCloseDate(convertDate(sourcingEventModel.getEventDates().getTimeZone(), sourcingEventModel.getEventDates().getCloseDate()));
        }
        
        sourcingEvent.setEstimatedValue(sourcingEventModel.getPaymentDetails().getEstimatedValue());
        sourcingEvent.setCreatorName(sourcingEventModel.getUser().getContacts().get(0).getName());
        sourcingEvent.setCreatorEmail(sourcingEventModel.getUser().getContacts().get(0).getEmail());
        sourcingEvent.setCreatorPhone(sourcingEventModel.getUser().getContacts().get(0).getPhone());
        
        if(sourcingEventModel.getCommodityCodes() != null) {
            CommodityCodeModel commodityCodeModel = sourcingEventModel.getCommodityCodes();
            
            // Adding Reporting Commodity Code
            CommodityCode reportingCommodityCode = CommodityCode.getNewInstance(commodityCodeModel.getReportingCommodityCode(), "Reporting", sourcingEvent);
            sourcingEvent.getCommodityCodes().add(reportingCommodityCode);
            
            // Adding Additional Commodity Code
            for (String code : commodityCodeModel.getAdditionalCommodityCodes()) {
                CommodityCode additionalCommodityCode = CommodityCode.getNewInstance(code, "Additional", sourcingEvent);
                sourcingEvent.getCommodityCodes().add(additionalCommodityCode);
            }
            
            // Adding Item Commodity Code
            for (ProductItem item : sourcingEventModel.getItems()) {
                if(item.getCommodityCode() != null) {
                    CommodityCode itemCommodityCode = CommodityCode.getNewInstance(item.getCommodityCode(), "Item", sourcingEvent);
                    sourcingEvent.getCommodityCodes().add(itemCommodityCode);                    
                }
            }

        }
        return sourcingEvent;
    }
    
    public static SourcingEvent copyInstance(SourcingEvent sourcingEvent,
            SourcingEventModel sourcingEventModel) {
        sourcingEvent.setEventNumber(sourcingEventModel.getEventNumber());
        sourcingEvent.setEventTitle(sourcingEventModel.getEventTitle());
        sourcingEvent.setEventStatus(sourcingEventModel.getEventStatus());
        sourcingEvent.setEventType(sourcingEventModel.getEventType());
        sourcingEvent.setWorkGroupCode(sourcingEventModel.getWorkGroupCode());
        sourcingEvent.setDescription(sourcingEventModel.getDescription());
        return sourcingEvent;
    }
    
    private static Timestamp convertDate(String timeZone, String date) throws ParseException {
        
        if(timeZone.equalsIgnoreCase("EDT") || timeZone.equalsIgnoreCase("EST")) {
            timeZone = "America/New_York";
        }
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        Date releaseDate =  sdf.parse(date);
                    
        TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return Timestamp.valueOf(df.format(releaseDate));
    }
}
