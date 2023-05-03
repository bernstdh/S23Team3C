package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import items.Ingredient;
import items.Ingredients;
import items.Recipes;
import items.Steps;
import items.Utensils;

class RecipeTest
{

  @Test
  void numPplTest()
  {
    List<Utensils> ut = new ArrayList<Utensils>();
    List<Ingredient> ingredients = new ArrayList<Ingredient>();
    List<Steps> steps = new ArrayList<Steps>();
    Recipes recipe = new Recipes("Trace", 2, ingredients, ut, steps);
    assertEquals(2, recipe.numPpl());
    Ingredients in = new Ingredients("Apple", 2, 4);
    Ingredient ing = new Ingredient(in, "Apple", 2, "g");
    ingredients.add(ing);
    Recipes recipe1 = new Recipes("Apple", 2, ingredients, ut, steps);
    assertEquals(0.88, recipe1.calorieCalculator());
    
  }

}
