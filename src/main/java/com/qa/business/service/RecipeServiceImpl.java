package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.RecipeRepository;

public class RecipeServiceImpl implements RecipeService {

	@Inject
	private RecipeRepository repo;

	public String getAllRecipe() {
		return repo.getAllRecipe();
	}

	@Override
	public String addRecipe(String recipe) {
		if(recipe.contains("Titanic")) {
			
			return "Can't Add This Movie";
		}
		return repo.createRecipe(recipe);
	}

	@Override
	public String deleteRecipe(Long id) {
		return repo.deleteRecipe(id);
	}

	public void setRepo(RecipeRepository repo) {
		this.repo = repo;
	}

	@Override
	public int cycleRecipe(String title) {

		return repo.cycleRecipe(title);

	}

	@Override
	public String getARecipe(Long id) {
		return repo.getARecipe(id);
		
	}

	@Override
	public String updateRecipe(String movie, Long id) {
		return repo.updateRecipe(movie, id);
	}


}
