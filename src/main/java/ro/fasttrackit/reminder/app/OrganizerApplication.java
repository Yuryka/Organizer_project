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
            User Gyorgy = new User("Gyuri");
            userRepository.saveAll(List.of(
                    new User("Pista"),
                    Gyorgy,
                    new User("Jeno")
            ));

            eventRepository.saveAll(List.of(
                    new Event("Pick up the kid", "from school", toDate(2019, 10, 11, 12, 11), true),
                    new Event("Buy groceries", "Selgros sausages and Csiki beer", toDate(120, 5, 26, 18, 20), false, Gyorgy),
                    new Event("Take exam", "Succeed", toDate(120, 6, 11, 19, 30), true)
            ));


        };
    }

    private Date toDate(int year, int month, int day, int hour, int minute) {
        return new Date(LocalDateTime.of(year, month, day, hour, minute).toInstant(ZoneOffset.UTC).toEpochMilli());
    }
}
