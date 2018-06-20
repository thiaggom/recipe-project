package tmelo.recipeproject.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

	private Category category;
	
	@Before
	public void Init() {
		category = new Category();
		category.setCategoryName("Category Test");
	}
	
	@Test
	public void getId() throws Exception{
		String testId = "2";
		category.setId("2");
		assertEquals(testId, category.getId());
	}
	
	@Test
	public void getCategoryName() throws Exception{
		String testName = "Category Test";
		category.setCategoryName("Category Test");
		assertEquals(testName, category.getCategoryName());
	}
	
	
}
