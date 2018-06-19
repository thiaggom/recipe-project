package tmelo.recipeproject.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import tmelo.recipeproject.domain.Category;
import tmelo.recipeproject.domain.UnitOfMeasure;
import tmelo.recipeproject.repositories.CategoryRepository;
import tmelo.recipeproject.repositories.UnitOfMeasureRepository;

@Slf4j
@Component
@Profile({"dev","prod"})
public class MySQLDataPush implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepo;
	private final UnitOfMeasureRepository unitOfMeasureRepo;
	
	public MySQLDataPush(CategoryRepository categoryRepo, UnitOfMeasureRepository unitOfMeasureRepo) {
		this.categoryRepo = categoryRepo;
		this.unitOfMeasureRepo = unitOfMeasureRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		// verifing if there is not category in the database
		if (categoryRepo.count() == 0L) {
			log.debug("## Pushing default categories to database...");
			loadCategories();
		}
		
		//verifing if there is no unit of measure in the database...
		if (unitOfMeasureRepo.count() == 0L) {
			log.debug("## Pushing default unit of measures to database...");
			loadUom();
		}
	}
	
    private void loadCategories(){
        Category cat1 = new Category();
        cat1.setCategoryName("American");
        categoryRepo.save(cat1);

        Category cat2 = new Category();
        cat2.setCategoryName("Italian");
        categoryRepo.save(cat2);

        Category cat3 = new Category();
        cat3.setCategoryName("Mexican");
        categoryRepo.save(cat3);

        Category cat4 = new Category();
        cat4.setCategoryName("Fast Food");
        categoryRepo.save(cat4);
    }

    private void loadUom(){
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setDescription("Teaspoon");
        unitOfMeasureRepo.save(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setDescription("Tablespoon");
        unitOfMeasureRepo.save(uom2);

        UnitOfMeasure uom3 = new UnitOfMeasure();
        uom3.setDescription("Cup");
        unitOfMeasureRepo.save(uom3);

        UnitOfMeasure uom4 = new UnitOfMeasure();
        uom4.setDescription("Pinch");
        unitOfMeasureRepo.save(uom4);

        UnitOfMeasure uom5 = new UnitOfMeasure();
        uom5.setDescription("Ounce");
        unitOfMeasureRepo.save(uom5);

        UnitOfMeasure uom6 = new UnitOfMeasure();
        uom6.setDescription("Each");
        unitOfMeasureRepo.save(uom6);

        UnitOfMeasure uom7 = new UnitOfMeasure();
        uom7.setDescription("Pint");
        unitOfMeasureRepo.save(uom7);

        UnitOfMeasure uom8 = new UnitOfMeasure();
        uom8.setDescription("Dash");
        unitOfMeasureRepo.save(uom8);
    }	
	
}
