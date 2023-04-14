package gui;
import javax.swing.*;

import items.Ingredients;
import math.UnitConversion;

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
	private ArrayList<String> box;
	private ArrayList<String> repeat = new ArrayList<String>();


	/**
	 * Constructor.
	 * @param strings Array List String
	 * @param num Int
	 * @param title Title
	 */

	public ShoppingListViewer(final ArrayList<Ingredient> strings,
			final String title) 
	{
		super("KiLowBites Shopping List Viewer\t" + title);

		box = new ArrayList<String>();
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
				generateShoppingList(strings);
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
	 * @param strings String
	 * @param num number of items
	 */
	private void generateShoppingList(final ArrayList<String> strings) 
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

		for (String str : strings) {
			double multiplier = 1.0;
			String digit = str.substring(0, str.indexOf(" "));
			multiplier = Double.parseDouble(digit);
			double result = numPeople * multiplier;
			display += result + str.substring(str.indexOf(" ")) + "\n";
			box.add(display);
		}

		shoppingListBox.setText(display);
	}

	/**
	 * Adds items to repeated list.
	 */
	private void changeUnit() {
		for(int i = 0; i < box.size(); i++) {
			String[] tempi = box.get(i).split(" ");
			for(int j = 0; j < box.size(); j++) {
				String[] tempj = box.get(i).split(" ");
				if(tempi[3].equals(tempj[3]) && i != j) {
					repeat.add(tempi[1]);
					repeat.add(tempj[1]);
				}
			}
		}
	}
	
	public void convertUnits(String newUnit) {
	    for (int i = 0; i < box.size(); i++) {
	        String[] parts = box.get(i).split(" ");
	        String ingredient = parts[3];
	        String fromUnit = parts[1];
	        double amount = Double.parseDouble(parts[0]);

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





