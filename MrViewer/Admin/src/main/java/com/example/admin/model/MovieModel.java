package com.example.admin.model;
import javax.persistence.*;
import java.util.*;
// import java.util.Objects;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.validation.constraints.AssertTrue;
// import javax.validation.constraints.Max;

@Entity
@Table(name = "movies")
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="movieId")
    private int movieId;

    @Column(name="movieName")
    private String movieName;

    @Column(name="movieUrl")
    private String movieUrl;

    @Column(name="moviePostUrl")
    private String moviePosterUrl;

    @Column(name="movieCast")
    private String movieCast;

    @Column(name="duration")
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


    public MovieModel(int movieId, String movieName, String movieUrl, String moviePosterUrl, String movieCast, int duration) {
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
