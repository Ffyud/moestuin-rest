package com.example.moestuinrest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
@Entity
public class GardenContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNull(message = "Een positie X is verplicht")
    int positionX;

    @NotNull(message = "Een positie Y is verplicht")
    int positionY;

    @NotEmpty(message = "Een tuin is verplicht")
    @ManyToOne
    @JoinColumn(name="garden_id")
    Garden garden;

    @NotEmpty(message = "Een plant is verplicht")
    @ManyToOne
    Plant plant;

}
