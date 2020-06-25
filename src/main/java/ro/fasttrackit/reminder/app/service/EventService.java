package ro.fasttrackit.reminder.app.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.reminder.app.domain.Event;
import ro.fasttrackit.reminder.app.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(final EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEvent(final Integer id) {
        return eventRepository.findById(id);
    }

    public Event getEventOrThrow(final Integer id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find event with id " + id));
    }

    public Event addEvent(Event newEvent) {
        return eventRepository.save(newEvent);
    }

    public Event deleteEvent(int id) {
        Event event = getEventOrThrow(id);
        eventRepository.deleteById(id);
        return event;
    }

    public Event replaceEvent(int id, Event event) {
        event.setId(id);
        return eventRepository.save(event);
    }
}
