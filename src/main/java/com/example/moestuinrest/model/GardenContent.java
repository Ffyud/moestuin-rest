package com.example.moestuinrest.model;

import javax.persistence.*;

@Entity
public class GardenContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int positionX;
    int positionY;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @ManyToOne
    @JoinColumn(name="garden_id")
    Garden garden;

    public Garden getGarden() {
        return garden;
    }

    public void setGarden(Garden garden) {
        this.garden = garden;
    }

    @ManyToOne
    Plant plant;

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }
}
