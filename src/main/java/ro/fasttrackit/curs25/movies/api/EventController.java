package ro.fasttrackit.curs25.movies.api;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs25.movies.domain.Event;
import ro.fasttrackit.curs25.movies.service.EventService;


@RestController
@RequestMapping("api/organizer")
public class EventController {
    private final EventService eventService;

    public EventController(final EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    Event addEvent(@RequestBody Event newEvent) {
        return eventService.addEvent(newEvent);
    }

    @PutMapping("{id}")
    Event replaceEvent(@PathVariable int id, @RequestBody Event event) {
        return eventService.replaceEvent(id, event);
    }

    @DeleteMapping("{id}")
    Event deleteEvent(@PathVariable int id) {
        return eventService.deleteEvent(id);
    }
}
