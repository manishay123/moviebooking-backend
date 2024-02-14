package com.moviebookingapp.repository;

import com.moviebookingapp.model.Movie;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends MongoRepository<Movie,String> {

	List<Movie> findAllByMovieNameIgnoreCaseContaining(String name);
	//Movie getByStringMovie(String id, Movie movie);
}
