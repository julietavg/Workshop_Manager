package com.solera.workshop_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.solera.workshop_manager.models.Parts;
import com.solera.workshop_manager.repository.PartsRepository;
import com.solera.workshop_manager.service.PartsServiceImp;

@SpringBootTest
class PartsControllerTest {
    @Autowired
    private PartsRepository partsRepository;

    @Autowired
    private PartsServiceImp partsService;

       
    @Test
    void testSavePart(){
        Parts part = new Parts();
        part.setPart_name("Lights");
        part.setPart_description("Color blue Model 123");
        boolean result = partsService.save(part);
        assertTrue(result);
    }

    @Test
    void testFindPartById() {
        Parts part = new Parts();
        part.setPart_name("Brakes");
        part.setPart_description("High performance brakes");

        partsRepository.save(part);
        Parts fetched = partsService.findById(part.getPart_id());

        assertNotNull(fetched);
        assertEquals("Brakes", fetched.getPart_name());
    }

    @Test 
    void testFindAllParts_ThreeExample(){
        partsRepository.save(new Parts(null, "Lights", "Yellow", null));
        partsRepository.save(new Parts(null, "Brakes", "High performace brakes", null));
        partsRepository.save(new Parts(null, "Pedals", "Pack of two", null));

        List<Parts> parts = partsService.findAll();
        assertTrue(parts.size() >= 3 ); 

    }

    @Test
    void testDeletePart(){
        Parts part = new Parts (null, "Battery", "Maintenance", null);
        partsRepository.save(part); // Save the workshop
        partsRepository.deleteById((part.getPart_id())); // Delete the workshop
        assertFalse(partsRepository.findById(part.getPart_id()).isPresent());
    }

    @Test 
    void testUpdatePart(){
        Parts part = new Parts (null, "Sensor", "Short Description", null);
        partsRepository.save(part); // Save the workshop

        part.setPart_name("Camera Sensor");
        part.setPart_description("With night vision");
        
        Parts updatedPart = partsService.updateParts(part.getPart_id(), part);
        //Workshop updatedWorkshop = null;
        
        assertNotNull(updatedPart);
        assertEquals("Camera Sensor", updatedPart.getPart_name());
        assertEquals("With night vision", updatedPart.getPart_description());
    }

}