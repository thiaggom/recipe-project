package tmelo.recipeproject.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recipe {

	private String id;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	
	private Date creationTime;
	
	private Date lasUpdate;
	
	private String directions;
	
	private Difficulty difficulty;
	
	private Notes notes;

	private Set<Category> categories = new HashSet<>();
	
	private Set<Ingredient> ingredients = new HashSet<>();
	
	private Byte[] image;

	public void addNotes(Notes notes) {
		this.notes = notes;
		notes.setRecipe(this);
	}

	public void addIngredient(Ingredient ingredient) {
		ingredient.setRecipe(this);
		this.ingredients.add(ingredient);
	}
	
}
