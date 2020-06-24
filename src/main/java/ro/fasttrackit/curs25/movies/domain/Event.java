package ro.fasttrackit.curs25.movies.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Integer id;
    private String note;
    private Date date;
    private Boolean checked;

    public Event() {

    }

    public Event(final String note, final Date date, final Boolean checked) {
        this.note = note;
        this.date = date;
        this.checked = checked;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Event event = (Event) o;
        return date == event.date &&
                Boolean.compare(event.checked, checked)== 0 &&
                Objects.equals(id, event.id) &&
                Objects.equals(note, event.note);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, note);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", note= " + note +
                ", date " + date +
                ", checked " + checked +
                '}';

    }
}
