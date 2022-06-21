package com.example.moestuinrest.service;

import com.example.moestuinrest.model.Garden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public interface GardenService extends CrudRepository<Garden, Integer> {


}
