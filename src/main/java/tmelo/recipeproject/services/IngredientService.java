package tmelo.recipeproject.services;

import tmelo.recipeproject.commands.IngredientCommand;

public interface IngredientService {
	public IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId);
	
	public IngredientCommand saveIngredientCommand(IngredientCommand command);
	
	public void deleteById(String recipeId, String idToDelete);
}
