package com.solera.workshop_manager.contracts;

import java.util.List;

import com.solera.workshop_manager.models.Parts;

public interface IPartsService {

    Boolean save(Parts part);
    Boolean deletedById(int part_id);
    Parts findById(int part_id);
    List<Parts> findAll();
}
