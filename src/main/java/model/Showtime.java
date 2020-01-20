package model;

import java.time.LocalDateTime;

public class Showtime {
    private Long id;
    private Film movie;
    private Showroom showroom;
    private String date;
    private String finishHour;

    public Showtime(Long id, Film movie, Showroom showroom, String date, String finishHour) {
        this.id = id;
        this.movie = movie;
        this.showroom = showroom;
        this.date = date;
        this.finishHour = finishHour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return movie;
    }

    public void setFilm(Film film) {
        this.movie = film;
    }

    public Showroom getShowroom() {
        return showroom;
    }

    public void setShowroom(Showroom showroom) {
        this.showroom = showroom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.movie.toString() + ";" + this.showroom.getName() + ";" + this.date.toString();
    }
}
