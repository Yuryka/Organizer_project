package ro.fasttrackit.reminder.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String nickName;

    public User(String nickName) {
        this.nickName = nickName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return
                Objects.equals(id, user.id) &&
                        Objects.equals(nickName, user.nickName);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname= " + nickName +
                '}';

    }
}
