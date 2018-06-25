package tmelo.recipeproject.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import tmelo.recipeproject.commands.UnitOfMeasureCommand;
import tmelo.recipeproject.domain.UnitOfMeasure;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure>{

	@Nullable
	@Override
	public final UnitOfMeasure convert(final UnitOfMeasureCommand source) {

		if (source == null) {
			return null;
		}
		
		final UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(source.getId());
		uom.setDescription(source.getDescription());
		return uom;
	}

	
	
}
