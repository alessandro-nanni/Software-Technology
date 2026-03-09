package com.amol.microservices.images.repository;

import org.springframework.data.repository.CrudRepository;

import com.amol.microservices.images.entity.Image;

import java.util.List;

/**
 * @author Amol Limaye
 **/
public interface ImageRepository extends CrudRepository<Image,Long>{

    List<Image> findAll();
}
