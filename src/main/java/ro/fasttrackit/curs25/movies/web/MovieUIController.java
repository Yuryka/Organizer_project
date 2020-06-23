package ro.fasttrackit.curs25.movies.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.fasttrackit.curs25.movies.domain.Movie;
import ro.fasttrackit.curs25.movies.service.MovieService;

import java.util.Optional;

@Controller
public class MovieUIController {
    private final MovieService movieService;

    public MovieUIController(final MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String rootPage() {
        return "redirect:/movies";
    }

    @GetMapping("movies")
    public String moviesPage(Model pageModel) {
        pageModel.addAttribute("movies", movieService.getAll());
        return "movies";
    }

    @GetMapping("movies/{id}")
    public String moviesPageWithDetails(@PathVariable Integer id, Model pageModel) {
        Optional<Movie> movie = movieService.getMovie(id);
        if (movie.isPresent()) {
            pageModel.addAttribute("showDetails", true);
            pageModel.addAttribute("selectedMovie", movieService.getMovieOrThrow(id));
            return moviesPage(pageModel);
        } else {
            return "redirect:/movies";
        }
    }
}
