package com.doas.jaggaer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class AdditionalCommodityCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @JsonProperty("Code")
    private String code;

    @JsonBackReference(value="additionalCommodityCodes")
    @ManyToOne
    @JoinColumn(name = "commodity_code_id")
    private CommodityCode commodityCode;
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommodityCode getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(CommodityCode commodityCode) {
        this.commodityCode = commodityCode;
    }

    public static AdditionalCommodityCode getNewInstance(CommodityCode commodityCode, String additionalCommodityCode) {
        AdditionalCommodityCode newAdditionalCommodityCode = new AdditionalCommodityCode();
        newAdditionalCommodityCode.setCommodityCode(commodityCode);
        newAdditionalCommodityCode.setCode(additionalCommodityCode);
        return newAdditionalCommodityCode;
    }
    
    
    

}
