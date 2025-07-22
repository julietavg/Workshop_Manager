package com.solera.workshop_manager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.workshop_manager.contracts.IWorkshopService;
import com.solera.workshop_manager.models.Workshop;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1")
public class WorkshopController {

    private IWorkshopService workshopService;

    public WorkshopController(IWorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @PostMapping("/workshop")
    public ResponseEntity<String> createWorkshop(@Valid @RequestBody Workshop workshop) {
        workshopService.save(workshop);
        return new ResponseEntity<String>("Workshop " + workshop.getName() + " has been saved successfully!",
                org.springframework.http.HttpStatus.CREATED);

    }

    @DeleteMapping("/workshop/{id}")
    public String deleteWorshop(@PathVariable Integer id) {
        workshopService.deletedById(id);
        return "Workshop with ID " + id + " has been deleted successfully!";
    }

    @GetMapping("/workshop")
    public List<Workshop> getAllWorkshops() {
        List<Workshop> workshops = new ArrayList<>();
        workshopService.findAll().forEach(workshops::add);
        return workshops;
    }

    @GetMapping("/workshop/{id}")
    public String getWorshopById(@PathVariable Integer id) {
        Workshop workshop = workshopService.findById(id);
        if (workshop == null) {
            return "Workshop with ID " + id + " not found";
        }
        return "Workshop found:\n" +
                "ID: " + workshop.getWorkshop_id() + "\n" +
                "Name: " + workshop.getName() + "\n" +
                "Description: " + workshop.getDescription() + "\n" +
                "Vehicles: " + (workshop.getVehicles() != null ? workshop.getVehicles().size() : 0);
    }

     @PutMapping("/workshop/{id}")
    public Workshop updateWorkshop(@PathVariable Integer id, @RequestBody Workshop workshop) {
        Workshop newWorkshop = workshopService.updateWorkshop(id, workshop);
        return newWorkshop;
    }

    
}
