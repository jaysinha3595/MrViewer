package com.example.admin.service;

import com.example.admin.model.MovieModel;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    void addMovie(MovieModel movie);

    List<MovieModel> getall();

    Optional<MovieModel> getById(int id);

    void deleteById(int id);

    void updateById(MovieModel movieObj, int id);

}
