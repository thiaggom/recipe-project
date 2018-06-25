package tmelo.recipeproject.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	void saveImageFile(final String recipeId, final MultipartFile imagefile);
}
