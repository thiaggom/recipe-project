package tmelo.recipeproject.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import tmelo.recipeproject.commands.RecipeCommand;
import tmelo.recipeproject.services.ImageService;
import tmelo.recipeproject.services.RecipeService;

@Slf4j
@Controller
public class ImageController {

	private final RecipeService recipeService;
	private final ImageService imageService;
	
    public ImageController(final RecipeService recipeService, final ImageService imageService) {
		this.recipeService = recipeService;
		this.imageService = imageService;
	}

	@GetMapping("recipe/{id}/image")
    public String showUploadForm(@PathVariable final String id, final Model model){
        model.addAttribute("recipe", recipeService.findCommandById(id));

        return "recipe/imageuploadform";
    }	
	
    @PostMapping("recipe/{recipeId}/image")
    public String uploadRecipeImage(@PathVariable final String recipeId, @RequestParam("imagefile") final MultipartFile file ) {
    	log.debug("## Upload image recipe id: "+recipeId+" size: "+file.getSize());
    	
    	imageService.saveImageFile(recipeId, file);
    	
    	return "redirect:/recipe/"+recipeId+"/show";
    }
    
    @GetMapping("recipe/{id}/recipeimage")
    public void renderImageFromDB(@PathVariable final String id, final HttpServletResponse response) throws IOException {
        RecipeCommand recipeCommand = recipeService.findCommandById(id);

        if (recipeCommand.getImage() != null) {
            byte[] byteArray = new byte[recipeCommand.getImage().length];
            int i = 0;

            for (Byte wrappedByte : recipeCommand.getImage()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
    
}
