package com.solera.workshop_manager.service;

import java.util.List;

import com.solera.workshop_manager.contracts.IPartsService;
import com.solera.workshop_manager.models.Parts;
import com.solera.workshop_manager.repository.PartsRepository;

public class PartsServiceImp implements IPartsService {

    private final PartsRepository partsRepository;

    public PartsServiceImp(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    @Override
    public Boolean save(Parts part) {
        return partsRepository.save(part) != null;
    }

    @Override
    public Boolean deletedById(int part_id) {
        partsRepository.deleteById(part_id);
        return true;
    }

    @Override
    public Parts findById(int part_id) {
        return partsRepository.findById(part_id).orElse(null);
    }

    @Override
    public List<Parts> findAll() {
        return (List<Parts>) partsRepository.findAll();
    }
}
