package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import items.Ingredient;
import items.IngredientTable;
import items.Ingredients;
import items.Meals;
import items.Recipes;
import items.Steps;
import items.Utensils;
import utilities.Serializer;

class SerializerTest
{

  // Beginning of Recipe tests

  // Various recipes tested, saving and reading files should be fine.
  /**
   * Creates a simple recipe, assertEqual on all recipe properties before and after serialization.
   */
  @Test
  void recipeReg()
  {
    new Serializer();
    // name, num, ingredients, utensils, steps
    IngredientTable it = IngredientTable.createInstance();
    Recipes r = randomRecipe();
    try
    {
      Serializer.serializeRecipe(r);
    }
    catch (IOException e)
    {
      fail();
    }
    Recipes s = null;
    try
    {
      s = Serializer.deserializeRecipe(r.getName() + ".rcp");
    }
    catch (ClassNotFoundException | IOException e)
    {
      fail();
    }
    // names are equals
    assertEquals(s.getName(), r.getName());

    // steps are the same
    for (int i = 0; i < s.getSteps().size(); i++)
    {
      assertTrue(s.getSteps().get(i).ingredientStepToString()
          .equals(r.getSteps().get(i).ingredientStepToString()));
    }

    // ingredients are the same
    for (int i = 0; i < s.getIngredients().size(); i++)
    {
      assertTrue(s.getIngredients().get(i).toString().equals(r.getIngredients().get(i).toString()));
    }

    // utensils are the same
    for (int i = 0; i < s.getUtensils().size(); i++)
    {
      assertTrue(s.getUtensils().get(i).toString().equals(r.getUtensils().get(i).toString()));
    }

  }

  /**
   * Test the method that creates a new recipe file with a custom directory.
   */
  @Test
  void recipeDir()
  {
    String dir = "" + System.getProperty("user.dir");
    Recipes r = randomRecipe();

    try
    {
      Serializer.serializeRecipe(dir, r);
    }
    catch (IOException e)
    {
      e.printStackTrace();
      fail();
    }

    Recipes s = null;
    try
    {
      s = Serializer.deserializeRecipe(dir + "/" + r.getName() + ".rcp");
    }
    catch (ClassNotFoundException | IOException e)
    {
      e.printStackTrace();
      fail();
    }

    assertTrue(s != null);
    for (int i = 0; i < s.getSteps().size(); i++)
    {
      assertTrue(s.getSteps().get(i).ingredientStepToString()
          .equals(r.getSteps().get(i).ingredientStepToString()));
    }
    for (int i = 0; i < s.getIngredients().size(); i++)
    {
      assertTrue(s.getIngredients().get(i).toString().equals(r.getIngredients().get(i).toString()));
    }

    for (int i = 0; i < s.getUtensils().size(); i++)
    {
      assertTrue(s.getUtensils().get(i).toString().equals(r.getUtensils().get(i).toString()));
    }
  }

  // BEGINNING OF TESTS FOR MEALS

  /**
   * Test the meal serialization with no directory.
   */
  @Test
  void regMeal()
  {
    ArrayList<Recipes> al = new ArrayList<>();
    for (int i = 0; i < 10; i++)
    {
      al.add(randomRecipe());
    }
    Meals m = new Meals(randString(), al);

    try
    {
      Serializer.serializeMeal(m);
    }
    catch (IOException e)
    {
      fail();
    }
    Meals n = null;
    try
    {
      n = Serializer.deserializeMeal(m.getName() + ".mel");
    }
    catch (ClassNotFoundException | IOException e)
    {
      fail();
    }

    for (int i = 0; i < m.getRecipes().size(); i++)
    {
      Recipes s = m.getRecipes().get(i);
      Recipes r = n.getRecipes().get(i);
      for (int j = 0; j < s.getSteps().size(); j++)
      {
        assertTrue(s.getSteps().get(j).ingredientStepToString()
            .equals(r.getSteps().get(j).ingredientStepToString()));
      }
      for (int j = 0; j < s.getIngredients().size(); j++)
      {
        assertTrue(
            s.getIngredients().get(j).toString().equals(r.getIngredients().get(j).toString()));
      }

      for (int j = 0; j < s.getUtensils().size(); j++)
      {
        assertTrue(s.getUtensils().get(j).toString().equals(r.getUtensils().get(j).toString()));
      }
    }
  }
  
