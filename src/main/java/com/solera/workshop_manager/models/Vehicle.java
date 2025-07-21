package com.solera.workshop_manager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicle_id;
    private String vehicle_model;
    private String vehicle_brand;
    private String vehicle_year;
    private String vehicle_color;
    private String vehicle_vin;

    //TO-DO Relation many to one


    
}
