package com.example.moestuinrest.controller;

import com.example.moestuinrest.model.GardenContent;
import com.example.moestuinrest.service.GardenContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GardenContentController {

    @Autowired
    GardenContentService gardenContentService;

    @PostMapping("/gardencontent")
    GardenContent save(@RequestBody GardenContent gardenContent) {
        return gardenContentService.save(gardenContent);
    }

    @GetMapping("/gardencontent/{id}")
    Optional<GardenContent> findById(@PathVariable int id) {
        return gardenContentService.findById(id);
    }

    @GetMapping("/gardencontent/garden/{id}")
    Iterable<GardenContent> findByGardenId(@PathVariable int id) { return gardenContentService.findAllByGardenId(id); }

    @GetMapping("/gardencontent")
    Iterable<GardenContent> findAll() {
        return gardenContentService.findAll();
    }


}
