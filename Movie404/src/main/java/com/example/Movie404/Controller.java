package com.example.Movie404;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	private final MovieRepository repository;

	  Controller(MovieRepository repository) {
	    this.repository = repository;
	  }

	  // Aggregate root

	  @GetMapping("/movies")
	  List<HubioStructure> all() {
	    return repository.findAll();
	  }

	  @PostMapping("/movies")
	  HubioStructure newHubioStructure(@RequestBody HubioStructure newMovie) {
	    return repository.save(newMovie);
	  }
	  
	  @GetMapping("/movies/{id}")
	  Optional<HubioStructure> findOne(@PathVariable Long id) {
	    return repository.findById(id);
	  }
	  
}


