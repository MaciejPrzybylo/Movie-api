package com.qa.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Recipe;
import com.qa.persistence.repository.RecipeDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class RecipeDBRepositoryTest {

	@InjectMocks
	private RecipeDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;


	private static final String MOCK_DATA_ARRAY = "[{\"title\":\"Alien\",\"ageRating\":\"15\"}]";

	private static final String MOCK_OBJECT = "{\"title\":\"Alien\",\"ageRating\":\"15\"}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	@Test
	public void testGetAllRecipe() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Recipe> recipe = new ArrayList<Recipe>();
		recipe.add(new Recipe("Alien", "15"));
		Mockito.when(query.getResultList()).thenReturn(recipe);
		System.out.println(repo.getAllRecipe());
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllRecipe());
	}

	@Test
	public void testCycleRecipe() {

		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Recipe> recipe = new ArrayList<Recipe>();
		recipe.add(new Recipe("Alien", "15"));
		Mockito.when(query.getResultList()).thenReturn(recipe);
		Assert.assertEquals(1, repo.cycleRecipe("Alien"));

	}

	@Test
	public void testCreateRecipe() {
		String reply = repo.createRecipe(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"recipe has been sucessfully added\"}");
	}

	@Test
	public void testDeleteRecipe() {
		String reply = repo.deleteRecipe(1L);
		Assert.assertEquals(reply, "{\"message\": \"recipe sucessfully deleted\"}");
	}

}
