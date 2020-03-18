package com.doas.jaggaer.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.doas.jaggaer.entities.SourcingEvent;
import com.doas.jaggaer.models.DocumentExportResponse;
import com.doas.jaggaer.models.SourcingEventExportModel;
import com.doas.jaggaer.models.SourcingEventModel;
import com.doas.jaggaer.repositories.SourcingEventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service
@Transactional
public class SourcingEventService {

    @Autowired
    SourcingEventRepository sourcingEventRepository;

    public List<SourcingEvent> fetchAll() throws Exception {
        
        List<SourcingEvent> sourcingEvents = (List<SourcingEvent>) sourcingEventRepository.findAll();
        return sourcingEvents;
       
    }
    

    public SourcingEvent fetchByJagEventStagingPK(Long jagEventStagingPK) throws Exception {
        
        Optional<SourcingEvent> sourcingEvent = sourcingEventRepository.findByJagEventStagingPK(jagEventStagingPK);
        if(sourcingEvent.isPresent()) {
            return sourcingEvent.get();
        }else {
            return null;
        }
       
    }
    
    public SourcingEvent save(SourcingEventModel sourcingEventModel) throws Exception {
        
        return sourcingEventRepository.save(SourcingEvent.getNewInstance(sourcingEventModel));

       
    }
    
    
    public SourcingEventExportModel deserializeFromXML(String xmlContent) throws JsonMappingException, JsonProcessingException {
        
            XmlMapper xmlMapper = new XmlMapper();
            
            SourcingEventExportModel sourcingEventExportModel = xmlMapper.readValue(xmlContent, SourcingEventExportModel.class);
        
            return sourcingEventExportModel;
    }
    
    public String serializeToXML(DocumentExportResponse documentExportResponse) throws JsonProcessingException {
            XmlMapper xmlMapper = new XmlMapper();

            String docType = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
                    "<!DOCTYPE DocumentExportResponse SYSTEM \"https://integrations.sciquest.com/app_docs/dtd/documentExport/DocumentExport.dtd\">";
            String xmlString = xmlMapper.writeValueAsString(documentExportResponse);

            return docType + xmlString;
    }
}
