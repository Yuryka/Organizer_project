package ro.fasttrackit.curs25.movies.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.fasttrackit.curs25.movies.domain.Event;
import ro.fasttrackit.curs25.movies.service.EventService;

import java.util.Optional;

@Controller
public class EventUIController {
    private final EventService localEventService;

    public EventUIController(final EventService eventService) {
        this.localEventService = eventService;
    }

    @GetMapping
    public String rootPage() {
        return "redirect:/organizer";
    }

    @GetMapping("organizer")
    public String organizerPage(Model pageModel) {
        pageModel.addAttribute("events", localEventService.getAll());
        return "event";
    }

    @GetMapping("events/{id}")
    public String eventPageWithDetails(@PathVariable Integer id, Model pageModel) {
        Optional<Event> event = localEventService.getEvent(id);
        if (event.isPresent()) {
            pageModel.addAttribute("showDetails", true);
            pageModel.addAttribute("selectedEvent", localEventService.getEventOrThrow(id));
            return organizerPage(pageModel);
        } else {
            return "redirect:/organizer";
        }
    }
}
