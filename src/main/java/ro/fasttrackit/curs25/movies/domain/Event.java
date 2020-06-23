package ro.fasttrackit.curs25.movies.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Integer id;
    private String note;

    public Event() {
    }

    public Event(final String note) {
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Event movie = (Event) o;
        return
                Objects.equals(id, movie.id) &&
                        Objects.equals(note, movie.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, note);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", note='" + note + '\'' +
                '}';
    }
}
