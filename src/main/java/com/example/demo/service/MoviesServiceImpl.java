package com.example.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MoviesDao;
import com.example.demo.pojo.MoviePojo;
import com.google.gson.JsonObject;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MoviesServiceImpl implements MovieService {
	
	@Autowired
	MoviesDao movieRepo;   //Dependency injection of DAO layer

	@Override
	public ArrayList<String> getAllMovies() {
		// TODO Auto-generated method stub\
		ArrayList<String> movieList = new ArrayList<String>();
		movieRepo.findAll().forEach(x -> {
			movieList.add(x.getMovieName());
		});
		System.out.println(movieList);
		return movieList;
	}
	
	@Override
	public ArrayList<String> getMoviesByreleaseDate(String releaseDate) {
		ArrayList<String> movieList = new ArrayList<String>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(releaseDate,formatter);
		movieRepo.findByReleaseDate(localDate).forEach(x -> {
			movieList.add(x.getMovieName());
		});
		return movieList;
		
	}

	@Override
	public ArrayList<String> getMoviesByGenre(String gnere) {
		ArrayList<String> movieList = new ArrayList<String>();
		movieRepo.findByGenere(gnere).forEach(x -> {
			movieList.add(x.getMovieName());
		});
		System.out.println(movieList);
		return movieList;
		
	}

	@Override
	public JsonObject getMovieOverView(String movieName) {
		MoviePojo list = movieRepo.findByMovieName(movieName);
		JsonObject json = new JsonObject();
		json.addProperty("movieName", list.getMovieName());
		json.addProperty("overview", list.getOverView());
		return json;
	}

	@Override
	public JsonObject getMovieCrew(String movieName) {
		MoviePojo list = movieRepo.findByMovieName(movieName);
		JsonObject json = new JsonObject();
		json.addProperty("movieName", list.getMovieName());
		json.addProperty("crew", list.getCrew());
		return json;
	}

	@Override
	public ArrayList<String> getMoviesByLanguage(String language) {
		ArrayList<String> movieList = new ArrayList<String>();
		movieRepo.findByOriginalLanguage(language).forEach(x -> {
			movieList.add(x.getMovieName());
		});
		System.out.println(movieList);
		return movieList;
	}

	@Override
	public JsonObject getMoviesByCountry(String country) {
		ArrayList <MoviePojo> list = movieRepo.findByCountry(country);
		JsonObject json = new JsonObject();
		
		
		json.addProperty("country", country);
		json.addProperty("MovieDetails:", list.toString());
		return json;
		
	}
}
