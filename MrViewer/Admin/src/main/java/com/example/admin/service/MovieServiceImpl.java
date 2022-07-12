package com.example.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.model.MovieModel;
import com.example.admin.repository.MovieRepository;
import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void addMovie(MovieModel movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<MovieModel> getall() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<MovieModel> getById(int id) {
        return movieRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        movieRepository.deleteById(id);
    }

    @Override
    public void updateById(MovieModel movieObj, int id) {
        Optional<MovieModel> movieModel = movieRepository.findById(id);
        movieModel.orElseThrow().setMovieName(movieObj.getMovieName());
        movieModel.orElseThrow().setMovieUrl(movieObj.getMovieUrl());
        movieModel.orElseThrow().setMoviePosterUrl(movieObj.getMoviePosterUrl());
        movieModel.orElseThrow().setMovieCast(movieObj.getMovieCast());
        movieModel.orElseThrow().setDuration(movieObj.getDuration());
    }
}
