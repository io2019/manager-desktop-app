package model;

import java.util.Date;

public class Show {
    private long id;
    private Film film;
    private Room room;
    private Date date;

    public Show(long id, Film film, Room room, Date date) {
        this.id = id;
        this.film = film;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
