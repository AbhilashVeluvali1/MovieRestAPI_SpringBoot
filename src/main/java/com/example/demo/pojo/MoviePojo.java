package com.example.demo.pojo;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity //specifies that this is an entity in the database
@Table(name = "movies")
public class MoviePojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private Integer movieId;
	@Column(name ="movie_name")
	private String movieName;
	@Column(name ="genere")
	private String genere;
	@Column(name ="release_date")
	private LocalDate releaseDate;
	@Column(name ="country")
	private String country;
	@Column(name ="original_language")
	private String originalLanguage;
	@Column(name = "overview")
	private String overView;
	@Column(name = "crew")
	private String crew;
	@Column(name = "score")
	private int rating;
	
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getCrew() {
		return crew;
	}
	public void setCrew(String crew) {
		this.crew = crew;
	}
	public String getOverView() {
		return overView;
	}
	public void setOverView(String overView) {
		this.overView = overView;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getGnere() {
		return genere;
	}
	public void setGnere(String gnere) {
		this.genere = gnere;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOrinigalLanguage() {
		return originalLanguage;
	}
	public void setOrinigalLanguage(String orinigalLanguage) {
		this.originalLanguage = orinigalLanguage;
	}
	@Override
	public String toString() {
		return "MoviePojo [movieId=" + movieId + ", movieName=" + movieName + ", genere=" + genere + ", releaseDate="
				+ releaseDate + ", country=" + country + ", originalLanguage=" + originalLanguage + ", overView="
				+ overView + ", crew=" + crew + ", rating=" + rating + "]";
	}
	
	

}
