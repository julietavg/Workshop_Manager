package com.solera.workshop_manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solera.workshop_manager.models.Workshop;

@Repository
public interface WorkshopRepository extends CrudRepository<Workshop, Integer> {
    

}
