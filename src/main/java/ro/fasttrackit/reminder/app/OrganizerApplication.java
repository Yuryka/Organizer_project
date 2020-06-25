package ro.fasttrackit.reminder.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.reminder.app.domain.Event;
import ro.fasttrackit.reminder.app.repository.EventRepository;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrganizerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizerApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(EventRepository eventRepository) {
        return args -> {
            eventRepository.saveAll(List.of(
                    new Event("Pick up the kid", new Date(120, 5, 24), true),
                    new Event("Feed the cat", new Date(120, 5, 26), false),
                    new Event("Buy groceries (sausages and beers)", new Date(120, 6, 11), true)
            ));

        };
    }
}
