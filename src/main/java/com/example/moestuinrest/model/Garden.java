package com.example.moestuinrest.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@Entity
public class Garden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotBlank
    String name;

    @NotBlank
    int dimensionX;

    @NotBlank
    int dimensionY;

}
