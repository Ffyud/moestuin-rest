package com.example.moestuinrest.controller;

import com.example.moestuinrest.model.Plant;
import com.example.moestuinrest.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantController {

    @Autowired
    PlantService plantService;

    @PostMapping("/plant")
    Plant save(@RequestBody Plant plant) {
        return plantService.save(plant);
    }

    @GetMapping("/plant")
    Iterable<Plant> findAll() {
        return plantService.findAll();
    }



}
