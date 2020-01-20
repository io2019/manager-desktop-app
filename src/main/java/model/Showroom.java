package model;

public class Showroom {
    private Long id;
    private String name;
    private int noOfColumns;
    private int noOfRows;

    public Showroom(Long id, String name, int cols, int rows) {
        this.id = id;
        this.name = name;
        this.noOfColumns = cols;
        this.noOfRows = rows;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }

    public void setNoOfColumns(int noOfColumns) {
        this.noOfColumns = noOfColumns;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
