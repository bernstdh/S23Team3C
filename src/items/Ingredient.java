package items;

import java.io.Serializable;

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
   * @param name
   *          for name of ingredient.
   * @param details
   *          for ingredient description.
   * @param amount
   *          for ingredient amount.
   * @param unit
   *          amount in units.
   * @param caloriesPerg
   *          for calories per gram.
   */
  public Ingredient(Ingredients ingredients, String details, double amount, String unit)
  {
    this.ingredient = ingredients;
    this.name = ingredient.getIngredientName();
    this.details = details;
    this.amount = amount;
    this.ogAmount = amount;
    this.unit = unit;
  }

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

  public void setAmount(double amount)
  {
    this.amount = amount;
  }

  public void setUnit(String unit)
  {
    this.unit = unit;
  }

  public String toString()
  {
    String newString;
    newString = String.format("%.1f %s of %s %s", this.amount, this.unit, this.details, this.name);
    return newString;
  }

}
