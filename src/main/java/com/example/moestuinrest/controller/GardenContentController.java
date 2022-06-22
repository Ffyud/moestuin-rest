package com.example.moestuinrest.controller;

import com.example.moestuinrest.model.Garden;
import com.example.moestuinrest.service.GardenContentService;
import com.example.moestuinrest.service.GardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GardenContentController {

    @Autowired
    GardenContentService gardenContentService;

    @PostMapping("/gardencontent")
    Garden save(@RequestBody Garden garden) {
        return gardenContentService.save(garden);
    }

    @GetMapping("/gardencontent/{id}")
    Optional<Garden> findById(@PathVariable int id) {
        return gardenContentService.findById(id);
    }

    @GetMapping("/gardencontent")
    Iterable<Garden> findAll() {
        return gardenContentService.findAll();
    }


}
