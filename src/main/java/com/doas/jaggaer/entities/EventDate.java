package com.doas.jaggaer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.doas.jaggaer.models.EventDateModel;
import com.doas.jaggaer.models.SourcingEventModel;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class EventDate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "time_zone")
    private String timeZone;
    
    @Column(name = "open_date")
    private String openDate;
    
    @Column(name = "close_date")
    private String closeDate;
    
    @Column(name = "question_answer_close_date")
    private String questionAnswerCloseDate;
    
    @JsonBackReference(value="eventDate")
    @OneToOne
    @JoinColumn(name = "event_number")
    private SourcingEvent sourcingEvent;

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getQuestionAnswerCloseDate() {
        return questionAnswerCloseDate;
    }

    public void setQuestionAnswerCloseDate(String questionAnswerCloseDate) {
        this.questionAnswerCloseDate = questionAnswerCloseDate;
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
//
//    public static EventDate getNewInstance(SourcingEvent sourcingEvent, SourcingEventModel sourcingEventModel) {
//        EventDate eventDate = new EventDate();
//        eventDate.setSourcingEvent(sourcingEvent);
//        eventDate.setOpenDate(sourcingEventModel.getEventDates().getOpenDate());
//        eventDate.setCloseDate(sourcingEventModel.getEventDates().getCloseDate());
//        eventDate.setTimeZone(sourcingEventModel.getEventDates().getTimeZone());
//        eventDate.setQuestionAnswerCloseDate(sourcingEventModel.getEventDates().getQuestionAnswerCloseDate());
//        return eventDate;
//    }
//    
//    public static EventDate copyInstance(EventDate eventDate, EventDateModel eventDateModel) {
//        eventDate.setOpenDate(eventDateModel.getOpenDate());
//        eventDate.setCloseDate(eventDateModel.getCloseDate());
//        eventDate.setTimeZone(eventDateModel.getTimeZone());
//        eventDate.setQuestionAnswerCloseDate(eventDateModel.getQuestionAnswerCloseDate());
//        return eventDate;
//    }
//    
    
    
}
