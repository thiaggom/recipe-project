package tmelo.recipeproject.services;

import java.util.Set;

import tmelo.recipeproject.commands.RecipeCommand;
import tmelo.recipeproject.domain.Recipe;

public interface RecipeService {

	public Set<Recipe> getAllRecipes();
	
	public void saveRecipe(Recipe recipe);

	public Recipe getRecipeById(String id);

	public void deleteRecipeById(String id);
	
	public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);

	public RecipeCommand findCommandById(String id);
	
	
}
