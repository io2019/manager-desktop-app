package model;

import java.time.LocalTime;

public class Film {
    private Long id;
    private String title;
    private String category;
    private String duration;
    private String description;
    private String director;
    private int ageRestriction;

    public Film(Long id, String title, String category, String duration, String description, String director, int ageRestriction) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.description = description;
        this.director = director;
        this.ageRestriction = ageRestriction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @Override
    public String toString() {
        return this.title;
    }

}
