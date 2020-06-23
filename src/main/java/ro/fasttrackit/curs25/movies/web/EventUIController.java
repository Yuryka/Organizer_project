package ro.fasttrackit.curs25.movies.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.fasttrackit.curs25.movies.service.EventService;

@Controller
public class EventUIController {
    private final EventService localEventService;

    public EventUIController(final EventService eventService) {
        this.localEventService = eventService;
    }

    //TODO uncomment after movieuicontroller is deleted
    //@GetMapping
    //public String rootPage() {
    //   return "redirect:/organizer";
    //}

    @GetMapping("organizer")
    public String organizerPage(Model pageModel) {
       pageModel.addAttribute("events", localEventService.getAll());
        return "event";
    }
}
