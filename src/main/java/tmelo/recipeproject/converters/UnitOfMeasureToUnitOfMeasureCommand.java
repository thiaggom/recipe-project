package tmelo.recipeproject.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import tmelo.recipeproject.commands.UnitOfMeasureCommand;
import tmelo.recipeproject.domain.UnitOfMeasure;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

	@Nullable
	@Override
	public final UnitOfMeasureCommand convert(final UnitOfMeasure source) {

		if (source == null) {
			return null;
		}
		
		final UnitOfMeasureCommand uomCommand = new UnitOfMeasureCommand();
		uomCommand.setId(source.getId());
		uomCommand.setDescription(source.getDescription());
		
		return uomCommand;
	}

	
			
}
