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
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int part_id;
    private String part_name;
    private String part_description;

    //TO-DO Relation many to one with Vehicle. 
}
