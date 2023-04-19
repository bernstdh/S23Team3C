package items;

import java.io.Serializable;

/**
 * Steps class.
 * 
 * @author Julian Barrett
 *
 */
public class Steps implements Serializable
{

  private static final long serialVersionUID = 1L;

  private String action;
  private String details;
  private Ingredient ingredientSource = null;
  private Utensils utensilSource = null;
  private Utensils destination;

  /**
   * Utensils source.
   * 
   * @param action
   *          for description.
   * @param source
   *          for source utensil.
   * @param destination
   *          for destination utensil.
   */
  public Steps(final String details, final String action,
      final Utensils source, final Utensils destination)
  {
    this.details = details;
    this.action = action;
    this.utensilSource = source;
    this.destination = destination;
  }

  /**
   * Ingredient source.
   * 
   * @param action
   *          for description.
   * @param source
   *          for source Ingredient.
   * @param destination
   *          for destination Utensil.
   */
  /**
   * @param details for details string.
   * @param action for action string.
   * @param source for ingredient source.
   * @param destination for destination.
   */
  public Steps(final String details, final String action,
      final Ingredient source, final Utensils destination)
  {
    this.details = details;
    this.action = action;
    this.ingredientSource = source;
    this.destination = destination;
  }

  /**
   * getter.
   * 
   * @return this.details.
   */
  public String getDetails()
  {
    return this.details;
  }

  /**
   * Returns this.action.
   * 
   * @return this.action.
   */
  public String getAction()
  {
    return this.action;
  }

  /**
   * Getter.
   * 
   * @return this.utensilSource.
   */
  public Utensils getUtensilsSource()
  {
    return this.utensilSource;
  }

  /**
   * Getter.
   * 
   * @return ingredientSource.
   */
  public Ingredient getIngredientSource()
  {
    return this.ingredientSource;
  }

  /**
   * Return destination.
   * 
   * @return destination.
   */
  public Utensils getDestination()
  {
    return this.destination;
  }

  /**
   * toString for a step with an ingredient.
   * 
   * @return formatted string.
   */
  public String IngredientStepToString()
  {
    return String.format("%s the %s in the %s %s", this.action, this.ingredientSource.toString(),
        this.destination.toString(), this.details);
  }

  /**
   * toString for a step with two utensils.
   * 
   * @return formatted string.
   */
  public String UtensilStepToString()
  {
    if (this.utensilSource.getName().equals(destination.getName()))
    {
      return String.format("%s the contents of the %s %s", this.action,
          this.utensilSource.toString(), this.details);
    }
    return String.format("%s the contents of the %s in the %s", this.action,
        this.utensilSource.toString(), this.destination.toString());
  }

}
