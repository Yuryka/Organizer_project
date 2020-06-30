package ro.fasttrackit.reminder.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.reminder.app.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
