package testing;

import java.io.IOException;
import java.util.ArrayList;

import gui.MealEditor;
import items.Ingredient;
import items.IngredientTable;
import items.Ingredients;
import items.Meals;
import items.Recipes;
import items.Steps;
import items.Utensils;
import utilities.Serializer;

/**
 * Driver to test MealEditor.
 * @author Julian Barrett
 *
 */
public class MealEditorDriver
{

  /**
   * Main driver for MealEditor.
   * @param args are null.
   */
  public static void main(String[] args)
  {

    IngredientTable table = IngredientTable.createInstance();
    Ingredients appleT = table.fromCode("Apple");
    // System.out.println(appleT.getIngredientName());
    Ingredient newIngredient = new Ingredient(appleT, "APPLE", 5.0, "pds");

    ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
    ingredientList.add(newIngredient);
    Utensils newUtensil = new Utensils("spoon", "spoon");
    ArrayList<Utensils> utensilList = new ArrayList<Utensils>();
    utensilList.add(newUtensil);
    Steps testStep = new Steps("julian steps", "stir into", newIngredient, newUtensil);
    ArrayList<Steps> stepList = new ArrayList<Steps>();
    stepList.add(testStep);

    Recipes newRecipe = new Recipes("Julian7", 5, ingredientList, utensilList, stepList);
    Recipes newRecipe2 = new Recipes("Julian8", 5, ingredientList, utensilList, stepList);
    Recipes newRecipe3 = new Recipes("recipe3", 4, ingredientList, utensilList, stepList);

    ArrayList<Recipes> recipeTestList = new ArrayList<Recipes>();
    // recipeTestList.add(newRecipe);
    recipeTestList.add(newRecipe2);
    recipeTestList.add(newRecipe3);

    Meals testMeal = new Meals("testMeal", recipeTestList);

    try
    {
      Serializer.serializeRecipe(
          "C:\\Users\\Julian Barrett\\OneDrive\\Desktop\\345FinalProject\\julianrepository\\S23Team3C",
          newRecipe3);
      Serializer.serializeRecipe(
          "C:\\Users\\Julian Barrett\\OneDrive\\Desktop\\345FinalProject\\julianrepository\\S23Team3C",
          newRecipe2);
      Serializer.serializeMeal(
          "C:\\Users\\Julian Barrett\\OneDrive\\Desktop\\cs345FinalProject\\projectrepositoryx  ",
          testMeal);

    }
    catch (IOException e)
    {
      // TODO Auto-generated catch block
      // e.printStackTrace();
    }
    // all of these are for testing above
    // maybe I should initialize this.meal to a new null meal

    new MealEditor();

  }
}
