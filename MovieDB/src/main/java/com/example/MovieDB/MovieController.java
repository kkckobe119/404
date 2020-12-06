package com.example.MovieDB;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	private final MovieRepository repository;

	  MovieController(MovieRepository repository) {
	    this.repository = repository;
	  }

	  // Aggregate root

	  @GetMapping("/movies")
	  List<Movie> all() {
	    return repository.findAll();
	  }

	  @PostMapping("/movies")
	  Movie newMovie(@RequestBody Movie newMovie) {
	    return repository.save(newMovie);
	  }
	
}
