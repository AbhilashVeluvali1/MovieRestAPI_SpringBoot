package com.example.demo.service;

import java.util.ArrayList;

import com.google.gson.JsonObject;

public interface MovieService {
	
	public JsonObject getAllMovies();


	public ArrayList<String> getMoviesByreleaseDate(String releaseDate);


	public JsonObject getMovieOverView(String movieName);


	public JsonObject getMovieCrew(String movieName);


	public JsonObject getMoviesByCountry(String country);


	public JsonObject getMOviesByRatings(int rating);


	public String getMovieDetails(String name);


	ArrayList<String> getMoviesByGenre(String gnere);
	
}
