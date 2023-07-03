package com.example.demo.service;

import java.util.ArrayList;

import com.google.gson.JsonObject;

public interface MovieService {
	
	public ArrayList<String> getAllMovies();


	public ArrayList<String> getMoviesByreleaseDate(String releaseDate);


	public ArrayList<String> getMoviesByGenre(String gnere);


	public JsonObject getMovieOverView(String movieName);


	public JsonObject getMovieCrew(String movieName);


	public ArrayList<String> getMoviesByLanguage(String language);


	public JsonObject getMoviesByCountry(String country);
	
}
