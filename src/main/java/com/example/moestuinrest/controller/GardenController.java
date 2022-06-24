package com.example.moestuinrest.controller;

import com.example.moestuinrest.model.Garden;
import com.example.moestuinrest.service.GardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GardenController {

    @Autowired
    GardenService gardenService;

    @PostMapping("/garden")
    Garden save(@RequestBody Garden garden) {
        return gardenService.save(garden);
    }

    @GetMapping("/garden/{id}")
    Optional<Garden> findById(@PathVariable int id) {
        return gardenService.findById(id);
    }

    @GetMapping("/garden")
    Iterable<Garden> findAll() {
        return gardenService.findAll();
    }
}
