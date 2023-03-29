import javax.swing.*;
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
	private JTextArea shoppingListBox;

	/**
	 * Constructor.
	 * @param strings Array List String
	 * @param num Int
	 * @param title Title
	 */

	public ShoppingListViewer(final ArrayList<String> strings, 
			final int num, final String title) 
	{
		super("KiLowBites Shopping List Viewer\t" + title);

		numPeopleLabel = new JLabel("Number of People:");
		numPeopleBox = new JTextField(10);
		generateButton = new JButton("Generate Shopping List");
		shoppingListBox = new JTextArea(20, 40);
		shoppingListBox.setEditable(false); 

		setLayout(new FlowLayout());
		add(numPeopleLabel);
		add(numPeopleBox);
		add(generateButton);
		add(new JScrollPane(shoppingListBox));

		generateButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(final ActionEvent e)
			{
				generateShoppingList(strings, num);
			}
		});

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);

	}

	/**
	 * Generic selection sort alphabetical method.
	 * @param list list
	 * @return Sortedlist
	 */
	public ArrayList<String> sortList(final ArrayList<String> list)
	{
		ArrayList<String> sortedList = new ArrayList<>();
		for (String s : list) 
		{
			sortedList.add(s);
		}
		for (int i = 0; i < sortedList.size() - 1; i++)
		{
			for (int j = i + 1; j < sortedList.size(); j++) 
			{
				if (sortedList.get(i).compareTo(sortedList.get(j)) > 0) 
				{
					String temp = sortedList.get(i);
					sortedList.set(i, sortedList.get(j));
					sortedList.set(j, temp);
				}
			}
		}
		return sortedList;
	}


	/**
	 * generateList.
	 * @param strings String
	 * @param num number of items
	 */
	private void generateShoppingList(final ArrayList<String> strings, final int num) 
	{
		double numPeople = 0;
		ArrayList<String> list = sortList(strings);
		String display = "";
		try 
		{
			numPeople = Double.parseDouble(numPeopleBox.getText());
		} catch (NumberFormatException ex)
		{
			shoppingListBox.setText("Please enter a valid amount of people.");
			return;
		}
		
		for(String ss: list) 
		{
			display += ss + "\n";
		}

		shoppingListBox.setText(display);
	}
}
