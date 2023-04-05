import java.io.IOException;
import java.util.ArrayList;

public class MealEditorDriver {

	public static void main(String[] args) {

		Ingredient newIngredient = new Ingredient(Ingredients.COD, "cod", 5.0, "pds");
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
		ingredientList.add(newIngredient);
		Utensils newUtensil = new Utensils("spoon", "spoon");
		ArrayList<Utensils> utensilList = new ArrayList<Utensils>();
		utensilList.add(newUtensil);
		Steps testStep = new Steps("julian steps", newIngredient, newUtensil);
		ArrayList<Steps> stepList = new ArrayList<Steps>();
		stepList.add(testStep);

		Recipes newRecipe = new Recipes("Julian7", 5, ingredientList, utensilList, stepList);
		Recipes newRecipe2 = new Recipes("Julian8", 5, ingredientList, utensilList, stepList);
		Recipes newRecipe3 = new Recipes("recipe3", 4, ingredientList, utensilList, stepList);

		ArrayList<Recipes> recipeTestList = new ArrayList<Recipes>();
		// recipeTestList.add(newRecipe);
		recipeTestList.add(newRecipe2);
		recipeTestList.add(newRecipe3);

		Meals testMeal = new Meals("testMeal", recipeTestList);

		try {
			Serializer.serializeRecipe(
					"C:\\Users\\Julian Barrett\\OneDrive\\Desktop\\345FinalProject\\julianrepository\\S23Team3C",
					newRecipe3);
			Serializer.serializeRecipe(
					"C:\\Users\\Julian Barrett\\OneDrive\\Desktop\\345FinalProject\\julianrepository\\S23Team3C",
					newRecipe2);
			Serializer.serializeMeal(
					"C:\\Users\\Julian Barrett\\OneDrive\\Desktop\\345FinalProject\\julianrepository\\S23Team3C",
					testMeal);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// all of these are for testing above
		// maybe I should initialize this.meal to a new null meal

		new MealEditor();

	}
}
