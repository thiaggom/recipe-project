package tmelo.recipeproject.domain;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

	private String id;
	private String categoryName;
	
	private Set<Recipe> recipes;

}
