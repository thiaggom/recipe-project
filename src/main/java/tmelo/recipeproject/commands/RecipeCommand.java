package tmelo.recipeproject.commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tmelo.recipeproject.domain.Difficulty;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RecipeCommand {

	private String id;
	
	@NotBlank
	@Size(min=3, max=255)
	private String description;
	
	@Min(1)
	@Max(999)
	private Integer prepTime;

	@Min(1)
	@Max(999)
	private Integer cookTime;
	
	@Min(1)
	@Max(100)
	private Integer servings;
	private String source;
	
	@URL
	private String url;
	
	@NotBlank
	private String directions;
	private Byte[] image;
	private Difficulty difficulty;
	private NotesCommand notesCommand;
	private List<CategoryCommand> categoriesCommand = new ArrayList<>();
	private List<IngredientCommand> ingredientsCommand = new ArrayList<>();

}
