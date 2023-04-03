import java.util.List;

public class Meals {

	private List<Recipes> recipes;

	public Meals(List<Recipes> recipes) 
	{
		this.recipes = recipes;
	}

	public void addRecipe(Recipes recipe) {
		this.recipes.add(recipe);
	}
}
