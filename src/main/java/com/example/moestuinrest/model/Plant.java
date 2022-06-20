package com.example.moestuinrest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String icon;
    String seedPeriod;
    String plantPeriod;
    String harvestPeriod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSeedPeriod() {
        return seedPeriod;
    }

    public void setSeedPeriod(String seedPeriod) {
        this.seedPeriod = seedPeriod;
    }

    public String getPlantPeriod() {
        return plantPeriod;
    }

    public void setPlantPeriod(String plantPeriod) {
        this.plantPeriod = plantPeriod;
    }

    public String getHarvestPeriod() {
        return harvestPeriod;
    }

    public void setHarvestPeriod(String harvestPeriod) {
        this.harvestPeriod = harvestPeriod;
    }

}
