package com.solera.workshop_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.solera.workshop_manager.contracts.IVehicleService;
import com.solera.workshop_manager.models.Vehicle;
import com.solera.workshop_manager.repository.VehicleRepository;

@Service
public class VehicleServiceImp implements IVehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImp(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Boolean save(Vehicle vehicle) {
        if (vehicleRepository.save(vehicle) != null)
            return true;
        return false;

    }

    @Override
    public Boolean deletedById(int vehicle_id) {
        vehicleRepository.deleteById(vehicle_id);
        return true;
    }

    @Override
    @Transactional
    public Vehicle findById(int vehicle_id) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicle_id);
        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();
            vehicle.getParts().size();
            return vehicle;
        }
        return null;
    }

    @Override
    @Transactional
    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = (List<Vehicle>) vehicleRepository.findAll();
        for (Vehicle v : vehicles) {
            if (v.getParts() != null) {
                v.getParts().size(); 
            }
        }
        return vehicles;
    }

    @Override
    public Vehicle updateVehicle(Integer vehicle_id, Vehicle vehicle) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicle_id);
        if (optionalVehicle.isPresent()) {
            Vehicle existingVehicle = optionalVehicle.get();
            existingVehicle.setVehicle_model(vehicle.getVehicle_model());
            existingVehicle.setVehicle_brand(vehicle.getVehicle_brand());
            existingVehicle.setVehicle_year(vehicle.getVehicle_year());
            existingVehicle.setVehicle_color(vehicle.getVehicle_color());
            existingVehicle.setVehicle_vin(vehicle.getVehicle_vin());
            return vehicleRepository.save(existingVehicle);
        } else {
            return null;
        }
    }
}
