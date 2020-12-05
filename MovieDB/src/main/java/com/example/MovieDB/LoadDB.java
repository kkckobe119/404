package com.example.MovieDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDB {

	private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

	  @Bean
	  CommandLineRunner initDatabase(MovieRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save(
	    		  new Movie(1,"1927","1928","1","ACTOR","Richard Barthelmess","The Noose",false)
	    	));
	      log.info("Preloading " + repository.save(
	    		  new Movie(2,"1927","1928","1","ACTOR","Emil Jannings","The Last Command",true)
	    	));
	    };
	  }
	
}
