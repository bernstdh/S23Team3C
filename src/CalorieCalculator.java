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
	private JComboBox<Double> amountBox;
	private JComboBox<String> unitBox;
	private JLabel calorieLabel;
	
	/**
	 * Constructor. 
	 */
	public CalorieCalculator() 
	{
		super("Calorie Calculator");
		
		String[] ingredients = {apple, banana, orange};
		ingredientBox = new JComboBox<>(ingredients);
		ingredientBox.addItemListener(this);

		Double[] amounts = {0.25, 0.5, 1.0, 1.5, 2.0};
		amountBox = new JComboBox<>(amounts);
		amountBox.addItemListener(this);

		String[] units = {"cup", "oz", "g", "kg"};
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
		String ingredient = (String) ingredientBox.getSelectedItem();
		double amount = (double) amountBox.getSelectedItem();
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
		if (ingredient.equals(apple))
		{
			return amount * 2.0;
		} else if (ingredient.equals(banana)) 
		{
			return amount * 9.0;
		} else if (ingredient.equals(orange)) 
		{
			return amount * 7.0;
		} else 
		{
			return 0.0;
		}
	}

}
