package com.example.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

}
