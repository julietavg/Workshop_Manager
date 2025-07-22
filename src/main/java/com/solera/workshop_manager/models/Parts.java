package com.solera.workshop_manager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer part_id;

    @NotBlank(message = "Part name is required")
    private String part_name;
    
    @NotBlank(message = "Part description is required")
    private String part_description;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "vehicle_id")

    private Vehicle vehicle;
}
