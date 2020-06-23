package ro.fasttrackit.curs25.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs25.movies.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
