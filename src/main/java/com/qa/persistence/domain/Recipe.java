package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Recipe {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String title;
	private String ageRating;

	public Recipe() {

	}

	public Recipe(String title, String ageRating) {
		this.title = title;
		this.ageRating = ageRating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}


}
