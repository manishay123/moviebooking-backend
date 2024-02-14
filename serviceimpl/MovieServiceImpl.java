package com.moviebookingapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.moviebookingapp.excpetion.CustomMessageException;

import com.moviebookingapp.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebookingapp.repository.MovieRepo;
import com.moviebookingapp.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {


	@Autowired
	MovieRepo movieRepo;

	@Override
	public Movie addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepo.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> propertyDetails = new ArrayList<>();
		movieRepo.findAll().forEach(e-> propertyDetails.add(e) );
		return propertyDetails;
	}


	@Override
	public Movie deleteMovie(String id) throws CustomMessageException {
		// TODO Auto-generated method stub
		Optional<Movie> mov = movieRepo.findById(id);
		if(mov.isPresent()) {
			movieRepo.deleteById(id);
			return mov.get();
		}
		throw new CustomMessageException("Movie not found for this id.");
	}


	@Override
	public Movie searchMovieById(String id) {
		return movieRepo.findById(id).get();
	}

	@Override
	public List<Movie> searchMovieByName(String name) {
		
		return movieRepo.findAllByMovieNameIgnoreCaseContaining(name);
	}

	@Override
	public Movie updateMovie(String id, Movie movie) {
		// TODO Auto-generated method stub
		Movie updatedmovie = movieRepo.findById(id).get();
		updatedmovie.setMovieName(movie.getMovieName());
		updatedmovie.setSeatAvailable(movie.getSeatAvailable());
		updatedmovie.setTheatreName(movie.getTheatreName());
		
		return  movieRepo.save(updatedmovie);
	}


}
