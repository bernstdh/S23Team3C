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
	 */

	public ShoppingListViewer() 
	{
		super("KiLowBites Shopping List Viewer\t Recipe name");

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
				generateShoppingList();
			}
		});

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);

	}
	/**
	 * temp main method.
	 * @param args arg
	 */

	public static void main(final String[] args) 
	{
		new ShoppingListViewer();
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
	 */
	private void generateShoppingList() 
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

		String[] shoppingList = new String[3];
		shoppingList[0] = (1*numPeople) + " banana";
		shoppingList[1] = (2*numPeople) + " apples sliced";
		shoppingList[2] = (1*numPeople) + " gallons of pickle juice";

		shoppingListBox.setText(String.join("\n", shoppingList));
	}
}
