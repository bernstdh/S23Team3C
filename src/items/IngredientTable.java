package items;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import utilities.Serializer;

/**
 * A working list of all ingredients that were both given in the Domain Glossary and by the user.
 * Only one instance of IngredientTable can exist at a time. To get the existing instance call the
 * createInstance method.
 * @author Mike Buckingham, Beau Mueller
 *
 */
public class IngredientTable extends ArrayList<Ingredients> implements Serializable
{
  private static final long serialVersionUID = 1L;

  private static boolean exists = false;
  private static IngredientTable instance = null;
  
  /**
   * Creates a new ArrayList of Ingredients and adds all pre-existing Ingredients objects.
   */
  private IngredientTable()
  {
    super();
    add(new Ingredients("Alcohol", 2.75, 0.79));
    add(new Ingredients("Almond", 6.01, 0.46, 1.2));
    add(new Ingredients("American cheese", 4.40, 0.34, 28));
    add(new Ingredients("Apple", 0.44, 0.56, 200));
    add(new Ingredients("Apple juice", 0.48, 1.04));
    add(new Ingredients("Banana", 0.65, 0.56, 118));
    add(new Ingredients("Bean", 1.30, 0.77));
    add(new Ingredients("Beef", 2.80, 1.05));
    add(new Ingredients("Blackberry", 0.25, 0.53));
    add(new Ingredients("Black pepper", 2.55, 1.01));
    add(new Ingredients("Bread", 2.40, 0.42, 38));
    add(new Ingredients("Broccoli", 0.32, 0.37));
    add(new Ingredients("Brown sugar", 3.80, 1.5));
    add(new Ingredients("Butter", 7.50, 0.91, 113));
    add(new Ingredients("Cabbage", 0.28, 0.36, 908));
    add(new Ingredients("Carrot", 0.41, 0.64, 61));
    add(new Ingredients("Cashew", 5.53, 0.5, 1.5));
    add(new Ingredients("Cauliflower", 0.25, 0.27, 850));
    add(new Ingredients("Celery", 0.14, 0.61, 53.2));
    add(new Ingredients("Cheddar cheese", 4.40, 0.34, 28));
    add(new Ingredients("Cherry", 0.50, 1.02));
    add(new Ingredients("Chicken", 2.00, 1.04));
    add(new Ingredients("Chocolate", 5.00, 1.33, 71));
    add(new Ingredients("Cinnamon", 2.61, 0.45));
    add(new Ingredients("Cod", 1.00, 0.58));
    add(new Ingredients("Corn", 1.30, 0.72, 103));
    add(new Ingredients("Cornflake", 3.70, 0.12));
    add(new Ingredients("Cottage cheese", 0.98, 0.96));
    add(new Ingredients("Crab", 1.10, 0.61, 9.6));
    add(new Ingredients("Creme de cacao", 2.75, 0.79));
    add(new Ingredients("Cucumber", 0.10, 0.67, 400));
    add(new Ingredients("Egg", 1.50, 0.6, 60));
    add(new Ingredients("Flour", 3.64, 0.45));
    add(new Ingredients("Garlic", 1.11, 0.32, 13));
    add(new Ingredients("Grapefruit", 0.32, 0.33, 450));
    add(new Ingredients("Grape", 0.62, 0.37, 5));
    add(new Ingredients("Grape juice", 0.60, 1.04));
    add(new Ingredients("Green bean", 0.31, 0.53, 14.55));
    add(new Ingredients("Haddock", 1.10, 0.58));
    add(new Ingredients("Ham", 2.40, 1.4, 28));
    add(new Ingredients("Honey", 2.80, 1.5));
    add(new Ingredients("Ice cream", 1.80, 0.55, 72));
    add(new Ingredients("Kidney bean", 3.33, 0.79));
    add(new Ingredients("Lamb", 2.00, 1.3));
    add(new Ingredients("Lemon", 0.29, 0.77, 65));
    add(new Ingredients("Lentil", 1.16, 0.85));
    add(new Ingredients("Lettuce", 0.15, 0.06, 300));
    add(new Ingredients("Macaroni", 3.71, 1.31));
    add(new Ingredients("Milk", 0.70, 1.04));
    add(new Ingredients("Mushroom", 0.15, 1.17, 18));
    add(new Ingredients("Oil", 9.00, 0.88));
    add(new Ingredients("Olive", 0.80, 0.65, 5.7));
    add(new Ingredients("Onion", 0.22, 0.74, 170));
    add(new Ingredients("Orange", 0.30, 0.77, 140));
    add(new Ingredients("Paprika", 2.82, 0.46));
    add(new Ingredients("Pasta", 3.71, 1.31));
    add(new Ingredients("Peach", 0.30, 0.61, 147));
    add(new Ingredients("Peanut", 5.67, 0.53));
    add(new Ingredients("Pear", 0.16, 0.61, 166));
    add(new Ingredients("Peas", 1.48, 0.73));
    add(new Ingredients("Pepper", 0.20, 0.51));
    add(new Ingredients("Pineapple", 0.40, 0.54, 1002));
    add(new Ingredients("Plum", 0.39, 0.58, 75));
    add(new Ingredients("Pork", 2.90, 0.7, 28));
    add(new Ingredients("Rum", 2.75, 0.79));
    add(new Ingredients("Salmon", 1.80, 0.58));
    add(new Ingredients("Salt", 0.00, 1.38));
    add(new Ingredients("Saltine crackers", 4.21, 0.43));
    add(new Ingredients("Spaghetti", 3.71, 1.31));
    add(new Ingredients("Spinach", 0.08, 0.08));
    add(new Ingredients("Strawberries", 0.30, 0.58, 15.5));
    add(new Ingredients("Sugar", 4.00, 0.95));
    add(new Ingredients("Sweet potato", 0.86, 0.65, 113));
    add(new Ingredients("Syrup", 2.60, 1.38));
    add(new Ingredients("Thyme", 1.01, 0.46));
    add(new Ingredients("Tomato", 0.20, 0.67, 123));
    add(new Ingredients("Wine", 0.83, 0.99));
    
    // Read in the custom user ingredients from UserIngredients.dat
    ArrayList<Ingredients> al = new ArrayList<Ingredients>();
    try
    {
      al = Serializer.retrieveIngredients();
    } catch(IOException | ClassNotFoundException ioe)
    {
      // Coming here just means that the user hasn't ran the program before so no custom
      // ingredients exist yet.
    }
    addAll(al);
  }
  
  /**
   * If an existing IngredientTable already exists, the current instance is returned, otherwise a
   * new instance is created.
   * @return  Either a new IngredientTable or the existing instance.
   */
  public static IngredientTable createInstance()
  {
    if(exists)
    {
      return instance;
    } else
    {
      instance = new IngredientTable();
      exists = true;
      return instance;
    }
  }
  
  /**
   * Returns the Ingredient instance matching the input string.
   * @param target
   * @return an Ingredient instance matching the target String, or null
   * if that instance is not found.
   */
  public Ingredients fromCode(final String target)
  {
    for(Ingredients i : this)
    {
      if(i.getIngredientName().equalsIgnoreCase(target)) return i;
    }
    return null;
  }
}
