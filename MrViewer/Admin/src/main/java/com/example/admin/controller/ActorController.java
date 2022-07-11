package com.example.admin.controller;
import com.example.admin.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.admin.repository.ActorRepository;
import com.example.admin.service.ActorService;

import java.util.*;

@Controller
@CrossOrigin("*")
public class ActorController {
    
    @Autowired
    ActorService actorService;

    @GetMapping("getActors/")
    public ResponseEntity<List<Actor>>getAll(){
        try {
            List<Actor> actorList = actorService.getall();
            return new ResponseEntity<>(actorList, HttpStatus.OK);
        }
    catch(Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("addActor/")
    public ResponseEntity<?> addActor(@RequestBody Actor actor){
        try{
            actorService.addActor(actor);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByActorId/{id}")
    public ResponseEntity<Optional<Actor>>getById(@PathVariable("id") long id){
        try{
            Optional<Actor>actor = actorService.getById(id);
            return new ResponseEntity<>(actor, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @DeleteMapping("/deleteActorById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id){
        try{
            actorService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
