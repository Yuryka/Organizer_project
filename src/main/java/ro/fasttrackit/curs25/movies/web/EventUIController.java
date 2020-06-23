package ro.fasttrackit.curs25.movies.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.fasttrackit.curs25.movies.domain.Movie;
import ro.fasttrackit.curs25.movies.service.MovieService;

import java.util.Optional;

@Controller
public class EventUIController {
    private final MovieService movieService;

    public EventUIController(final MovieService movieService) {
        this.movieService = movieService;
    }

    //TODO uncomment after movieuicontroller is deleted
    //@GetMapping
    //public String rootPage() {
    //   return "redirect:/organizer";
    //}

    @GetMapping("organizer")
    public String organizerPage(Model pageModel) {
        //pageModel.addAttribute("movies", movieService.getAll());
        return "event";
    }
}
