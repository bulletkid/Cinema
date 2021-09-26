package com.manuanand.cinema;

import org.springframework.data.repository.CrudRepository;

import com.manuanand.cinema.Video;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface VideoRepository extends CrudRepository<Video, Integer> {

}
