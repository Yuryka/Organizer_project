package ro.fasttrackit.reminder.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.reminder.app.domain.Event;
import ro.fasttrackit.reminder.app.domain.User;
import ro.fasttrackit.reminder.app.repository.EventRepository;
import ro.fasttrackit.reminder.app.repository.UserRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class OrganizerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizerApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(EventRepository eventRepository, UserRepository userRepository) {
        return args -> {
            User Mama = new User("Maria");
            User Gyorgy = new User("Gyuri");
            userRepository.saveAll(List.of(
                    Mama,
                    Gyorgy,
                    new User("Erik"),
                    new User("Alex"),
                    new User("Raul")
            ));

            eventRepository.saveAll(List.of(
                    new Event("Pick up the kid", "from school, at 2pm", toDate(2020, 10, 11, 10, 59), true),
                    new Event("Buy groceries", "Selgros sausages and Csiki beer", toDate(2020, 5, 26, 18, 20), false, Mama),
                    new Event("Take exam", "Succeed with A+", toDate(2020, 6, 11, 07, 00), true, Gyorgy)
            ));


        };
    }

    private Date toDate(int year, int month, int day, int hour, int minute) {
        return new Date(LocalDateTime.of(year, month, day, hour, minute).toInstant(ZoneOffset.UTC).toEpochMilli());
    }
}
