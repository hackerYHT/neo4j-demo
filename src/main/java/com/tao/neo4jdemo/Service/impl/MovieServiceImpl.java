package com.tao.neo4jdemo.Service.impl;

import com.tao.neo4jdemo.Service.MovieService;
import com.tao.neo4jdemo.entity.Movie;
import com.tao.neo4jdemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yehaitao01
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> searchMoviesByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

}

