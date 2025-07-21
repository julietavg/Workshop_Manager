package com.solera.workshop_manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solera.workshop_manager.models.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository <Vehicle, Integer> {
    
}
