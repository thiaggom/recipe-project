package tmelo.recipeproject.services;

import java.util.Set;

import tmelo.recipeproject.commands.RecipeCommand;
import tmelo.recipeproject.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getAllRecipes();
	
	Recipe getRecipeById(final String id);

	void deleteRecipeById(final String id);
	
	RecipeCommand saveRecipeCommand(final RecipeCommand recipeCommand);

	RecipeCommand findCommandById(final String id);
	
	
}
