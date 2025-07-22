package com.solera.workshop_manager.service;

import java.util.List;

import com.solera.workshop_manager.contracts.IVehicleService;
import com.solera.workshop_manager.models.Vehicle;
import com.solera.workshop_manager.repository.VehicleRepository;

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
    public Vehicle findById(int vehicle_id) {
        if (vehicleRepository.findById(vehicle_id).isPresent()) {
            return vehicleRepository.findById(vehicle_id).get();
        }
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = (List<Vehicle>) vehicleRepository.findAll();
        return vehicles;
    }

    @Override
    public Boolean update(int vehicle_id, Vehicle vehicle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }



}
