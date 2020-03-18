package com.doas.jaggaer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.doas.jaggaer.models.BusinessUnitAssociationModel;
import com.doas.jaggaer.models.SourcingEventModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class BusinessUnitAssociation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "business_unit")
    private String businessUnit;
    
    @JsonBackReference(value="businessUnitAssociation")
    @OneToOne
    @JoinColumn(name = "event_number")
    private SourcingEvent sourcingEvent;

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SourcingEvent getSourcingEvent() {
        return sourcingEvent;
    }

    public void setSourcingEvent(SourcingEvent sourcingEvent) {
        this.sourcingEvent = sourcingEvent;
    }
    
    
//    public static BusinessUnitAssociation getNewInstance(SourcingEvent sourcingEvent, SourcingEventModel sourcingEventModel) {
//        BusinessUnitAssociation businessUnitAssociation = new BusinessUnitAssociation();
//        businessUnitAssociation.setSourcingEvent(sourcingEvent);
//        businessUnitAssociation.setBusinessUnit(sourcingEventModel.getBusinessUnitAssociations().getBusinessUnit());
//        return businessUnitAssociation;
//    }
//    
//    public static BusinessUnitAssociation copyInstance(BusinessUnitAssociation businessUnitAssociation, BusinessUnitAssociationModel businessUnitAssociationModel) {
//        businessUnitAssociation.setBusinessUnit(businessUnitAssociationModel.getBusinessUnit());
//        return businessUnitAssociation;
//    }
    

}
