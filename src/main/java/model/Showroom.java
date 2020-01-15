package model;

import java.util.List;

public class Showroom {
    private int id;
    private int seatsNumber;
    private List<Seat> seats;

    public Showroom(int id, int seatsNumber, List<Seat> seats) {
        this.id = id;
        this.seatsNumber = seatsNumber;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}
