package steps;
import java.io.Serializable;

import ingredients.Ingredient;
import utensil.Utensils;

/**
 * Steps class.
 * @author Julian Barrett
 *
 */
public class Steps implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private String action;
	private String details;
	private Ingredient ingredientSource = null;
	private Utensils utensilSource = null;
	private Utensils destination;
	
	
	/**
	 * Utensils source.
	 * @param action for description.
	 * @param source for source utensil.
	 * @param destination for destination utensil.
	 */
	public Steps(String details, String action, Utensils source, Utensils destination) {
		this.details = details;
		this.action = action;
		this.utensilSource = source;
		this.destination = destination;
	}
	
	
	/**
	 * getter.
	 * @return this.details.
	 */
	public String getDetails() {
		return this.details;
	}
	
	
	/**
	 * Ingredient source.
	 * @param action for description.
	 * @param source for source Ingredient.
	 * @param destination for destination Utensil.
	 */
	public Steps(String action, Ingredient source, Utensils destination) {
		this.action = action;
		this.ingredientSource = source;
		this.destination = destination;
	}
	
	/**
	 * Returns this.action.
	 * @return this.action.
	 */
	public String getAction() {
		return this.action;
	}
	
	/**
	 * Getter.
	 * @return this.utensilSource.
	 */
	public Utensils getUtensilsSource() {
		return this.utensilSource;
	}
	
	
	/**
	 * Getter.
	 * @return ingredientSource.
	 */
	public Ingredient getIngredientSource() {
		return this.ingredientSource;
	}
	
	public Utensils getDestination() {
		return this.destination;
	}
	
	
//	public String toString() {
//		String stepsString;
//		if (this.utensilSource != null) {
//			return String.format(", null)
//		}
//		return String.format(action, null)
//	}

}


