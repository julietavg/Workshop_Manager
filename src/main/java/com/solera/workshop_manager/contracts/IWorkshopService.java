package com.solera.workshop_manager.contracts;

import java.util.List;

import com.solera.workshop_manager.models.Workshop;

public interface IWorkshopService {

    Boolean save(Workshop workshop);
    Boolean deletedById(int workshop_id);
    Workshop findById(int workshop_id);
    List <Workshop> findAll();
    Workshop updateWorkshop(Integer workshop_id, Workshop workshop);

    
}
