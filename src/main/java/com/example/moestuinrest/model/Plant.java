package com.example.moestuinrest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotBlank
    String name;

    @NotBlank
    String icon;

    @NotBlank
    String seedPeriod;

    @NotBlank
    String plantPeriod;

    @NotBlank
    String harvestPeriod;

}
