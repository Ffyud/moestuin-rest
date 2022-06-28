package com.example.moestuinrest.service;

import com.example.moestuinrest.model.GardenContent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public interface GardenContentService extends CrudRepository<GardenContent, Integer> {


    @Query("SELECT u FROM GardenContent u WHERE u.garden.id = :gardenId")
    Iterable<GardenContent> findAllByGardenId(@Param("gardenId") int gardenId);

    @Query("SELECT u FROM GardenContent u WHERE u.positionX = :locationX " +
            "AND u.positionY = :locationY AND u.garden.id = :gardenId")
    Optional<GardenContent> findByGardenIdAndLocation(@Param("gardenId") int gardenId,
                                                      @Param("locationX") int locationX, @Param("locationY") int locationY);
    @Transactional
    @Modifying
    @Query("DELETE FROM GardenContent u WHERE u.positionX = :locationX " +
            "AND u.positionY = :locationY AND u.garden.id = :gardenId")
    void deleteByGardenIdAndLocation(@Param("gardenId") int gardenId,
                                                        @Param("locationX") int locationX, @Param("locationY") int locationY);
}
