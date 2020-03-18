package com.doas.jaggaer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.doas.jaggaer.models.PaymentDetailModel;
import com.doas.jaggaer.models.SourcingEventModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PaymentDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "estimated_value")
    private String estimatedValue;
    
    @Column(name = "payment_terms")
    private String paymentTerms;
    
    @JsonBackReference(value="paymentDetail")
    @OneToOne
    @JoinColumn(name = "event_number")
    private SourcingEvent sourcingEvent;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(String estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
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

//    public static PaymentDetail getNewInstance(SourcingEvent sourcingEvent, SourcingEventModel sourcingEventModel) {
//        PaymentDetail paymentDetail = new PaymentDetail();
//        paymentDetail.setSourcingEvent(sourcingEvent);
//        paymentDetail.setCurrency(sourcingEventModel.getPaymentDetails().getCurrency());
//        paymentDetail.setEstimatedValue(sourcingEventModel.getPaymentDetails().getEstimatedValue());
//        paymentDetail.setPaymentTerms(sourcingEventModel.getPaymentDetails().getPaymentTerms());
//        return paymentDetail;
//    }
//    
//    public static PaymentDetail copyInstance(PaymentDetail paymentDetail, PaymentDetailModel paymentDetailModel) {
//        paymentDetail.setCurrency(paymentDetailModel.getCurrency());
//        paymentDetail.setEstimatedValue(paymentDetailModel.getEstimatedValue());
//        paymentDetail.setPaymentTerms(paymentDetailModel.getPaymentTerms());
//        return paymentDetail;
//    }
    

}
