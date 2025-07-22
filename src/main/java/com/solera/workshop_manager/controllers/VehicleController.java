package com.solera.workshop_manager.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.workshop_manager.contracts.IVehicleService;
import com.solera.workshop_manager.models.Vehicle;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class VehicleController {
    private IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicle")
    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicleService.findAll().forEach(vehicles::add);
        return vehicles;
    }

    @GetMapping("/vehicle/{id}")
    public String getVehicleById(@PathVariable Integer id) {
        Vehicle vehicle = vehicleService.findById(id);
        if (vehicle == null) {
            return "Vehicle with ID " + id + " not found";
        }
        return "Vehicle found:\n" +
                "ID: " + vehicle.getVehicle_id() + "\n" +
                "Model: " + vehicle.getVehicle_model() + "\n" +
                "Brand: " + vehicle.getVehicle_brand() + "\n" + 
                "Year: " + vehicle.getVehicle_year() + "\n" +
                "Color: " + vehicle.getVehicle_color() + "\n" +
                "Vin: " + vehicle.getVehicle_vin();
    }

    @PostMapping("/vehicle")
    public ResponseEntity<String> createVehicle(@Valid @RequestBody Vehicle vehicle) {
        vehicleService.save(vehicle);
        return new ResponseEntity<String>("Id vehicle " + vehicle.getVehicle_id() + 
        " with model: "+ vehicle.getVehicle_model() + " created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/vehicle/{id}")
    public String deleteVehicle(@PathVariable Integer id) {
        vehicleService.deletedById(id);
        return "Vehicle with ID " + id + " deleted successfully";
    }

    @PutMapping("/vehicle/{id}")
    public Vehicle updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleService.updateVehicle(id, vehicle);
        return newVehicle;
    }
}

 