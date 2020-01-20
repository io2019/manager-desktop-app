package model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;

    private List<Ticket> tickets;

    private PersonalDetails client;

    private String state;

    private LocalDateTime date;
    private String transactionId;


    public Order() {
    }

    public Order(String email) {
        this.client = new PersonalDetails(email);
    }


    public Order(List<Ticket> tickets, PersonalDetails client, String state) {
        this.tickets = tickets;
        this.client = client;
        this.state = state;
    }

    public Order(List<Ticket> tickets, PersonalDetails client, String state, LocalDateTime date) {
        this.tickets = tickets;
        this.client = client;
        this.state = state;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public PersonalDetails getClient() {
        return client;
    }

    public void setClient(PersonalDetails client) {
        this.client = client;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getOrderValue()
    {
        double orderValue = 0;
        for (Ticket t : this.getTickets()) {
            orderValue += t.getTicketType().getPrice();
        }
        return  orderValue;
    }

}
