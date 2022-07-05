package com.example.moestuinrest.service;

import com.example.moestuinrest.model.Plant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface PlantService extends CrudRepository<Plant, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Plant u WHERE u.id = :plantId")
    void deleteByPlantId(@Param("plantId") int plantId);
}
