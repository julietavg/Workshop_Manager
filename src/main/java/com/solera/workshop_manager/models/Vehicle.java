package com.solera.workshop_manager.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
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
    private Integer vehicle_id;

    @NotBlank(message = "Model is required")
    private String vehicle_model;

    @NotBlank(message = "Brand is required")
    private String vehicle_brand;

    @NotBlank(message = "Year is required")
    private String vehicle_year;

    @NotBlank(message = "Color is required")
    private String vehicle_color;

    @NotBlank(message = "VIN is required")
    private String vehicle_vin;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    @JsonBackReference
    private Workshop workshop;

    
    @OneToMany(mappedBy = "vehicle",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Parts> parts;


    
}
