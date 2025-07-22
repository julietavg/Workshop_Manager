package com.solera.workshop_manager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.workshop_manager.contracts.IPartsService;
import com.solera.workshop_manager.models.Parts;
import com.solera.workshop_manager.service.PartsServiceImp;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class PartsController {
    private IPartsService partsServPersist;

    public PartsController(PartsServiceImp crudPartsServiceImp){
        partsServPersist = crudPartsServiceImp;
    }

    @GetMapping("/parts")
    public List<Parts> getAllParts() {
        List<Parts> parts = new ArrayList<>();
        partsServPersist.findAll().forEach(parts::add);
        return parts;
    }

    @GetMapping("/parts/{id}")
    public String getPartsById(@PathVariable Integer id){
        Parts part = partsServPersist.findById(id);
        if (part == null) {
            return "Parts with ID " + id + " not found";
        } else {
            return "Part found:\n" +
                "ID: " + part.getPart_id() + "\n" +
                "Name: " + part.getPart_name() + "\n" +
                "Description: " + part.getPart_description();
        }
    }

    @PostMapping("/parts")
    public ResponseEntity<String> createPart(@Valid @RequestBody Parts parts){
        partsServPersist.save(parts);
        return new ResponseEntity<String>("Part: " + parts.getPart_name() + " created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/parts/{id}")
    public String deleteParts(@PathVariable Integer id){
        partsServPersist.deleteById(id);
        return "Part with ID " + id + " deleted successfully";
    }
    
    @PutMapping("/parts/{id}")
    public Parts updateParts(@PathVariable Integer id, @RequestBody Parts parts) {
        Parts newPart = partsServPersist.updateParts(id, parts);
        return newPart;
    }

}
