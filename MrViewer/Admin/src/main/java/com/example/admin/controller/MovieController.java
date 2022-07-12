package com.example.admin.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.admin.model.MovieModel;
import com.example.admin.service.MovieService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@CrossOrigin("*")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    @PostMapping("/")
    public String index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addActor");
        return "addActor.html";
    }

    // @RequestMapping(value = "/addMovie", method = RequestMethod.GET)
    @GetMapping("/addMovie")
    public String addMovie(@Valid @ModelAttribute MovieModel movie, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addMovie");
        model.addAttribute("movie", movie);
        return "addMovie.html";
    }

    @PostMapping("/addMovie")
    public String saveMovie(@Valid MovieModel movieModel, BindingResult result, Model model) {

        movieService.addMovie(movieModel);
        return "MovieAdded.html";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {
        model.addAttribute("movies", movieService.getall());
        return "index.html";

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<MovieModel>> getById(@PathVariable("id") int id) {
        try {
            Optional<MovieModel> movie = movieService.getById(id);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/deleteMovieById")
    public String deleteMovieById(@RequestParam int movieId) {
        movieService.deleteById(movieId);
        return "MovieDeleted.html";
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<?> updateById(@RequestBody MovieModel student, @PathVariable("id") int id) {
        try {
            movieService.updateById(student, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/updateMovieById")
    public String updateMovieById(@RequestParam("movieId") int movieId, Model model) {
        
        model.addAttribute("movie", movieService.getById(movieId));
        return "updateMovie.html";
    }

    @PostMapping("/updateMovieById")
    public String updateMovie(@RequestParam("movieId") int movieId, MovieModel movieModel, BindingResult result,
            Model model) {

        movieService.updateById(movieModel, movieId);
        movieService.addMovie(movieModel);
        return "MovieUpdated.html";
    }

}
