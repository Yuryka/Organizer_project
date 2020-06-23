package ro.fasttrackit.curs25.movies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs25.movies.domain.Event;
import ro.fasttrackit.curs25.movies.domain.Movie;
import ro.fasttrackit.curs25.movies.repository.EventRepository;
import ro.fasttrackit.curs25.movies.repository.MovieRepository;

import java.util.List;

@SpringBootApplication
public class Curs25MoviesApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs25MoviesApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(MovieRepository movieRepository, EventRepository eventRepository) {
        return args -> {
            eventRepository.saveAll(List.of(
                    new Event("pickup kid"),
                    new Event("feed the cat"),
                    new Event("buy sausage and beer")
                    ));
//TODO remove later movierepository

            movieRepository.saveAll(List.of(
                    new Movie("The Shawshank Redemption", 1994, 9.2),
                    new Movie("The Godfather", 1972, 9.1),
                    new Movie("The Godfather: Part II 3.", 1974, 9.0),
                    new Movie("The Dark Knight", 2008, 9.0)
            ));
        };
    }
}
