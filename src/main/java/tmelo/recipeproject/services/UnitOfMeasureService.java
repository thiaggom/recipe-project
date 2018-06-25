package tmelo.recipeproject.services;

import java.util.Set;

import tmelo.recipeproject.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

	Set<UnitOfMeasureCommand> listAllUoms();
	
}
