package ro.fasttrackit.curs25.movies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs25.movies.domain.Event;
import ro.fasttrackit.curs25.movies.repository.EventRepository;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Curs25MoviesApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs25MoviesApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(EventRepository eventRepository) {
        return args -> {
            eventRepository.saveAll(List.of(
                    new Event("pick up kid", new Date(120, 5, 24), true),
                    new Event("feed the cat", new Date(120, 5, 26), false),
                    new Event("buy sausage and beer", new Date(120, 6, 11), true)
            ));

        };
    }
}
