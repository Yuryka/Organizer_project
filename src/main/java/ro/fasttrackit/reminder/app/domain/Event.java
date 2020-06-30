package ro.fasttrackit.reminder.app.domain;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Integer id;
    private String note;
    private String details;
    private Date date;
    private Boolean checked;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User responsible;

    public Event ()
    {}

    public Event(final String note, final String details, final Date date, final Boolean checked) {
        this.note = note;
        this.details = details;
        this.date = date;
        this.checked = checked;
    }

    public Event(final String note, final String details, final Date date, final Boolean checked, final User responsible) {
        this.note = note;
        this.details = details;
        this.date = date;
        this.checked = checked;
        this.responsible = responsible;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Event event = (Event) o;
        return date == event.date &&
                Boolean.compare(event.checked, checked) == 0 &&
                Objects.equals(id, event.id) &&
                Objects.equals(note, event.note) &&
                Objects.equals(details, event.details);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, note, details, date, checked);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", note= " + note +
                ", details " + details +
                ", date " + date +
                ", checked " + checked +
                '}';

    }


}
