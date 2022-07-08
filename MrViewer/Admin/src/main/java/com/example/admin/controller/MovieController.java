package com.example.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.example.admin.model.MovieModel;
import com.example.admin.service.MovieService;

// import antlr.collections.List;

@RestController
@CrossOrigin("*")
public class MovieController {
    
    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity<?> addMovie(@RequestBody MovieModel movie){
        try{
            movieService.addMovie(movie);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MovieModel>>getAll(){
        try{
            List<MovieModel> moiveList = movieService.getall();
            return new ResponseEntity<>(moiveList, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<MovieModel>>getById(@PathVariable("id") int id){
        try{
            Optional<MovieModel> movie = movieService.getById(id);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") int id){
        try{
            movieService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
