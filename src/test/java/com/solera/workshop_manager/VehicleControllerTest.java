package com.solera.workshop_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.solera.workshop_manager.models.Vehicle;
import com.solera.workshop_manager.repository.VehicleRepository;
import com.solera.workshop_manager.service.VehicleServiceImp;

@SpringBootTest
class VehicleControllerTest {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleServiceImp vehicleService;

    @Test
    void testSaveVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_model("");
        vehicle.setVehicle_brand("Color blue Model 123");
        vehicle.setVehicle_year("Color blue Model 123");
        vehicle.setVehicle_color("Color blue Model 123");
        vehicle.setVehicle_vin("Color blue Model 123");
        boolean result = vehicleService.save(vehicle);
        assertTrue(result);
    }

    @Test
    void testFindVehicleById() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_model("Audi");
        vehicle.setVehicle_brand("v2");
        vehicle.setVehicle_year("2005");
        vehicle.setVehicle_color("White");
        vehicle.setVehicle_vin("ABC23");

        vehicleRepository.save(vehicle);
        Vehicle fetched = vehicleService.findById(vehicle.getVehicle_id());

        assertNotNull(fetched);
        assertEquals("ABC23", fetched.getVehicle_vin());
    }

    @Test 
    void testFindAllVehicle_ThreeExample(){
        vehicleRepository.save(new Vehicle(null, "Audi", "v2", "2003", "Black", "AABB",null,null));
        vehicleRepository.save(new Vehicle(null, "BMW", "L1", "2012", "White", "ZZZ", null, null));
        vehicleRepository.save(new Vehicle(null, "Volks", "E2", "2000", "Green", "EEE",null, null));

        List<Vehicle> vehicle = vehicleService.findAll();
        assertTrue(vehicle.size() >= 3 ); 

    }

    @Test
    void testDeleteVehicle(){
        Vehicle vehicle = new Vehicle(null, "BMW", "X5", "2020", "Black", "1HGBH41JXMN109186", null, null);
        vehicleRepository.save(vehicle); // Save the workshop
        vehicleRepository.deleteById((vehicle.getVehicle_id())); // Delete the workshop
        assertFalse(vehicleRepository.findById(vehicle.getVehicle_id()).isPresent());
    }

    @Test 
    void testUpdateVehicle(){
        // Save a vehicle and get the saved instance with generated ID
        Vehicle vehicle = vehicleRepository.save(new Vehicle(null, "Audi", "v2", "2003", "Black", "AABB",null,null));

        // Update the same vehicle object's properties
        vehicle.setVehicle_model("New Truck");
        vehicle.setVehicle_brand("v12");
        vehicle.setVehicle_year("2025");
        vehicle.setVehicle_color("White");
        vehicle.setVehicle_vin("A32432GDF");

        Vehicle updatedVehicle = vehicleService.updateVehicle(vehicle.getVehicle_id(), vehicle);
        
        assertNotNull(updatedVehicle);
        assertEquals("New Truck", updatedVehicle.getVehicle_model());
        assertEquals("v12", updatedVehicle.getVehicle_brand());
    }
}
 