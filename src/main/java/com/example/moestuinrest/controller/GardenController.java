package com.example.moestuinrest.controller;

import com.example.moestuinrest.model.Garden;
import com.example.moestuinrest.service.GardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GardenController {

    @Autowired
    GardenService gardenService;

    @PostMapping("/garden")
    ResponseEntity<Garden> save(@RequestBody Garden garden) throws Exception {
        if(garden.getName() != null) {
            return new ResponseEntity<Garden>(gardenService.save(garden), HttpStatus.OK);
        } else {
            throw new Exception();
        }
    }

    @DeleteMapping("/garden/{id}")
    void delete(@PathVariable int id) {
        gardenService.deleteByGardenId(id);
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
