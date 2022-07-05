package com.example.moestuinrest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@Entity
public class GardenContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotBlank
    int positionX;

    @NotBlank
    int positionY;

    @NotBlank
    @ManyToOne
    @JoinColumn(name="garden_id")
    Garden garden;

    @NotBlank
    @ManyToOne
    Plant plant;

}
