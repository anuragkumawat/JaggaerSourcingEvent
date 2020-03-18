package com.doas.jaggaer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.doas.jaggaer.models.SourcingEventModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="JAG_COMMODITY_CODE")
public class CommodityCode {
    
    @Id
    @SequenceGenerator(name="seq", sequenceName="SEQ_JAG_STAGING")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name="JAG_COMMODITY_CODE_PK")
    private Long commodityCodePK;
    
    @JsonBackReference(value="commoditycode")
    @ManyToOne
    @JoinColumn(name = "JAG_EVENT_STAGING_FK")
    private SourcingEvent jagEventStagingFK;
    
    @Column(name = "COMMODITY_CODE")
    private String commodityCode;
    
    @Column(name = "ENTRY_TYPE")
    private String entryType;

    
    public Long getCommodityCodePK() {
        return commodityCodePK;
    }

    public void setCommodityCodePK(Long commodityCodePK) {
        this.commodityCodePK = commodityCodePK;
    }

    public SourcingEvent getJagEventStagingFK() {
        return jagEventStagingFK;
    }

    public void setJagEventStagingFK(SourcingEvent jagEventStagingFK) {
        this.jagEventStagingFK = jagEventStagingFK;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }
    
    public static CommodityCode getNewInstance(String commodityCode, String entryType, SourcingEvent sourcingEvent) {
        CommodityCode newCommodityCode = new CommodityCode();
        newCommodityCode.setCommodityCode(commodityCode);
        newCommodityCode.setEntryType(entryType);
        newCommodityCode.setJagEventStagingFK(sourcingEvent);
        return newCommodityCode;
    }
    
   
}
