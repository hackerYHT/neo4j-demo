package com.tao.neo4jdemo.Service;


import com.tao.neo4jdemo.entity.Movie;
import com.tao.neo4jdemo.repository.MovieRepository;

import java.util.List;

/**
 * @author yehaitao01
 */
public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieById(Long id);

    Movie createMovie(Movie movie);

    Movie updateMovie(Long id, Movie movie);

    void deleteMovie(Long id);

    List<Movie> searchMoviesByTitle(String keyword);

}
