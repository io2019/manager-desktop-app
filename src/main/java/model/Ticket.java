package model;

public class Ticket {

    private Long id;

    private Showtime showtime;


    private TicketType ticketType;

    private Integer seatPosition;

    public Ticket() {
    }

    public Ticket(Integer seatPosition, Showtime showtime, TicketType ticketType) {
        this.seatPosition = seatPosition;
        this.showtime = showtime;
        this.ticketType = ticketType;
    }

    public Long getId() {
        return id;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public Integer getSeatPosition() {
        return seatPosition;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setSeatPosition(Integer seatPosition) {
        this.seatPosition = seatPosition;
    }
}
