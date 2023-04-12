package shopping;
import javax.swing.*;

import calculators.UnitConversion;

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
	private ShoppingUnitWindow shop;
	/**
	 * Constructor.
	 * @param strings Array List String
	 * @param num Int
	 * @param title Title
	 */

	public ShoppingListViewer(final ArrayList<String> strings,
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
		
		unitsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(final ActionEvent e)
			{
				shop = new ShoppingUnitWindow();
				changeUnit();
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
	
	private void changeUnit() {
		String display = "";
		String unit = shop.getUnit();
		
		for(int i = 0; i < box.size(); i++) {
			String[] temp = box.get(i).split(" ");
			String last = box.get(i).substring(box.get(i).indexOf(" "));
			String first = "";
			double convert = Double.parseDouble(temp[0]);
			double val = UnitConversion.converter(temp[3], temp[1], converter(temp[1]), convert);
			first = val + last;
			display += first + "\n";
 		}
		
		shoppingListBox.setText(display);
	}
	
	private String converter(String unit) {
	    switch(unit.toLowerCase()) {
	        case "cup":
	            return "ml";
	      
	        case "dr":
	            return "ml";
	       
	        case "floz":
	            return "ml";
	        case "ml":
	            return "floz";
	        case "g":
	            return "oz";
	        case "oz":
	            return "g";
	        case "gal":
	            return "liters";
	        case "liters":
	            return "gal";
	        case "lb":
	            return "kg";
	        case "kg":
	            return "lb";
	        case "tsp":
	            return "ml";
	       
	        case "tbs":
	            return "ml";
	       
	        case "p":
	            return "ml";
	       
	        case "pt":
	            return "ml";
	        case "qt":
	            return "gal";
	       
	        default:
	            return "Unknown unit";
	    }
	}



	
}
