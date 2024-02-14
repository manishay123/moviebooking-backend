package com.moviebookingapp.service;

import java.util.List;

import com.moviebookingapp.model.Movie;


public interface MovieService {

    Movie addMovie(Movie movie);
List<Movie> getAllMovies();

    Movie deleteMovie(String id);
    Movie updateMovie(String id, Movie movie);
Movie searchMovieById(String id);
List<Movie> searchMovieByName(String name);

}
