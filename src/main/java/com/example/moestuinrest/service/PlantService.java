package com.example.moestuinrest.service;

import com.example.moestuinrest.model.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface PlantService extends CrudRepository<Plant, Integer> {
}
