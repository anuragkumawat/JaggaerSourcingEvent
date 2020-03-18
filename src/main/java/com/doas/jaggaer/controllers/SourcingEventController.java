package com.doas.jaggaer.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.doas.jaggaer.ApplicationProperties;
import com.doas.jaggaer.entities.SourcingEvent;
import com.doas.jaggaer.models.DocumentExportResponse;
import com.doas.jaggaer.models.SourcingEventExportModel;
import com.doas.jaggaer.models.SourcingEventResponse;
import com.doas.jaggaer.services.SourcingEventService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Sourcing Event API")
public class SourcingEventController {
    
    @Autowired
    SourcingEventService sourcingEventService;
    
    @Autowired
    ApplicationProperties applicationProperties;


    @ApiOperation(value = "Get all sourcing event")
    @GetMapping(path = "/sourcing-event", produces = MediaType.TEXT_HTML_VALUE )
    public ModelAndView getAllSourcingEvent() throws JsonProcessingException {
       
        try {
            List<SourcingEvent> sourcingEvents = sourcingEventService.fetchAll();
            
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("sourcing-events");
            modelAndView.addObject("sourcingEvents", sourcingEvents);
            return modelAndView;
        } catch (Exception e) {
            return null;
        }
    }
    
    @ApiOperation(value = "Get sourcing event by jagEventStagingPK")
    @GetMapping(path = "/sourcing-event/{jagEventStagingPK}", produces = MediaType.TEXT_HTML_VALUE )
    @ResponseBody
    public ModelAndView getSourcingEvent(@PathVariable Long jagEventStagingPK) throws JsonProcessingException {
       
        try {
            SourcingEvent sourcingEvent = sourcingEventService.fetchByJagEventStagingPK(jagEventStagingPK);
            
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("sourcing-event");
            modelAndView.addObject("sourcingEvent", sourcingEvent);
            return modelAndView;
            
        } catch (Exception e) {
            return null;
        }
    }
    
    @ApiOperation(value = "Create new sourcing event")
    @PostMapping(path = "/sourcing-event", consumes=MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE )
    public String createSourcingEvent(@RequestBody String xmlData) throws JsonProcessingException {
       
        DocumentExportResponse documentExportResponse =  new DocumentExportResponse();
        try {
            SourcingEventExportModel sourcingEventExport = sourcingEventService.deserializeFromXML(xmlData);
            documentExportResponse = DocumentExportResponse.getNewInstance(sourcingEventExport.getHeader().getMessageId(), sourcingEventExport.getHeader().getTimeStamp(), "");
            
            if(sourcingEventExport.getHeader().getAuthentication().getIdentity().equalsIgnoreCase(applicationProperties.getIdentity()) && 
                    sourcingEventExport.getHeader().getAuthentication().getSharedSecret().equalsIgnoreCase(applicationProperties.getSharedSecret())) {
                
                sourcingEventService.save(sourcingEventExport.getSourcingEvent());
                documentExportResponse.setResponse(SourcingEventResponse.getNewInstance(HttpStatus.OK.value(), "Success", null));
                
                return sourcingEventService.serializeToXML(documentExportResponse);
                
            } else {
                documentExportResponse.setResponse(SourcingEventResponse.getNewInstance(HttpStatus.FORBIDDEN.value(), "Unauthorized", "Invalid identity or shared secret"));
                return sourcingEventService.serializeToXML(documentExportResponse);
            }
            
        }catch(Exception e) {
            documentExportResponse.setResponse(SourcingEventResponse.getNewInstance(HttpStatus.BAD_REQUEST.value(), "Error", e.getMessage()));
            return sourcingEventService.serializeToXML(documentExportResponse);
        }
    }
    
//    @ApiOperation(value = "Update existing sourcing event")
//    @PutMapping(path = "/sourcing-event", consumes=MediaType.TEXT_XML_VALUE, produces = MediaType.TEXT_XML_VALUE )
//    public String updateSourcingEvent(@RequestBody String xmlData) throws JsonProcessingException {
//        
//        DocumentExportResponse documentExportResponse =  new DocumentExportResponse();
//        
//        try {
//            SourcingEventExportModel sourcingEventExportModel = sourcingEventService.deserializeFromXML(xmlData);
//            documentExportResponse = DocumentExportResponse.getNewInstance(sourcingEventExportModel.getHeader().getMessageId(), sourcingEventExportModel.getHeader().getTimeStamp(), "");
//
//            sourcingEventService.update(sourcingEventExportModel.getSourcingEvent());
//            documentExportResponse.setResponse(SourcingEventResponse.getNewInstance(HttpStatus.OK.value(), "Success", null));
//
//            return sourcingEventService.serializeToXML(documentExportResponse);
//        }catch(Exception e) {
//            documentExportResponse.setResponse(SourcingEventResponse.getNewInstance(HttpStatus.BAD_REQUEST.value(), "Error", e.getMessage()));
//            return sourcingEventService.serializeToXML(documentExportResponse);        }
//    }
    
}
