package calculators;
import javax.swing.*;

import ingredients.IngredientTable;

import java.awt.*;
import java.awt.event.*;
/**
 * Calorie Calculator from Grams GUI.
 * @author Shaury Gautam/Trace Jones
 *
 */
public class CalorieCalculatorWindow extends JFrame implements ActionListener 
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
	private String calor = "Calories:";
	private String invalid = "Calories: Please Enter a Valid Number";
	private String negative = "Calories: Please Enter a Positive Number";
	
	private String[] units = {g, dr, oz, lb, p, tsp, tbs, floz, cup, pt, qt, gal, ml};
	
	private JComboBox<String> ingredientBox;
	private JTextField amountBox;
	private JComboBox<String> unitBox;
	private JLabel calorieLabel;
	private JButton calc;
	private JButton reset;
	
	/**
	 * Constructor. 
	 */
	public CalorieCalculatorWindow() 
	{
		super("Calorie Calculator");
		IngredientTable ingredients = IngredientTable.createInstance();
		
		ingredientBox = new JComboBox<>();
    for (int i = 0; i < ingredients.size(); i++)
    {
      ingredientBox.addItem(ingredients.get(i).getIngredientName());
    }
    ingredientBox.addActionListener(this);
		amountBox = new JTextField(10);

		unitBox = new JComboBox<>(units);
		unitBox.addActionListener(this);

		calorieLabel = new JLabel(calor);
		calc = new JButton(new ImageIcon("calculate.png"));
		calc.addActionListener(this);
    reset = new JButton(new ImageIcon("reset.png"));
    reset.addActionListener(this);

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
	 * Overridden method.
	 * @param e ItemEvent
	 */
	public void actionPerformed(final ActionEvent e) throws NumberFormatException
	{
	  if (e.getSource() == calc)
	  {
	    double amount = -1.0;
	    // test.
	    String ingredient = (String) ingredientBox.getSelectedItem();
	    if (amountBox.getText().equals("")) amount = 0.0;
	    String unit = (String) unitBox.getSelectedItem();
	    try
	    {
	      amount = Double.parseDouble(amountBox.getText());
	      if (amount < 0) calorieLabel.setText(negative);
	      else
	      {
	        double calories = CalorieCalculator.calculateCalories(ingredient, amount, unit);
	        calorieLabel.setText(String.format("Calories: %.1f", calories));
	      } 
	    }
	    catch (NumberFormatException nfe)
	    {
	      calorieLabel.setText(invalid);
	    } 
	  }
	  if (e.getSource() == reset)
	  {
	    ingredientBox.setSelectedItem("Alcohol");
	    unitBox.setSelectedItem(g);
	    calorieLabel.setText(calor);
	    amountBox.setText("");
	  }
	  
	}

}
