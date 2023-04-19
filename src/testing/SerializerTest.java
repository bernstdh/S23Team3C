package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import items.Ingredient;
import items.IngredientTable;
import items.Recipes;
import items.Steps;
import items.Utensils;
import utilities.Serializer;

class SerializerTest
{

  // Beginning of Recipe tests
  
  // Various recipes tested, saving and reading files should be fine.
  @Test
  void RecipeReg()
  {
    // name, num, ingredients, utensils, steps
    IngredientTable it = IngredientTable.createInstance();
    String name = "RecipeReg";
    int serves = 1;
    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    ArrayList<Utensils> utensils = new ArrayList<Utensils>();
    ArrayList<Steps> steps = new ArrayList<Steps>();
    Ingredient i = new Ingredient(it.get(0), "Boiling", 2.5, "gal");
    Utensils u = new Utensils("Microwave", "");
    Steps s = new Steps("for upwards of 10 minutes", "put", i, u);
    ingredients.add(i);
    utensils.add(u);
    steps.add(s);
    Recipes r = new Recipes(name, serves, ingredients, utensils, steps);
    try
    {
      Serializer.serializeRecipe(r);
    }
    catch (IOException e)
    {
      fail();
    }
    Recipes retrieved = null;
    try
    {
      retrieved = Serializer.deserializeRecipe("RecipeReg.rcp");
    }
    catch (ClassNotFoundException | IOException e)
    {
      fail();
    }
    // names are equals
    assertEquals(retrieved.getName(), name);
    
    // ingredients are equal
    assertEquals(i.getAmount(), retrieved.getIngredients().get(0).getAmount());
    assertEquals(i.getDetails(), retrieved.getIngredients().get(0).getDetails());
    
    assertEquals(i.getIngredient().getCaloriesPerGram(),
        retrieved.getIngredients().get(0).getIngredient().getCaloriesPerGram());
    assertEquals(i.getIngredient().getGramsPerMillileter(),
        retrieved.getIngredients().get(0).getIngredient().getGramsPerMillileter());

    
    assertEquals(i.getOgAmount(), retrieved.getIngredients().get(0).getOgAmount());
    assertEquals(i.getUnit(), retrieved.getIngredients().get(0).getUnit());
    
    // utensils are equal
    assertEquals(u.getDetails(), retrieved.getUtensils().get(0).getDetails());
    assertEquals(u.getName(), retrieved.getUtensils().get(0).getName());

    // steps are equals
    assertEquals(s.getAction(), retrieved.getSteps().get(0).getAction());
    assertEquals(s.getDestination().getName(),
        retrieved.getSteps().get(0).getDestination().getName());
    assertEquals(s.getDetails(), retrieved.getSteps().get(0).getDetails());
    if(s.getIngredientSource() != null)
      assertEquals(s.getIngredientSource().getName(),
          retrieved.getSteps().get(0).getIngredientSource().getName());
    if(s.getUtensilsSource() != null)
      assertEquals(s.getUtensilsSource().getName(),
          retrieved.getSteps().get(0).getUtensilsSource().getName());
  }
}
