package com.example.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.admin.model.MovieModel;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Integer> {

}
