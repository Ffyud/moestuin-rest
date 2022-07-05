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

    @NotBlank(message = "Een naam is verplicht")
    String name;

    @NotBlank(message = "Een icon is verplicht")
    String icon;

    @NotBlank(message = "Een zaaiperiode is verplicht")
    String seedPeriod;

    @NotBlank(message = "Een plantperiode is verplicht")
    String plantPeriod;

    @NotBlank(message = "Een oogstperiode is verplicht")
    String harvestPeriod;

}