  @Test
  void dirMeal()
  {
    String dir = "" + System.getProperty("user.dir");
    ArrayList<Recipes> al = new ArrayList<>();
    for (int i = 0; i < 10; i++)
    {
      al.add(randomRecipe());
    }
    Meals m = new Meals(randString(), al);

    try
    {
      Serializer.serializeMeal(dir, m);
    }
    catch (IOException e)
    {
      fail();
    }
    Meals n = null;
    try
    {
      n = Serializer.deserializeMeal(dir + "/" + m.getName() + ".mel");
    }
    catch (ClassNotFoundException | IOException e)
    {
      fail();
    }

    for (int i = 0; i < m.getRecipes().size(); i++)
    {
      Recipes s = m.getRecipes().get(i);
      Recipes r = n.getRecipes().get(i);
      for (int j = 0; j < s.getSteps().size(); j++)
      {
        assertTrue(s.getSteps().get(j).ingredientStepToString()
            .equals(r.getSteps().get(j).ingredientStepToString()));
      }
      for (int j = 0; j < s.getIngredients().size(); j++)
      {
        assertTrue(
            s.getIngredients().get(j).toString().equals(r.getIngredients().get(j).toString()));
      }

      for (int j = 0; j < s.getUtensils().size(); j++)
      {
        assertTrue(s.getUtensils().get(j).toString().equals(r.getUtensils().get(j).toString()));
      }
    }
  }

  
  /**
   * Test the Ingredient saving mechanism.
   */
  
  @Test
  void saveIngs()
  {
    ArrayList<Ingredients> al = new ArrayList<>();
    for(int i = 0; i < 10; i++)
    {
      al.add(new Ingredients(randString(), Math.random(), Math.random()));
    }
    try
    {
      Serializer.saveIngredients(al);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    ArrayList<Ingredients> al2 = null;
    try
    {
      al2 = Serializer.retrieveIngredients();
    }
    catch (ClassNotFoundException | IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    for(Ingredients i : al)
    {
      boolean found = false;
      for(Ingredients j : al2) 
      {
        if(j.getIngredientName().equals(i.getIngredientName())) 
        {
          found = true;
          break;
        }
      }
      assertTrue(found);
    }
  }
  /**
   * Generate a recipe with random values.
   * 
   * @return The randomly generated recipe.
   */
  private Recipes randomRecipe()
  {
    IngredientTable it = IngredientTable.createInstance();
    String name = randString();
    int serves = (int) (Math.random() * 50000);

    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    ArrayList<Utensils> utensils = new ArrayList<Utensils>();
    ArrayList<Steps> steps = new ArrayList<Steps>();

    for (int i = 0; i < 10; i++)
    {
      ingredients.add(
          new Ingredient(it.get((int) (Math.random() * 50)), randString(), Math.random(), "gal"));
    }
    for (int i = 0; i < 10; i++)
    {
      utensils.add(new Utensils(randString(), randString()));
    }
    for (int i = 0; i < 10; i++)
    {
      steps.add(new Steps(randString(), randString(), ingredients.get((int) (Math.random() * 10)),
          utensils.get((int) (Math.random() * 10))));
    }
    return new Recipes(name, serves, ingredients, utensils, steps);
  }

  /**
   * Create a random String (int from 0-49999 in String form).
   * 
   * @return The random String
   */
  private String randString()
  {
    return Integer.valueOf((int) (Math.random() * 50000)).toString();
  }
}
