package com.example.moestuinrest.controller;

import com.example.moestuinrest.model.Garden;
import com.example.moestuinrest.model.Plant;
import com.example.moestuinrest.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlantController {

    @Autowired
    PlantService plantService;

    @PostMapping("/plant")
    ResponseEntity<Plant> save(@Valid @RequestBody Plant plant) throws Exception {
        if(plant.getName() != null) {
            return new ResponseEntity<Plant>(plantService.save(plant), HttpStatus.OK);
        } else {
            throw new Exception();
        }
    }

    @DeleteMapping("/plant/{id}")
    void delete(@PathVariable int id) {
        plantService.deleteByPlantId(id);
    }

    @GetMapping("/plant")
    Iterable<Plant> findAll() {
        return plantService.findAll();
    }

    @GetMapping("/plant/{id}")
    Optional<Plant> findById(@PathVariable int id) {
        return plantService.findById(id);
    }

}
