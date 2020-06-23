package ro.fasttrackit.curs25.movies.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs25.movies.domain.Movie;
import ro.fasttrackit.curs25.movies.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(final Integer id) {
        return movieRepository.findById(id);
    }

    public Movie getMovieOrThrow(final Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find movie with id " + id));
    }

    public Movie addMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    public Movie deleteMovie(int id) {
        Movie movie = getMovieOrThrow(id);
        movieRepository.deleteById(id);
        return movie;
    }

    public Movie replaceMovie(int id, Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }
}
