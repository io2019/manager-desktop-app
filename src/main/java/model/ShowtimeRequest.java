package model;

import java.time.LocalDateTime;

public class ShowtimeRequest {
    private Long movieId;
    private Long showroomId;
    private LocalDateTime dateTime;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getShowroomId() {
        return showroomId;
    }

    public void setShowroomId(Long showroomId) {
        this.showroomId = showroomId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

