package com.example.demo.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.MoviePojo;


public interface MoviesDao extends JpaRepository<MoviePojo, Integer> {

	ArrayList<MoviePojo> findByReleaseDate(LocalDate releaseDate);

	ArrayList<MoviePojo> findByGenereLike(String gnere);

	MoviePojo findByMovieName(String movieName);


	ArrayList<MoviePojo> findByCountry(String country);

	ArrayList<MoviePojo> findByRating(double calcScore);
}
