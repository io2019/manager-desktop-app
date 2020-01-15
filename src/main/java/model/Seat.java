package model;

public class Seat {
    private long number;
    private boolean free;

    public Seat(long number) {
        this.free = true;
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
