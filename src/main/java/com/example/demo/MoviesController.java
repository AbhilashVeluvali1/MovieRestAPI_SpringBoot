package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.gson.*;

import com.example.demo.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/movies")
public class MoviesController {
	
	@Autowired
	MovieService movieService;
	
	//route to return the list of all movie names
	@GetMapping("/getAllMovies")
	public ResponseEntity<?> getAllMovies(){
		java.lang.reflect.Type listType = new TypeToken<List<String>>() {}.getType();
        ArrayList<String> moviesList = movieService.getAllMovies();
        Gson gson = new Gson();
        String json = gson.toJson(moviesList , listType );
        return ResponseEntity.ok(json);
	}
	
	//route to return movie name based on the releaseDate
	@GetMapping("/getMoviesByreleaseDate/{releaseDate}") 
	public ResponseEntity<?> getMoviesByreleaseDate(@PathVariable String releaseDate) {
		 ArrayList<String> moviesList = movieService.getMoviesByreleaseDate(releaseDate);
		 java.lang.reflect.Type listType = new TypeToken<List<String>>() {}.getType();
		 Gson gson = new Gson();
	     String json = gson.toJson(moviesList , listType );
	     return ResponseEntity.ok(json);
	}
	
	//route to return movie name based on the gnere
	@GetMapping(value = "/getMoviesByGnere/{gnere}", produces= "application/json") 
	public ResponseEntity<?> getMoviesByGnere(@PathVariable String gnere) {
		 ArrayList<String> moviesList = movieService.getMoviesByGenre(gnere);
		 
	     return ResponseEntity.ok(moviesList);
	}
	//route to return movie overview based on the movieName;
	@GetMapping(value = "/getMovieOverView/{movieName}", produces = "appplication/json") 
	public ResponseEntity<?> getMovieOverView(@PathVariable	String movieName) {
		JsonObject movieList = movieService.getMovieOverView(movieName);
		//ArrayList<String> moviesList = movieService.getMovieOverView(movieName);
		 
	     return ResponseEntity.ok(movieList.toString());
	}
	
	//route to return movie crew based on the movieName
	@GetMapping(value ="/getMovieCrew/{movieName}",produces = "application/json")
	public ResponseEntity<?> getMovieCrew(@PathVariable	String movieName) {
		JsonObject movieList = movieService.getMovieCrew(movieName);
		//ArrayList<String> moviesList = movieService.getMovieOverView(movieName);
		 
	     return ResponseEntity.ok(movieList.toString());
	}
	//route to return movies based on the language
	@GetMapping("/getMoviesByLanguage/{language}") 
	public ResponseEntity<?> getMoviesByLanguage(@PathVariable String language) {
		 ArrayList<String> moviesList = movieService.getMoviesByLanguage(language);
		 java.lang.reflect.Type listType = new TypeToken<List<String>>() {}.getType();
		 Gson gson = new Gson();
	     String json = gson.toJson(moviesList , listType );
	     return ResponseEntity.ok(json);
	}
	
	//route to return movie based on the country of origin 
	@GetMapping("/getMoviesByCountry/{country}") 
	public ResponseEntity<?> getMoviesByCountry(@PathVariable String country) {
		JsonObject movieList = movieService.getMoviesByCountry(country);
	     return ResponseEntity.ok(movieList.toString());
	}
	
	//route return movies  based on ratings
	@GetMapping("/getMoviesByRatings/{rating}")
	public ResponseEntity<?> getMOviesByRatings(@PathVariable int rating) {
		ArrayList<String> movieList = movieService.getMOviesByRatings(rating);
	     return ResponseEntity.ok(movieList.toString());
	}
	
	//route to return movie details by movieName
	@GetMapping(value = "/getMovieDetails/{name}", produces = "application/json") 
	public ResponseEntity<?> getMovieDetails(@PathVariable String name) {
		String movieList = movieService.getMovieDetails(name);
	     return ResponseEntity.ok(movieList);
	}

}
