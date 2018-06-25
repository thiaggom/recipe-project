package tmelo.recipeproject.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import tmelo.recipeproject.commands.IngredientCommand;
import tmelo.recipeproject.domain.Ingredient;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand>{

	private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;
	
	public IngredientToIngredientCommand(final UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
		this.uomConverter = uomConverter;
	}


	@Nullable
	@Override
	public final IngredientCommand convert(final Ingredient source) {
		if (source == null) {
			return null;
		}
		
		final IngredientCommand ingredientCommand = new IngredientCommand();
		ingredientCommand.setId(source.getId());
		
		ingredientCommand.setDescription(source.getDescription());
		ingredientCommand.setAmount(source.getAmount());
		ingredientCommand.setUomCommand(uomConverter.convert(source.getUom()));
		
		return ingredientCommand;
	}

	
	
	
}
