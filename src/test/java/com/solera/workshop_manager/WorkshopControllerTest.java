package com.solera.workshop_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.solera.workshop_manager.models.Workshop;
import com.solera.workshop_manager.repository.WorkshopRepository;
import com.solera.workshop_manager.service.WorkshopServiceImp;

@SpringBootTest
class WorkshopControllerTest {

    @Autowired
    private WorkshopRepository workshopRepository;

    @Autowired
    private WorkshopServiceImp workshopService;

    
    @Test
    void testSaveWorkshop(){
        Workshop workshop = new Workshop();
        workshop.setName("Test workshop Central");
        workshop.setDescription("Example of a short description");
        boolean result = workshopService.save(workshop);
        assertTrue(result);
    }

    @Test
    void testFindWorkshopById() {
        Workshop workshop = new Workshop();
        workshop.setName("Engine name");
        workshop.setDescription("Diagnostics");

        workshopRepository.save(workshop);
        Workshop fetched = workshopService.findById(workshop.getWorkshop_id());

        assertNotNull(fetched);
        assertEquals("Engine name", fetched.getName());
    }

    @Test 
    void testFindAllWorkshops_TwoExample(){
        workshopRepository.save(new Workshop(null, "WS 1", "Descript", null));
        workshopRepository.save(new Workshop(null, "WS 2", "Other text", null));

        List<Workshop> workshops = workshopService.findAll();
        assertTrue(workshops.size() >= 2 ); 

    }

    
    
    @Test
    void testDeleteWorkshop(){
        Workshop workshop = new Workshop (null, "Workshop Call", "Maintenance", null);
        workshopRepository.save(workshop); // Save the workshop
        workshopRepository.deleteById((workshop.getWorkshop_id())); // Delete the workshop
        assertFalse(workshopRepository.findById(workshop.getWorkshop_id()).isPresent());
    }

    @Test 
    void testUpdateWorkshop(){
        Workshop workshop = new Workshop(null, "Default", "Initial description", null);
        workshopRepository.save(workshop); // Save the workshop

        workshop.setName("Update Workshop");
        workshop.setDescription("Update Description");
        
        Workshop updatedWorkshop = workshopService.updateWorkshop(workshop.getWorkshop_id(), workshop);
        //Workshop updatedWorkshop = null;
        
        assertNotNull(updatedWorkshop);
        assertEquals("Update Workshop", updatedWorkshop.getName());
        assertEquals("Update Description", updatedWorkshop.getDescription());
    }
}
 