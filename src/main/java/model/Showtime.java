package model;

import java.util.Date;

public class Showtime {
    private long id;
    private Film film;
    private Showroom showroom;
    private Date date;

    public Showtime(long id, Film film, Showroom showroom, Date date) {
        this.id = id;
        this.film = film;
        this.showroom = showroom;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Showroom getShowroom() {
        return showroom;
    }

    public void setShowroom(Showroom showroom) {
        this.showroom = showroom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
