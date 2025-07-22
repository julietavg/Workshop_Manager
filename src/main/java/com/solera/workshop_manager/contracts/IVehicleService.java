package com.solera.workshop_manager.contracts;

import java.util.List;

import com.solera.workshop_manager.models.Vehicle;

public interface IVehicleService {
    // TO-DO
    Boolean save(Vehicle vehicle);
    Boolean deletedById(int vehicle_id);
    Vehicle findById(int vehicle_id);
    List <Vehicle> findAll();
    Vehicle updateVehicle(Integer vehicle_id, Vehicle vehicle);
}
