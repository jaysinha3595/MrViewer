package com.example.admin.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "movies")
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movieId")
    private int movieId;

    @NotBlank
    @NotNull
    @Column(name = "movieName", unique = true)
    private String movieName;

    @NotBlank
    @NotNull
    @Column(name = "movieUrl")
    private String movieUrl;

    @NotBlank
    @NotNull
    @Column(name = "moviePostUrl")
    private String moviePosterUrl;

    @Column(name = "movieCast")
    private String movieCast;

    @Positive
    @NotBlank
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "duration")
    private int duration;

    public int getMovieId() {
        return this.movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieUrl() {
        return this.movieUrl;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public String getMoviePosterUrl() {
        return this.moviePosterUrl;
    }

    public void setMoviePosterUrl(String moviePosterUrl) {
        this.moviePosterUrl = moviePosterUrl;
    }

    public String getMovieCast() {
        return this.movieCast;
    }

    public void setMovieCast(String movieCast) {
        this.movieCast = movieCast;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public MovieModel() {
    }

    public MovieModel(int movieId, String movieName, String movieUrl, String moviePosterUrl, String movieCast,
            int duration) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieUrl = movieUrl;
        this.moviePosterUrl = moviePosterUrl;
        this.movieCast = movieCast;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "{" +
                " movieId='" + getMovieId() + "'" +
                ", movieName='" + getMovieName() + "'" +
                ", movieUrl='" + getMovieUrl() + "'" +
                ", moviePosterUrl='" + getMoviePosterUrl() + "'" +
                ", movieCast='" + getMovieCast() + "'" +
                ", duration='" + getDuration() + "'" +
                "}";
    }

}
