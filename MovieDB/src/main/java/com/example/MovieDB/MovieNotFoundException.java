package com.example.MovieDB;

@SuppressWarnings("serial")
public class MovieNotFoundException extends RuntimeException {
	
	MovieNotFoundException(Long id) {
	    super("Could not find employee " + id);
	}
}
