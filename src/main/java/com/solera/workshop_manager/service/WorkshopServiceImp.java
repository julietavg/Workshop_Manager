package com.solera.workshop_manager.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.solera.workshop_manager.contracts.IWorkshopService;
import com.solera.workshop_manager.models.Workshop;
import com.solera.workshop_manager.repository.WorkshopRepository;

@Service
public class WorkshopServiceImp implements IWorkshopService {

    private final WorkshopRepository workshopRepository;

    public WorkshopServiceImp(WorkshopRepository workshopRepository) {
        this.workshopRepository = workshopRepository;
    }

    @Override
    public Boolean save(Workshop workshop) {
        if (workshopRepository.save(workshop) != null)
            return true;
        return false;
    }

    @Override
    public Boolean deletedById(int workshop_id) {
        workshopRepository.deleteById(workshop_id);
        return true;
    }

    @Override
    @Transactional
    public Workshop findById(int workshop_id) {
        Workshop workshop = workshopRepository.findById(workshop_id).orElse(null);
        if (workshop != null) {
            workshop.getVehicles().size();
        }
        return workshop;
    }

    @Override
    @Transactional
    public List<Workshop> findAll() {
        List<Workshop> workshops = (List<Workshop>) workshopRepository.findAll();
        for (Workshop w : workshops) {
            if (w.getVehicles() != null) {
                w.getVehicles().forEach(v -> {
                    if (v.getParts() != null) {
                        v.getParts().size();
                    }
                });
            }
        }
        return workshops;
    }

    @Override
    public Workshop updateWorkshop(Integer id, Workshop workshop) {
        Optional<Workshop> optionalWorkshop = workshopRepository.findById(id);
        if (optionalWorkshop.isPresent()) {
            Workshop existingWorkshop = optionalWorkshop.get();
            existingWorkshop.setName(workshop.getName());
            existingWorkshop.setDescription(workshop.getDescription());
            return workshopRepository.save(existingWorkshop);
        } else {
            return null;
        }
    }

}