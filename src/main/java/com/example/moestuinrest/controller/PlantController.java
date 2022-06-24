package com.example.moestuinrest.controller;

import com.example.moestuinrest.model.Plant;
import com.example.moestuinrest.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
