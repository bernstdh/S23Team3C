package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import items.Ingredient;
import items.IngredientTable;
import items.Ingredients;
import items.Steps;
import items.Utensils;

class StepsTest
{

  @Test
  void fromCodeTestNullResult()
  {
    Utensils newTensil = new Utensils("Spoon", "wooden stirring spoon");
    Utensils newTensil2 = new Utensils("metal Spoon", "metal stirring spoon");

    IngredientTable table = IngredientTable.createInstance();
    Ingredients appleT = table.fromCode("Apple");
    Ingredient newIngredient = new Ingredient(appleT, "APPLE", 5.0, "pds");
    Steps ingredientStep = new Steps("stirring", "spoon", newIngredient, newTensil);
    Steps utensilStep = new Steps("whip", "metal spoon", newTensil, newTensil);
    Steps utensilStep2 = new Steps("spoon", "wood spoon", newTensil, newTensil2);

    assertEquals("stirring", ingredientStep.getDetails());
    assertEquals("whip", utensilStep.getDetails());

    assertEquals("metal spoon", utensilStep.getAction());
    assertEquals("spoon", ingredientStep.getAction());

    assertEquals("wooden stirring spoon Spoon", utensilStep.getUtensilsSource().toString());
    assertEquals("5.0 pds of APPLE Apple", ingredientStep.getIngredientSource().toString());

    assertEquals("wooden stirring spoon Spoon", utensilStep.getDestination().toString());
    assertEquals("wooden stirring spoon Spoon", ingredientStep.getDestination().toString());

    assertEquals("metal spoon the contents of the wooden stirring spoon Spoon whip",
        utensilStep.utensilStepToString());
    assertEquals("metal spoon the contents of the wooden stirring spoon Spoon whip",
        utensilStep.utensilStepToString());
    assertEquals(
        "wood spoon the contents of the wooden stirring spoon Spoon in the metal stirring spoon metal Spoon",
        utensilStep2.utensilStepToString());

    assertEquals("spoon the 5.0 pds of APPLE Apple in the wooden stirring spoon Spoon stirring",
        ingredientStep.ingredientStepToString());
  }

}
