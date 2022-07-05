package com.example.moestuinrest.service;

import com.example.moestuinrest.model.Garden;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface GardenService extends CrudRepository<Garden, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Garden u WHERE u.id = :gardenId")
    void deleteByGardenId(@Param("gardenId") int gardenId);
}
