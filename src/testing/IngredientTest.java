package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import items.Ingredient;
import items.IngredientTable;
import items.Ingredients;

class IngredientTest
{

  @Test
  void ingredientTest()
  {
    IngredientTable table = IngredientTable.createInstance();
    Ingredients appleT = table.fromCode("Apple");
    Ingredient newIngredient = new Ingredient(appleT, "APPLE", 5.0, "pds");

    assertEquals(5.0, newIngredient.getAmount());
    assertEquals("APPLE", newIngredient.getDetails());
    assertEquals(0.44, newIngredient.getIngredient().getCaloriesPerGram());
    assertEquals("Apple", newIngredient.getName());
    assertEquals(5.0, newIngredient.getOgAmount());
    assertEquals("pds", newIngredient.getUnit());
    assertEquals("5.0 pds of APPLE Apple", newIngredient.toString());

    newIngredient.setAmount(6.0);
    assertEquals(6.0, newIngredient.getAmount());

    newIngredient.setUnit("pints");
    assertEquals("pints", newIngredient.getUnit());

  }

}
