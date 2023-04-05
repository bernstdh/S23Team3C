import java.io.Serializable;

/**
 * An enum that contains an ingredients name as well as calories/gram
 * and grams/millileter values.
 * @author Mike Buckingham
 *
 */
public enum Ingredients implements Serializable
{
  ALCOHOL("Alcohol", 2.75, 0.79),
  ALMOND("Almond", 6.01, 0.46),
  AMERICAN_CHEESE("American cheese", 4.40, 0.34),
  APPLE("Apple", 0.44, 0.56),
  APPLE_JUICE("Apple juice", 0.48, 1.04),
  BANANA("Banana", 0.65, 0.56),
  BEAN("Bean", 1.30, 0.77),
  BEEF("Beef", 2.80, 1.05),
  BLACKBERRY("Blackberry", 0.25, 0.53),
  BLACK_PEPPER("Black pepper", 2.55, 1.01),
  BREAD("Bread", 2.40, 0.42),
  BROCCOLI("Broccoli", 0.32, 0.37),
  BROWN_SUGAR("Brown sugar", 3.80, 1.5),
  BUTTER("Butter", 7.50, 0.91),
  CABBAGE("Cabbage", 0.28, 0.36),
  CARROT("Carrot", 0.41, 0.64),
  CASHEW("Cashew", 5.53, 0.5),
  CAULIFLOWER("Cauliflower", 0.25, 0.27),
  CELERY("Celery", 0.14, 0.61),
  CHEDDAR_CHEESE("Cheddar cheese", 4.40, 0.34),
  CHERRY("Cherry", 0.50, 1.02),
  CHICKEN("Chicken", 2.00, 1.04),
  CHOCOLATE("Chocolate", 5.00, 1.33),
  CINNAMON("Cinnamon", 2.61, 0.45),
  COD("Cod", 1.00, 0.58),
  CORN("Corn", 1.30, 0.72),
  CORNFLAKE("Cornflake", 3.70, 0.12),
  COTTAGE_CHEESE("Cottage cheese", 0.98, 0.96),
  CRAB("Crab", 1.10, 0.61),
  CREME_DE_CACAO("Creme de cacao", 2.75, 0.79),
  CUCUMBER("Cucumber", 0.10, 0.67),
  EGG("Egg", 1.50, 0.6),
  FLOUR("Flour", 3.64, 0.45),
  GARLIC("Garlic", 1.11, 0.32),
  GRAPEFRUIT("Grapefruit", 0.32, 0.33),
  GRAPE("Grape", 0.62, 0.37),
  GRAPE_JUICE("Grape juice", 0.60, 1.04),
  GREEN_BEAN("Green bean", 0.31, 0.53),
  HADDOCK("Haddock", 1.10, 0.58),
  HAM("Ham", 2.40, 1.4),
  HONEY("Honey", 2.80, 1.5),
  ICE_CREAM("Ice cream", 1.80, 0.55),
  KIDNEY_BEAN("Kidney bean", 3.33, 0.79),
  LAMB("Lamb", 2.00, 1.3),
  LEMON("Lemon", 0.29, 0.77),
  LENTIL("Lentil", 1.16, 0.85),
  LETTUCE("Lettuce", 0.15, 0.06),
  MACARONI("Macaroni", 3.71, 1.31),
  MILK("Milk", 0.70, 1.04),
  MUSHROOM("Mushroom", 0.15, 1.17),
  OIL("Oil", 9.00, 0.88),
  OLIVE("Olive", 0.80, 0.65),
  ONION("Onion", 0.22, 0.74),
  ORANGE("Orange", 0.30, 0.77),
  PAPRIKA("Paprika", 2.82, 0.46),
  PASTA("Pasta", 3.71, 1.31),
  PEACH("Peach", 0.30, 0.61),
  PEANUT("Peanut", 5.67, 0.53),
  PEAR("Pear", 0.16, 0.61),
  PEAS("Peas", 1.48, 0.73),
  PEPPER("Pepper", 0.20, 0.51),
  PINEAPPLE("Pineapple", 0.40, 0.54),
  PLUM("Plum", 0.39, 0.58),
  PORK("Pork", 2.90, 0.7),
  RUM("Rum", 2.75, 0.79),
  SALMON("Salmon", 1.80, 0.58),
  SALT("Salt", 0.00, 1.38),
  SALTINE_CRACKERS("Saltine crackers", 4.21, 0.43),
  SPAGHETTI("Spaghetti", 3.71, 1.31),
  SPINACH("Spinach", 0.08, 0.08),
  STRAWBERRIES("Strawberries", 0.30, 0.58),
  SUGAR("Sugar", 4.00, 0.95),
  SWEET_POTATO("Sweet potato", 0.86, 0.65),
  SYRUP("Syrup", 2.60, 1.38),
  THYME("Thyme", 1.01, 0.46),
  TOMATO("Tomato", 0.20, 0.67),
  WINE("Wine", 0.83, 0.99);
  
  private static final long serialVersionUID = 1L;
  private String ingredientName;
  private double caloriesPerGram;
  private double gramsPerMillileter;
  
  private Ingredients(final String ingredientName, 
      final double caloriesPerGram, final double gramsPerMillileter) 
  {
    this.ingredientName = ingredientName;
    this.caloriesPerGram = caloriesPerGram;
    this.gramsPerMillileter = gramsPerMillileter;
  }
  
  /**
   * Returns the Ingredient instance matching the input string.
   * @param target
   * @return an Ingredient instance matching the target String, or null
   * if that instance is not found.
   */
  public static Ingredients fromCode(final String target)
  {
    Ingredients[] allIngredients = Ingredients.values();
    for(Ingredients i : allIngredients)
    {
      if(i.ingredientName.equals(target)) return i;
    }
    return null;
  }
  
  /**
   * Returns the caloriesPerGram attribute.
   * @return caloriesPerGram.
   */
  public double getCaloriesPerGram() 
  {
    return caloriesPerGram;
  }
  
  /**
   * Returns the gramsPerMillileter attribute.
   * @return gramsPerMillileter
   */
  public double getGramsPerMillileter() 
  {
    return gramsPerMillileter;
  }
  
  /**
   * Returns the ingredient name.
   * @return ingredientName.
   */
  public String getIngredientName()
  {
    return ingredientName;
  }
  
  /**
   * Returns unit string for the gramsPerMillieter attribute.
   * @return g/ml string literal
   */
  public String getVolumeUnits()
  {
    return "g/ml";
  }
}
