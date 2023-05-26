package com.tao.neo4jdemo.controller;

import com.tao.neo4jdemo.Service.movie.MovieService;
import com.tao.neo4jdemo.entity.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yehaitao01
 */
@RequestMapping("/api/movie")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("getMovieByTitle")
    public List<Movie> getMovieByTitle(@RequestParam(value = "title", required = true) String title){
        return movieService.searchMoviesByTitle(title);
    }


    @GetMapping("getAllMovies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
}
