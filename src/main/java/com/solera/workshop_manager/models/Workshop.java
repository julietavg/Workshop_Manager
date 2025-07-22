package com.solera.workshop_manager.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Workshop{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workshop_id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "workshop", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

}