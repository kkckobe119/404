package com.example.Movie404;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDB implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(LoadDB.class);

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String...args) throws Exception {
    	OscarSearch.Start();
    	
    	for(int i=0; i < 50; i++) {
    		movieRepository.save(OscarSearch.getHs()[i]);
    	}
    	
    	
        Iterable < HubioStructure > hbs = movieRepository.findAll();
        Iterator < HubioStructure > iterator = hbs.iterator();
        while (iterator.hasNext()) {
            logger.info("{}", iterator.next().toString());
        }

    }
}

