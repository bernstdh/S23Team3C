package items;

import java.io.Serializable;
import java.util.List;

/**
 * Meals class creates a list of recipes.
 * 
 * @author Julian Barrett
 *
 */
public class Meals implements Serializable
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private List<Recipes> recipes;
  private String name;

  /**
   * Meals constructor.
   * @param name String name.
   * @param recipes for recipe list.
   */
  public Meals(final String name, final List<Recipes> recipes)
  {
    this.name = name;
    this.recipes = recipes;
  }

  /**
   * @param name
   */
  public void setName(final String name)
  {
    this.name = name;
  }

  /**
   * returns name.
   * 
   * @return name.
   */
  public String getName()
  {
    return this.name;
  }

  /**
   * returns recipes.
   * 
   * @return recipes;
   */
  public List<Recipes> getRecipes()
  {
    return this.recipes;
  }

  /**
   * Add a recipe to the list.
   * 
   * @param recipe
   *          to be added.
   */
  public void addRecipe(final Recipes recipe)
  {
    this.recipes.add(recipe);
  }

  /**
   * Returns toString.
   * @return formatted string.
   */
  public String toString()
  {
    String mealString = null;
    mealString += this.name;

    for (int i = 0; i < this.recipes.size(); i++)
    {
      mealString += this.recipes.get(i);
      mealString += "\n";
    }
    return mealString;
  }

  /**
   * calculate calories.
   * @return calories.
   */
  public double calorieCalculator()
  {
    double calories = 0;
    for (int i = 0; i < recipes.size(); i++)
    {
      calories += recipes.get(i).calorieCalculator();
    }
    return calories;
  }
}
