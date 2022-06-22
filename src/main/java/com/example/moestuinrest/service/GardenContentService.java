package com.example.moestuinrest.service;

import com.example.moestuinrest.model.Garden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface GardenContentService extends CrudRepository<Garden, Integer> {


}
