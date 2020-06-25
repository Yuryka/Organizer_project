package ro.fasttrackit.reminder.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.reminder.app.domain.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
