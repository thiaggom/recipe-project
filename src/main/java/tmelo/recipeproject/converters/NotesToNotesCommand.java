package tmelo.recipeproject.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import tmelo.recipeproject.commands.NotesCommand;
import tmelo.recipeproject.domain.Notes;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand>{

	@Nullable
	@Override
	public final NotesCommand convert(final Notes source) {

		if (source == null) {
			return null;
		}
		
		final NotesCommand notesCommand = new NotesCommand();
		notesCommand.setId(source.getId());
		notesCommand.setRecipeNotes(source.getRecipeNotes());
		
		return notesCommand;
	}

	
	
}
