package tmelo.recipeproject.services;

import tmelo.recipeproject.commands.IngredientCommand;

public interface IngredientService {
	IngredientCommand findByRecipeIdAndIngredientId(final String recipeId, final String ingredientId);
	
	IngredientCommand saveIngredientCommand(final IngredientCommand command);
	
	void deleteById(final String recipeId, final String idToDelete);
}
