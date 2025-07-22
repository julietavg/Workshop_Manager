package com.solera.workshop_manager.service;

import java.util.List;

import com.solera.workshop_manager.contracts.IWorkshopService;
import com.solera.workshop_manager.models.Workshop;
import com.solera.workshop_manager.repository.WorkshopRepository;


public class WorkshopServiceImp implements IWorkshopService{

    private final WorkshopRepository workshopRepository;

    public WorkshopServiceImp(WorkshopRepository workshopRepository){
        this.workshopRepository = workshopRepository;
    }

    @Override
    public Boolean save(Workshop workshop) {
       if(workshopRepository.save(workshop)!= null)
            return true;
        return false;
    }

    @Override
    public Boolean deletedById(int workshop_id) {
       workshopRepository.deleteById(workshop_id);
       return true;
    }

    @Override
    public Workshop findById(int workshop_id) {
        if(workshopRepository.findById(workshop_id).isPresent()){
            return workshopRepository.findById(workshop_id).get();
        }
        return null;
    }

    @Override
    public List<Workshop> findAll() {
        List<Workshop> workshops = (List <Workshop>) workshopRepository.findAll();
        return workshops;
    }



}