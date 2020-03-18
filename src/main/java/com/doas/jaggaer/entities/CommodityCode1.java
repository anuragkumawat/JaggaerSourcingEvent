//package com.doas.jaggaer.entities;
//
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import com.doas.jaggaer.models.CommodityCodeModel;
//import com.doas.jaggaer.models.SourcingEventModel;
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//@Entity
//public class CommodityCode {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private Long id;
//    
//    @Column(name = "reporting_commodity_code")
//    private String reportingCommodityCode;
// 
//    @JsonBackReference(value="commodityCode")
//    @OneToOne
//    @JoinColumn(name = "event_number")
//    private SourcingEvent sourcingEvent;
//    
//    @JsonManagedReference(value="additionalCommodityCodes")
//    @OneToMany(mappedBy = "commodityCode", cascade = CascadeType.ALL, orphanRemoval=true)
//    private List<AdditionalCommodityCode> additionalCommodityCodes;
//
//    
//    public List<AdditionalCommodityCode> getAdditionalCommodityCodes() {
//        return additionalCommodityCodes;
//    }
//
//    public void setAdditionalCommodityCodes(List<AdditionalCommodityCode> additionalCommodityCodes) {
//        this.additionalCommodityCodes = additionalCommodityCodes;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getReportingCommodityCode() {
//        return reportingCommodityCode;
//    }
//
//    public void setReportingCommodityCode(String reportingCommodityCode) {
//        this.reportingCommodityCode = reportingCommodityCode;
//    }
//
//    public SourcingEvent getSourcingEvent() {
//        return sourcingEvent;
//    }
//
//    public void setSourcingEvent(SourcingEvent sourcingEvent) {
//        this.sourcingEvent = sourcingEvent;
//    }
//
//    
//    public static CommodityCode getNewInstance(SourcingEvent sourcingEvent, SourcingEventModel sourcingEventModel) {
//        CommodityCode commodityCode = new CommodityCode();
//        commodityCode.setSourcingEvent(sourcingEvent);
//        commodityCode.setReportingCommodityCode(sourcingEventModel.getCommodityCodes().getReportingCommodityCode());
//        
//        List<AdditionalCommodityCode> additionalCommodityCodes = new ArrayList<AdditionalCommodityCode>();
//        for(String additionalCommodityCode : sourcingEventModel.getCommodityCodes().getAdditionalCommodityCodes()) {
//            additionalCommodityCodes.add(AdditionalCommodityCode.getNewInstance(commodityCode, additionalCommodityCode));
//        }
//        
//        commodityCode.setAdditionalCommodityCodes(additionalCommodityCodes);
//        return commodityCode;
//    }
//    
//    public static CommodityCode copyInstance(CommodityCode commodityCode, CommodityCodeModel commodityCodeModel) {
//        commodityCode.setReportingCommodityCode(commodityCodeModel.getReportingCommodityCode());
//       
//        commodityCode.getAdditionalCommodityCodes().clear();
//        
//        List<AdditionalCommodityCode> additionalCommodityCodes = new ArrayList<AdditionalCommodityCode>();
//        for(String additionalCommodityCode : commodityCodeModel.getAdditionalCommodityCodes()) {
//            additionalCommodityCodes.add(AdditionalCommodityCode.getNewInstance(commodityCode, additionalCommodityCode));
//        }
//        
//        commodityCode.getAdditionalCommodityCodes().addAll(additionalCommodityCodes);
//        
//
//        return commodityCode;
//    }
//
//}
