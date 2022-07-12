package com.example.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.admin.model.Actor;
import com.example.admin.repository.ActorRepository;
import java.util.*;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorRepository actorRepository;

    @Override
    public void addActor(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public List<Actor> getall() {
        return actorRepository.findAll();
    }

    @Override
    public Optional<Actor> getById(long id) {
        return actorRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        actorRepository.deleteById(id);
    }

    @Override
    public int updateById(Actor actorObj, long id) {
        return 1;
    }
}
