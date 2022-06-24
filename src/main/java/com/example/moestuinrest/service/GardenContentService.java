package com.example.moestuinrest.service;

import com.example.moestuinrest.model.GardenContent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface GardenContentService extends CrudRepository<GardenContent, Integer> {


    @Query("select u from GardenContent u where u.garden.id = :gardenId")
    Iterable<GardenContent> findAllByGardenId(@Param("gardenId") int gardenId);

}
