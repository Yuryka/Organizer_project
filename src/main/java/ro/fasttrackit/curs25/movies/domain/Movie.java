package ro.fasttrackit.curs25.movies.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private int year;
    private double rating;

    public Movie() {
    }

    public Movie(final String title, final int year, final double rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(final double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Movie movie = (Movie) o;
        return year == movie.year &&
                Double.compare(movie.rating, rating) == 0 &&
                Objects.equals(id, movie.id) &&
                Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, rating);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}
