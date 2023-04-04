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
	private String g = "g";
	private String dr = "dr";
	private String oz = "oz";
	private String lb = "lb";
	private String p = "p";
	private String tsp = "tsp";
	private String tbs = "tbs";
	private String floz = "floz";
	private String cup = "cup";
	private String pt = "pt";
	private String qt = "qt";
	private String gal = "gal";
	private String ml = "ml";
	
	private JComboBox<String> ingredientBox;
	private JTextField amountBox;
	private JComboBox<String> unitBox;
	private JLabel calorieLabel;
	private JButton calc;
	private JButton reset;
	
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
		calc = new JButton(new ImageIcon("calculate.png"));
    reset = new JButton(new ImageIcon("reset.png"));

		JPanel panel = new JPanel(new GridLayout(2,1));
		JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		upperPanel.add(calc);
		upperPanel.add(reset);
		lowerPanel.add(new JLabel("Ingredient:"));
		lowerPanel.add(ingredientBox);
		lowerPanel.add(new JLabel("Amount:"));
		lowerPanel.add(amountBox);
		lowerPanel.add(new JLabel("Unit:"));
		lowerPanel.add(unitBox);
		lowerPanel.add(calorieLabel);
		panel.add(upperPanel, 0);
		panel.add(lowerPanel, 1);
		add(panel);

		setSize(400, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setSize(600, 200);
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
	  if (amount < 0.0) return 0.0;
	  double calories = 0.0;
	  Ingredients ing = Ingredients.fromCode(ingredient);
//	  double calories = amount * ing.getCaloriesPerGram();
	  if (unit.equals(g)) calories = amount * ing.getCaloriesPerGram();
	  else if (unit.equals(dr)) calories = UnitConversion.dramsConversions(ingredient,
	      g, amount) * ing.getCaloriesPerGram();
	  else if (unit.equals(oz)) calories = UnitConversion.ozConversions(ingredient,
        g, amount) * ing.getCaloriesPerGram();
	  else if (unit.equals(lb)) calories = UnitConversion.lbConversions(ingredient,
        g, amount) * ing.getCaloriesPerGram();
	  else if (unit.equals(p)) calories = UnitConversion.pinchesConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
	  else if (unit.equals(tsp)) calories = UnitConversion.tspConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
	  else if (unit.equals(tbs)) calories = UnitConversion.tbsConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
	  else if (unit.equals(floz)) calories = UnitConversion.flozConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
	  else if (unit.equals(cup)) calories = UnitConversion.cupConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
	  else if (unit.equals(pt)) calories = UnitConversion.ptConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
	  else if (unit.equals(qt)) calories = UnitConversion.qtConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
	  else if (unit.equals(gal)) calories = UnitConversion.galConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
	  else if (unit.equals(ml)) calories = UnitConversion.mlConversion(ingredient,
        g, amount) * ing.getCaloriesPerGram();
	  return calories;
	  
	}

}
