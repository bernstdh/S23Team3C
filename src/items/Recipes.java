package items;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import math.CalorieCalculator;

/**
 * @author Julian Barrett
 *
 */
public class Recipes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Ingredient> ingredients;
	private List<Steps> steps;
	private List<Utensils> utensils;
	private String name;
	private int numPpl;
	
	
	/**
	 * Constructor.
	 * @param name for recipe name.
	 * @param numPpl for how many ppl.
	 * @param ingredients for ingredient list.
	 * @param utensils for utensil list.
	 * @param steps for cooking.
	 */
	public Recipes(String name, int numPpl, List<Ingredient> ingredients,
			List<Utensils> utensils, List<Steps> steps) 
	{
		this.ingredients = new ArrayList<Ingredient>();
		for (Ingredient i : ingredients) {
			this.ingredients.add(i);
		}
		alphabetize(this.ingredients);
		
		this.name = name;
		this.numPpl = numPpl;
		this.steps =steps;

		this.utensils = new ArrayList<Utensils>();
		for (Utensils b : utensils) {
			this.utensils.add(b);
		}
		alphabetizeU(this.utensils);
		
	}
	
	/**
	 * returns steps.
	 * @return steps list.
	 */
	public List<Steps> getSteps () {
		return this.steps;
	}
	/**
	 * getter.
	 * @return ingredients list.
	 */
	public List<Ingredient> getIngredients()
	{
		return this.ingredients;	
	}
	
	/**
	 * getter.
	 * @return utensils list.
	 */
	public List<Utensils> getUtensils() 
	{
		return this.utensils;
	}
	
	/**
	 * Returns name.
	 * @return name.
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * returns number of people.
	 * @return numPpl.
	 */
	public int numPpl() {
		return this.numPpl;
	}

	/**
	 * Method alphabetizes a list of utensils.
	 * 
	 * @param ingredients for list to be alphabetically organized.
	 */
	public void alphabetize(List<Ingredient> ingredients) {

		int n = ingredients.size();
		Ingredient temp;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				// to compare one string with other strings
				if (ingredients.get(i).getName().compareTo(ingredients.get(j).getName()) > 0) {
					// swapping
					temp = ingredients.get(i);
					ingredients.add(i, ingredients.get(j));
					ingredients.add(j, temp);
				}
			}
		}
	}

	/**
	 * method alphabetizes a list of utensils.
	 * 
	 * @param utensils for list to be alphabetically organized.
	 */
	public void alphabetizeU(List<Utensils> utensils) {

		int n = utensils.size();
		Utensils temp;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				// to compare one string with other strings
				if (utensils.get(i).getName().compareTo(utensils.get(j).getName()) > 0) {
					// swapping
					temp = utensils.get(i);
					utensils.add(i, utensils.get(j));
					utensils.add(j, temp);
				}
			}
		}
	}
	
	public double calorieCalculator() {
		double calories = 0;
		for (int i = 0; i < ingredients.size(); i++) {
		  calories += CalorieCalculator.calculateCalories(ingredients.get(i).getName(),
		      ingredients.get(i).getAmount(), ingredients.get(i).getUnit());
		}
		return calories;
	}

}
