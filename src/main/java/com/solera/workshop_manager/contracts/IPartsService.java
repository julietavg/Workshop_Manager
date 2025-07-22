package com.solera.workshop_manager.contracts;

import java.util.List;

import com.solera.workshop_manager.models.Parts;

public interface IPartsService {
    Boolean save(Parts parts);
    Boolean deleteById(int parts_id);
    Parts findById(int parts_id);
    List<Parts> findAll();

    //Update
}
