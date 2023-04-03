import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Calorie Calculator from Grams GUI.
 * @author Shaury Gautam
 *
 */
public class CalorieCalculator extends JFrame implements ItemListener 
{
	private static final long serialVersionUID = 1L;
	String apple = "Apple";
	String banana = "Banana";
	String orange = "Orange";
	
	private JComboBox<String> ingredientBox;
	private JTextField amountBox;
	private JComboBox<String> unitBox;
	private JLabel calorieLabel;
	
	/**
	 * Constructor. 
	 */
	public CalorieCalculator() 
	{
		super("Calorie Calculator");
		Ingredients[] ingredient = Ingredients.values();
		
		ingredientBox = new JComboBox<>();
    for (int i = 0; i < ingredient.length; i++)
    {
      ingredientBox.addItem(ingredient[i].getIngredientName());
    }
    ingredientBox.addItemListener(this);
		amountBox = new JTextField(10);

		String[] units = {"g", "dr", "oz", "lb", "p", "tsp", "tbs", "floz",
		    "cup", "pt", "qt", "gal", "ml"};
		unitBox = new JComboBox<>(units);
		unitBox.addItemListener(this);

		calorieLabel = new JLabel("");

		JPanel panel = new JPanel(new FlowLayout());
		panel.add(new JLabel("Ingredient:"));
		panel.add(ingredientBox);
		panel.add(new JLabel("Amount:"));
		panel.add(amountBox);
		panel.add(new JLabel("Unit:"));
		panel.add(unitBox);
		panel.add(calorieLabel);
		add(panel);

		setSize(400, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(500, 100);
	}
	
	/**
	 * Temporary main.
	 * @param args argument
	 */
	public static void main(final String[] args) 
	{
		new CalorieCalculator();
	}

	
	/**
	 * Overridden method.
	 * @param e ItemEvent
	 */
	public void itemStateChanged(final ItemEvent e)
	{
	  double amount = -1.0;
		String ingredient = (String) ingredientBox.getSelectedItem();
		if (amountBox.getText().equals("")) amount = 0.0;
		else amount = Double.parseDouble(amountBox.getText());
		String unit = (String) unitBox.getSelectedItem();

		double calories = calculateCalories(ingredient, amount, unit);

		calorieLabel.setText("Calories: " + calories);
	}

	/**
	 * calculate calorie method.
	 * @param ingredient String
	 * @param amount double
	 * @param unit String
	 * @return calories
	 */
	private double calculateCalories(final String ingredient, 
			final double amount, final String unit) 
	{
	  if (amount < 0.0)return 0.0;
	  Ingredients ing = Ingredients.fromCode(ingredient);
	  double calories = amount * ing.getCaloriesPerGram();
	  double result = 0.0;
	  result = UnitConversion.gramsConversions(ingredient, unit, amount);
	  calories = result * ing.getCaloriesPerGram();
	  return calories;
	  
	}

}
