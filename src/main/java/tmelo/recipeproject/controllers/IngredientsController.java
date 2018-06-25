package tmelo.recipeproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import tmelo.recipeproject.commands.IngredientCommand;
import tmelo.recipeproject.commands.RecipeCommand;
import tmelo.recipeproject.commands.UnitOfMeasureCommand;
import tmelo.recipeproject.exceptions.InvalidParametersException;
import tmelo.recipeproject.services.IngredientService;
import tmelo.recipeproject.services.RecipeService;
import tmelo.recipeproject.services.UnitOfMeasureService;

@Slf4j
@Controller
public class IngredientsController {

	private RecipeService recipeService;

	private IngredientService ingredientService;

	private UnitOfMeasureService unitOfMeasureService;

	public IngredientsController(final RecipeService recipeService, final IngredientService ingredientService,
			final UnitOfMeasureService unitOfMeasureService) {
		this.recipeService = recipeService;
		this.ingredientService = ingredientService;
		this.unitOfMeasureService = unitOfMeasureService;
	}

	@GetMapping("/recipe/{id}/ingredients")
	public String getIngredients(@PathVariable final String id, final Model model) {
		log.debug("Getting ingredients of recipe: " + id);

		model.addAttribute("recipe", recipeService.findCommandById(id));

		return "recipe/ingredients/list";
	}

	@GetMapping("recipe/{recipeId}/ingredients/{id}/show")
	public String showRecipeIngredient(@PathVariable final String recipeId, @PathVariable final String id,
			final Model model) {
		model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId, id));
		return "recipe/ingredients/show";
	}

	@GetMapping("recipe/{recipeId}/ingredients/{id}/update")
	public String updateRecipeIngredient(@PathVariable final String recipeId, @PathVariable final String id,
			final Model model) {
		model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(recipeId, id));

		model.addAttribute("uomList", unitOfMeasureService.listAllUoms());
		return "recipe/ingredients/ingredientform";
	}

	@PostMapping("recipe/{recipeId}/ingredient")
	public String saveOrUpdate(@ModelAttribute final IngredientCommand command) {
		IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

		log.debug("saved receipe id:" + savedCommand.getRecipeId());
		log.debug("saved ingredient id:" + savedCommand.getId());

		return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredients/" + savedCommand.getId() + "/show";
	}

	@GetMapping("recipe/{recipeId}/ingredients/new")
	public String newIngredient(@PathVariable final String recipeId, final Model model) {

		// make sure we have a good id value
		RecipeCommand recipeCommand = recipeService.findCommandById(recipeId);
		// raise exception if null
		if (recipeCommand == null) {
			throw new InvalidParametersException("The recipe id informed " + recipeId + ", was not found!");
		}

		// need to return back parent id for hidden form property
		IngredientCommand ingredientCommand = new IngredientCommand();
		ingredientCommand.setRecipeId(recipeId);
		model.addAttribute("ingredient", ingredientCommand);

		// init uom
		ingredientCommand.setUomCommand(new UnitOfMeasureCommand());

		model.addAttribute("uomList", unitOfMeasureService.listAllUoms());

		return "recipe/ingredients/ingredientform";
	}

	@GetMapping("recipe/{recipeId}/ingredients/{id}/delete")
	public String deleteIngredient(@PathVariable final String recipeId, @PathVariable final String id) {

		log.debug("deleting ingredient id:" + id);
		ingredientService.deleteById(recipeId, id);

		return "redirect:/recipe/" + recipeId + "/ingredients";
	}

}
