package shopping;
import javax.swing.*;

import calculators.UnitConversion;
import ingredients.Ingredient;
import ingredients.Ingredients;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
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
				generateShoppingList(ingrds);
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
	 * generateList.
	 * @param ingredients String
	 * @param num number of items
	 */
	private void generateShoppingList(final ArrayList<Ingredient> ingredients) 
	{
		double numPeople = 0;
		String display = "";
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
			multiplier = Double.parseDouble(str.getUnit());
			double result = numPeople * multiplier;
			display += result + str.toString().indexOf(" ") + "\n";
			str.setAmount(result);
			box.add(str);
		}

		shoppingListBox.setText(display);
	}

	/**
	 * Adds items to repeated list.
	 */
	private void changeUnit() {
		for(int i = 0; i < box.size(); i++) {
			for(int j = 0; j < box.size(); j++) {
				if(box.get(i).getIngredient().equals
						(box.get(j).getIngredient()) && i != j) {
					repeat.add(box.get(i).getUnit());
					repeat.add(box.get(j).getUnit());

				}
			}
		}
	}
	
	public void convertUnits(String newUnit) {
	    for (int i = 0; i < box.size(); i++) {
	        String ingredient = box.get(i).getIngredient().getIngredientName();
	        String fromUnit = box.get(i).getUnit();
	        double amount = box.get(i).getAmount();

	        if (repeat.contains(fromUnit)) {
	            double convertedAmount = UnitConversion.converter(ingredient, fromUnit, newUnit, amount);
	            String val = convertedAmount + newUnit + box.get(i).substring(box.get(i).indexOf("of") - 1);
	            box.set(i, val);
	        }
	    }
	    updateShoppingListDisplay();
	}
	private void updateShoppingListDisplay() {
	    StringBuilder display = new StringBuilder();
	    for (String entry : box) {
	        display.append(entry);
	    }
	    shoppingListBox.setText(display.toString());
	}

}





