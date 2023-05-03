package items;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import math.CalorieCalculator;

/**
 * @author Julian Barrett
 *
 */
public class Recipes implements Serializable 
{

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
	public Recipes(final String name, final int numPpl, final List<Ingredient> ingredients,
			final List<Utensils> utensils,final  List<Steps> steps) 
	{
		this.ingredients = new ArrayList<Ingredient>();
		for (Ingredient i : ingredients) 
		{
			this.ingredients.add(i);
		}
		alphabetize(this.ingredients);
		
		this.name = name;
		this.numPpl = numPpl;
		this.steps =steps;

		this.utensils = new ArrayList<Utensils>();
		for (Utensils b : utensils)
		{
			this.utensils.add(b);
		}
		alphabetizeU(this.utensils);
		
	}
	
	/**
	 * returns steps.
	 * @return steps list.
	 */
	public List<Steps> getSteps () 
	{
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
	public String getName() 
	{
		return this.name;
	}
	
	
	/**
	 * returns number of people.
	 * @return numPpl.
	 */
	public int numPpl() 
	{
		return this.numPpl;
	}

	/**
	 * Method alphabetizes a list of utensils.
	 * 
	 * @param ingrds for list to be alphabetically organized.
	 */
	public void alphabetize(final List<Ingredient> ingrds) 
	{

		int n = ingrds.size();
		Ingredient temp;
		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < n; j++)
			{

				// to compare one string with other strings
				if (ingrds.get(i).getName().compareTo
						(ingrds.get(j).getName()) > 0) 
				{
					// swapping
					temp = ingrds.get(i);
					ingrds.set(i, ingrds.get(j));
					ingrds.set(j, temp);
				}
			}
		}
	}

	/**
	 * method alphabetizes a list of utensils.
	 * 
	 * @param utnsl for list to be alphabetically organized.
	 */
	public void alphabetizeU(final List<Utensils> utnsl)
	{

		int n = utnsl.size();
		Utensils temp;
		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < n; j++)
			{

				// to compare one string with other strings
				if (utnsl.get(i).getName().compareTo(utnsl.get(j).getName()) > 0)
				{
					// swapping
					temp = utnsl.get(i);
					utnsl.set(i, utnsl.get(j));
					utnsl.set(j, temp);
				}
			}
		}
	}
	/**
	 * Calorie calc.
	 * @return double
	 */
	public double calorieCalculator() 
	{
		double calories = 0;
		for (int i = 0; i < ingredients.size(); i++) 
		{
		  calories += CalorieCalculator.calculateCalories(ingredients.get(i).getName(),
		      ingredients.get(i).getAmount(), ingredients.get(i).getUnit());
		}
		return calories;
	}

}
