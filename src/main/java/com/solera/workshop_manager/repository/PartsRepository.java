package com.solera.workshop_manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.solera.workshop_manager.models.Parts;

@Repository
public interface PartsRepository extends CrudRepository<Parts, Integer> {
    
}
