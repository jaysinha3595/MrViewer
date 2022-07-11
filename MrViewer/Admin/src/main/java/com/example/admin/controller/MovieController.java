package com.example.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import com.example.admin.model.MovieModel;
import com.example.admin.service.MovieService;

// import antlr.collections.List;

// @
@Controller
@CrossOrigin("*")
public class MovieController {
    
    @Autowired
    MovieService movieService;

    // @RequestMapping(method = RequestMethod.GET, value = "/")  

    @GetMapping
    @PostMapping("/")
    public String index()  
    {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("addActor");
    return "addActor.html";
    }   

    // // API Add movie
    // @PostMapping("/addMovie")
    // public ResponseEntity<?> addMovie(@RequestBody MovieModel movie){
    //     try{
    //         movieService.addMovie(movie);
    //         return new ResponseEntity<>(HttpStatus.OK);
    //     }
    //     catch(Exception e){
    //         return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @RequestMapping(value = "/addMovie", method = {RequestMethod.GET, RequestMethod.POST})
    // @GetMapping("/addMovie")
    public String addMovie(@ModelAttribute MovieModel movie, Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addMovie");
        model.addAttribute("movie", movie);
        movieService.addMovie(movie);

        return "addMovie.html";
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
            model.addAttribute("movies", movieService.getall());
            return "index.html";
            
            // List<MovieModel> moiveList = movieService.getall();
            // return new ResponseEntity<>(moiveList, HttpStatus.OK);

        
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

    // @DeleteMapping("/deleteMovieById/{id}")
    // public ResponseEntity<?> deleteById(@PathVariable("id") int id){
    //     try{
    //         movieService.deleteById(id);
    //         return new ResponseEntity<>(HttpStatus.OK);
    //     }
    //     catch(Exception e){
    //         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @RequestMapping(value = "/deleteMovieById", method = {RequestMethod.GET})
    public String deleteMovieById(@RequestParam int movieId){
        movieService.deleteById(movieId);
        return "index.html";
    }

}
