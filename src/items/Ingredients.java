package items;
import java.io.Serializable;

/**
 * An enum that contains an ingredients name as well as calories/gram
 * and grams/millileter values.
 * @author Mike Buckingham, Beau Mueller
 *
 */
public class Ingredients implements Serializable
{
  private static final long serialVersionUID = 1L;

  private String ingredientName;
  private double caloriesPerGram;
  private double gramsPerMilliliter;
  
  /**
   * Creates a new ingredient object.
   * @param ingredientName      The ingredient name
   * @param caloriesPerGram     The calories per gram of the new ingredient
   * @param gramsPerMilliliter  The grams per milliliter of the new ingredient
   */
  public Ingredients(final String ingredientName,final double caloriesPerGram, 
      final double gramsPerMilliliter)
  {
    this.ingredientName = ingredientName;
    this.caloriesPerGram = caloriesPerGram;
    this.gramsPerMilliliter = gramsPerMilliliter;
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
    return gramsPerMilliliter;
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
