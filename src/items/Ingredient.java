package items;

import java.io.Serializable;
/**
 * Ingredient.
 * @author shaury
 *
 */
public class Ingredient implements Serializable
{

  private static final long serialVersionUID = 1L;
  private String name;
  private String details;
  private double amount;
  private double ogAmount;
  private String unit;
  private Ingredients ingredient;

  /**
   * Constructor.
   * @param ingredients ingredients
   * @param details
   *          for ingredient description.
   * @param amount
   *          for ingredient amount.
   * @param unit
   *          amount in units.
   * 
   */
  public Ingredient(final Ingredients ingredients, final String details, 
		  final double amount, final String unit)
  {
    this.ingredient = ingredients;
    this.name = ingredient.getIngredientName();
    this.details = details;
    this.amount = amount;
    this.ogAmount = amount;
    this.unit = unit;
  }
  /**
   * Getter.
   * @return ingedient
   */
  public Ingredients getIngredient()
  {
    return this.ingredient;
  }

  /**
   * returns name.
   * 
   * @return this.name;
   */
  public String getName()
  {
    return this.name;
  }

  /**
   * returns details.
   * 
   * @return details.
   */
  public String getDetails()
  {
    return this.details;
  }

  /**
   * returns amount.
   * 
   * @return amount.
   */
  public double getAmount()
  {
    return this.amount;
  }
  
  /**
   * getter.
   * @return original amount
   */
  public double getOgAmount()
  {
    return this.ogAmount;
  }

  /**
   * method returns unit.
   * 
   * @return unit.
   */
  public String getUnit()
  {
    return this.unit;
  }
  
  /**
   * setter.
   * @param amount amount
   */
  public void setAmount(final double amount)
  {
    this.amount = amount;
  }
  
  /**
   * setter.
   * @param unit set
   */
  public void setUnit(final String unit)
  {
    this.unit = unit;
  }
  /**
   * toString.
   * @return string
   */
  public String toString()
  {
    String newString;
    if(details.equals("")) 
      newString = String.format("%.1f %s of %s", this.amount, this.unit, this.name);
    else 
      newString = String.format("%.1f %s of %s %s", 
          this.amount, this.unit, this.details, this.name);
    return newString;
  }

}
