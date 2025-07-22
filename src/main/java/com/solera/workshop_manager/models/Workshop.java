package com.solera.workshop_manager.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Workshop{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workshop_id;

    @NotBlank(message = "Workshop name is required")
    private String name;

    @NotBlank(message = "Workshop description is required")
    private String description;

    @OneToMany(mappedBy = "workshop", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Vehicle> vehicles;

}