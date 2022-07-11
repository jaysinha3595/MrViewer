package com.example.admin.service;

import java.util.Optional;
import java.util.List;
import com.example.admin.model.Actor;


public interface ActorService {
    void addActor(Actor actor);
    List<Actor>getall();
    Optional<Actor> getById(long id);
    void deleteById(long id);
    void updateById(Actor actorObj, long id);

}
