package com.example.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.model.MovieModel;
import com.example.admin.repository.MovieRepository;
import java.util.*;
@Service
public class MovieServiceImpl implements MovieService{
    
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(MovieModel movie){
        movieRepository.save(movie);
    }

    @Override
    public List<MovieModel> getall(){
        return movieRepository.findAll();
    }

    @Override
    public Optional<MovieModel> getById(int id){
        return movieRepository.findById(id);
    }

    @Override
    public void deleteById(int id){
        movieRepository.deleteById(id);;
    }

    @Override
    public void updateById(MovieModel movieObj, int id){
        // MovieModel movie = movieRepository.getOne
    }
}
