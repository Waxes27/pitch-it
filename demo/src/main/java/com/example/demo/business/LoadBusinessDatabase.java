package com.example.demo.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBusinessDatabase {
    
    private static final Logger log = LoggerFactory.getLogger(LoadBusinessDatabase.class);

    @Bean
    CommandLineRunner initDatabase(BusinessRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Business("Codec", "Thato", "Moletsane", "CEO", "tmoletsa@gmail.com", "thatospassword")));
            log.info("Preloading " + repository.save(new Business("Black Tech", "Nceba", "Dumasi", "CEO", "ndumasi@gmail.com", "ncebaspassword")));
        };
    }
}
