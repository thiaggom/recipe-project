package tmelo.recipeproject.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Recipe {

	@Id
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

	@DBRef
	private Set<Category> categories = new HashSet<>();
	
	private Set<Ingredient> ingredients = new HashSet<>();
	
	private Byte[] image;

	public final void setNotes(final Notes notes) {
		if (notes != null) {
			this.notes = notes;
		}
	}

	public final void addIngredient(final Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
	
}
