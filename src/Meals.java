import java.io.Serializable;
import java.util.List;

/**
 * Meals class creates a list of recipes.
 * @author Julian Barrett
 *
 */
public class Meals implements Serializable {

	private List<Recipes> recipes;
	private String name;

	/** Meals constructor
	 * @param recipes for list of recipes.
	 */
	public Meals(String name, List<Recipes> recipes)
	{
		this.name = name;
		this.recipes = recipes;
	}
	
	/**
	 * returns name;
	 * @return name.
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * returns recipes.
	 * @return recipes;
	 */
	public List<Recipes> getRecipes() 
	{
		return this.recipes;
	}

	/** 
	 * Add a recipe to the list.
	 * @param recipe to be added.
	 */
	public void addRecipe(Recipes recipe) 
	{
		this.recipes.add(recipe);
	}
}
