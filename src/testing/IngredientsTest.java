package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import items.Ingredient;
import items.IngredientTable;
import items.Ingredients;

class IngredientsTest {

	// fromCode testing
	@Test
	void fromCodeTestNullResult() {
		IngredientTable table = IngredientTable.createInstance();
		Ingredients appleT = table.fromCode("Apple");

		assertEquals(0.44, appleT.getCaloriesPerGram());
		assertEquals(0.56, appleT.getGramsPerMillileter());
		assertEquals("Apple", appleT.getIngredientName());
		assertEquals(("g/ml"), appleT.getVolumeUnits());
		


	}

//	@Test
//	void fromCodeTestNormalResult() {
//		assertEquals(Ingredients.TOMATO, Ingredients.fromCode("Tomato"));
//		assertEquals(Ingredients.BREAD, Ingredients.fromCode("Bread"));
//		assertEquals(Ingredients.COTTAGE_CHEESE, Ingredients.fromCode("Cottage cheese"));
//	}
//
//	// getters testing
//	@Test
//	void getCaloriesPerGramTest() {
//		assertEquals(0.44, Ingredients.APPLE.getCaloriesPerGram());
//		assertEquals(0.14, Ingredients.CELERY.getCaloriesPerGram());
//	}
//
//	@Test
//	void getGramsPerMillileterTest() {
//		assertEquals(0.53, Ingredients.PEANUT.getGramsPerMillileter());
//		assertEquals(0.6, Ingredients.EGG.getGramsPerMillileter());
//	}
//
//	@Test
//	void getIngredientNameTest() {
//		assertEquals("Pepper", Ingredients.PEPPER.getIngredientName());
//		assertEquals("Grape juice", Ingredients.GRAPE_JUICE.getIngredientName());
//	}
}
