package model;

public class TicketType {

    private Long id;

    private String name;
    private double price;
    private boolean isActive;

    public TicketType() {
    }

    public TicketType(String name, double price, boolean isActive) {
        this.name = name;
        this.price = price;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getState() {
        return isActive;
    }

    public void setState(boolean isActive) {
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }
}
