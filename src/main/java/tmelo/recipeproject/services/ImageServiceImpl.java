package tmelo.recipeproject.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import tmelo.recipeproject.domain.Recipe;
import tmelo.recipeproject.exceptions.NotFoundException;
import tmelo.recipeproject.repositories.RecipeRepository;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

	private final RecipeRepository recipeRepo;
	
	public ImageServiceImpl(final RecipeRepository recipeRepo) {
		this.recipeRepo = recipeRepo;
	}

	@Override
	public final void saveImageFile(final String recipeId, final MultipartFile imagefile) {

		Optional<Recipe> optRecipe = recipeRepo.findById(recipeId);
		
		if (!optRecipe.isPresent()) {
			throw new NotFoundException("Recipe "+recipeId+" was not found!");
		}
		
		Recipe recipe = optRecipe.get();
		
		try {
			Byte[] imageBytes = new Byte[imagefile.getBytes().length];
			int index = 0;
			for (byte b : imagefile.getBytes()) {
				imageBytes[index++] = b;
			}
			recipe.setImage(imageBytes);
			recipeRepo.save(recipe);
			log.debug("recipe id "+recipeId+" had a new image saved!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("## Error saving recipe image", e);
			e.printStackTrace();
		}
		

	}

}
