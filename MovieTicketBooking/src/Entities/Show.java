package Entities;

import java.time.LocalDateTime;

public class Show {
    String id;
    Movie movie;
    Theater theater;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Show(String id, Movie movie, Theater theater, Screen screen, LocalDateTime startTime) {
        this.id = id;
        this.movie = movie;
        this.theater = theater;
        this.screen = screen;
        this.startTime = startTime;
    }
    public Theater getTheater() { return theater; }

    Screen screen;
    LocalDateTime startTime;
}
