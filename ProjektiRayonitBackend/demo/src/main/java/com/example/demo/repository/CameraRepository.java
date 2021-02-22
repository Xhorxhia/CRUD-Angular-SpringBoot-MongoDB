package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Camera;

@Repository
public interface CameraRepository extends MongoRepository<Camera, Integer> {

	List<String> findByResolution(List<Camera> camera);

}