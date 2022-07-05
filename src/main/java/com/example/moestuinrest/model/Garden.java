package com.example.moestuinrest.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
@Entity
public class Garden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotBlank(message = "Een naam is verplicht")
    String name;

    @NotNull(message = "Een dimensie X is verplicht")
    int dimensionX;

    @NotNull(message = "Een dimensie Y is verplicht")
    int dimensionY;

}
