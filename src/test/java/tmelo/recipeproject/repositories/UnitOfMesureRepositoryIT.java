package tmelo.recipeproject.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tmelo.recipeproject.domain.UnitOfMeasure;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitOfMesureRepositoryIT {

	@Autowired
	UnitOfMeasureRepository uomRepo;
	
	@Autowired
	RecipeRepository recipeRepo;
 
	@Autowired
	CategoryRepository catRepo;
	 
	
	@Test
	public final void findByDescription() throws Exception {
		Optional<UnitOfMeasure> optUom = uomRepo.findByDescription("Ounce");
		assertEquals(true, optUom.isPresent());
		assertThat(optUom.get()).hasFieldOrPropertyWithValue("description", "Ounce");
	}
	
}
