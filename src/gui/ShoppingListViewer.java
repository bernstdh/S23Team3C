package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import items.Ingredient;
import math.UnitConversion;
/**
 * 
 * @author Shaury Gautam
 * Shopping Viewer 
 */

public class ShoppingListViewer extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JLabel numPeopleLabel;
	private JTextField numPeopleBox;
	private JButton generateButton;
	private JButton unitsButton;
	private JTextArea shoppingListBox;
	private ArrayList<Ingredient> box;
	private ArrayList<String> repeat = new ArrayList<String>();
	private ArrayList<String> repeatIng = new ArrayList<String>();

	private int count = 0;

	/**
	 * Constructor.
	 * @param ingrds Array List of Ingredients
	 * @param num Int
	 * @param title Title
	 */

	public ShoppingListViewer(final ArrayList<Ingredient> ingrds,
			final String title) 
	{
		super("KiLowBites Shopping List Viewer\t" + title);

		box = new ArrayList<Ingredient>();
		numPeopleLabel = new JLabel("Number of People:");
		numPeopleBox = new JTextField(10);
		generateButton = new JButton("Generate Shopping List");
		unitsButton = new JButton("Change units");
		shoppingListBox = new JTextArea(20, 40);
		shoppingListBox.setEditable(false); 

		setLayout(new FlowLayout());
		add(numPeopleLabel);
		add(numPeopleBox);
		add(generateButton);
		add(unitsButton);
		add(new JScrollPane(shoppingListBox));

		generateButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(final ActionEvent e)
			{
				numPeopleCalc(ingrds);
			}
		});

		unitsButton.addActionListener(new ActionListener() {
		    public void actionPerformed(final ActionEvent e) {
		        changeUnit();
		         new ShoppingUnitWindow(ShoppingListViewer.this, repeat);
		    }
		});

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);

	}



	/**
	 * calculate Amounts.
	 * @param ingredients String
	 * @param num number of items
	 */
	private void numPeopleCalc(final ArrayList<Ingredient> ingredients) 
	{
		double numPeople = 0;
		try 
		{
			numPeople = Double.parseDouble(numPeopleBox.getText());
		} catch (NumberFormatException ex)
		{
			shoppingListBox.setText("Please enter a valid amount of people.");
			return;
		}

		for (Ingredient str : ingredients) {
			double multiplier = 1.0;
			multiplier = str.getOgAmount();
			double result = numPeople * multiplier;
			str.setAmount(result);
			if(count < 1) 	box.add(str);
		}
		count++;
		updateShoppingListDisplay();
	}

	/**
	 * Adds items to repeated list.
	 */
	private void changeUnit() {
		for(int i = 0; i < box.size(); i++) {
			for(int j = 0; j < box.size(); j++) {
				if(box.get(i).getIngredient().getIngredientName().equals
						(box.get(j).getIngredient().getIngredientName()) && i != j) {
					repeat.add(box.get(i).getUnit());
					repeat.add(box.get(j).getUnit());
					repeatIng.add(box.get(i).getIngredient().getIngredientName());
					repeatIng.add(box.get(j).getIngredient().getIngredientName());

				}
			}
		}
	}
	
	public void convertUnits(String newUnit) {
	    for (int i = 0; i < box.size(); i++) {
	        String ingredient = box.get(i).getIngredient().getIngredientName();
	        String fromUnit = box.get(i).getUnit();
	        double amount = box.get(i).getAmount();

	        if (repeat.contains(fromUnit) && repeatIng.contains(ingredient) && !fromUnit.equals(newUnit)) {
	            double convertedAmount = UnitConversion.converter(ingredient, fromUnit, newUnit, amount);
	            box.get(i).setUnit(newUnit);
	            box.get(i).setAmount(convertedAmount);
	        }
	    }
	    updateShoppingListDisplay();
	}
	private void updateShoppingListDisplay() {
	    String display = "";
	    for (Ingredient entry : box) {
	        display += (entry.toString()) + "\n";
	    }
	    shoppingListBox.setText(display);
	}

}





