import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Julian Barrett
 *
 */
public class Recipes implements Serializable {

	private List<Ingredient> ingredients;
	private List<Utensils> utensils;
	private String name;
	private int numPpl;
	/**
	 * Constructor
	 * 
	 * @param ingredients for list of alphabetical ingredients.
	 * @param utensils    for list of alphabetical utensils.
	 */
	public Recipes(String name, int numPpl, List<Ingredient> ingredients, List<Utensils> utensils) 
	{
		this.ingredients = new ArrayList<Ingredient>();
		for (Ingredient i : ingredients) {
			this.ingredients.add(i);
		}
		
		this.name = name;
		this.numPpl = numPpl;
		this.ingredients = ingredients;
		alphabetize(this.ingredients);

		this.utensils = utensils;
		alphabetizeU(this.utensils);
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

}
