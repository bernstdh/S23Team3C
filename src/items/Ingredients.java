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
  private double individualGrams;
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
    this.individualGrams = -1.0;
  }
  
  /**
   * Creates a new ingredient object with individual ingredient calories.
   * @param ingredientName      The ingredient name
   * @param caloriesPerGram     The calories per gram of the new ingredient
   * @param gramsPerMilliliter  The grams per milliliter of the new ingredient
   * @param individualGrams  The number of grams per individual ingredient
   */
  public Ingredients(final String ingredientName, final double caloriesPerGram,
      final double gramsPerMilliliter, final double individualGrams)
  {
    this.ingredientName = ingredientName;
    this.caloriesPerGram = caloriesPerGram;
    this.gramsPerMilliliter = gramsPerMilliliter;
    this.individualGrams = individualGrams;
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
  
  /**
   * Gets the individual grams.
   * @return the individual grams
   */
  public double getIndividualGrams()
  {
    return this.individualGrams;
  }
  
  /**
   * Individual CaloriesPerGram.
   * @return calories per individual
   */
  public double getCaloriesPerIndividual()
  {
    return this.caloriesPerGram * this.individualGrams;
  }
  
  
  
}
