package com.example.Movie404;

@SuppressWarnings("serial")
public class MovieNotFoundException extends RuntimeException {
	
	MovieNotFoundException(Long id) {
	    super("Could not find employee " + id);
	}
}
