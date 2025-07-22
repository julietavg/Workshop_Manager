package com.solera.workshop_manager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.solera.workshop_manager.contracts.IPartsService;
import com.solera.workshop_manager.models.Parts;
import com.solera.workshop_manager.repository.PartsRepository;

@Service
public class PartsServiceImp implements IPartsService {

    private final PartsRepository partsRepository;

    public PartsServiceImp(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    @Override
    public Boolean save(Parts part) {
        if (partsRepository.save(part).getPart_name() != null)
            return true;
        return false;
    }

    @Override
    public Boolean deleteById(int part_id) {
        partsRepository.deleteById(part_id);
        return true;
    }

    @Override
    public Parts findById(int part_id) {
        if (partsRepository.findById(part_id).isPresent()) {
            return partsRepository.findById(part_id).get();
        }
        return null;
    }

    @Override
    public List<Parts> findAll() {
        List<Parts> parts = (List<Parts>) partsRepository.findAll();
        return parts;
    }

    @Override
    public Parts updateParts(Integer id, Parts parts) {
        Optional<Parts> optionalPart = partsRepository.findById(id);
        if (optionalPart.isPresent()) {
            Parts existingPart = optionalPart.get();
            existingPart.setPart_name(parts.getPart_name());
            existingPart.setPart_description(parts.getPart_description());
            return partsRepository.save(existingPart);
        } else {
            return null;
        }
    }

 

}
