package model;

import java.util.List;

public class Showroom {
    private long id;
    private long seatsNumber;
    private List<Seat> seats;

    public Showroom(long id, long seatsNumber, List<Seat> seats) {
        this.id = id;
        this.seatsNumber = seatsNumber;
        this.seats = seats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(long seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
