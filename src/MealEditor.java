import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.synth.ColorType;
import java.awt.Color;
import java.awt.Dimension;



public class MealEditor extends JFrame {

	private JLabel nameLabel;
	private JTextField nameBox;
	private JTextArea recipeTextBox;
	private JButton addRecipeButton;
	private JButton deleteRecipeButton;


	private JButton newButton;
	private JButton openButton;
	private JButton saveButton;
	private JButton saveAsButton;
	private JButton closeButton;


	
	public MealEditor() {
		
		super("KiLowBites Meal Editor");
		
		nameLabel = new JLabel("Name:");
		nameBox = new JTextField(10);
		recipeTextBox = new JTextArea(20, 40);
		recipeTextBox.setEditable(false); 
		
		Dimension buttonSize = new Dimension(30, 30);
		
		newButton = new JButton(new ImageIcon("baseline_add_box_black_24dp.png"));
		newButton.setPreferredSize(buttonSize);
		openButton = new JButton(new ImageIcon("baseline_file_open_black_24dp.png"));
		openButton.setPreferredSize(buttonSize);
		saveButton = new JButton(new ImageIcon("baseline_save_black_24dp.png"));
		saveButton.setPreferredSize(buttonSize);
		saveAsButton = new JButton(new ImageIcon("baseline_save_as_black_24dp.png"));
		saveAsButton.setPreferredSize(buttonSize);
		closeButton = new JButton(new ImageIcon("baseline_close_black_24dp.png"));
		closeButton.setPreferredSize(buttonSize);

		
		this.setLayout(new BorderLayout());
		// buttons on the top
	    JPanel p = new JPanel();
	    p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.add(newButton);
		p.add(openButton);
		p.add(saveButton);
		p.add(saveAsButton);
		p.add(closeButton);
				
		// name panel
		JPanel nameFrame = new JPanel();
		nameFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
		nameFrame.add(nameLabel);
		nameFrame.add(nameBox);
		nameBox.setEditable(true);
		
		// buttons panel and name panels, inside a borderPnl
		JPanel borderPnl = new JPanel(new BorderLayout());
		borderPnl.add(p, BorderLayout.NORTH);
		borderPnl.add(nameFrame, BorderLayout.CENTER);

		this.add(borderPnl);
		
		// JPanel with the add recipe and delete button	
		JPanel recipeBigPanel = new JPanel(new BorderLayout());
		
		JPanel addRecipeFlow = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addRecipeButton = new JButton("Add Recipe");
		addRecipeFlow.add(addRecipeButton);
		recipeBigPanel.add(addRecipeFlow, BorderLayout.NORTH);
		
		recipeBigPanel.add(new JScrollPane(recipeTextBox), BorderLayout.CENTER);
		deleteRecipeButton = new JButton("Delete");
		recipeBigPanel.add(deleteRecipeButton, BorderLayout.CENTER);
		
		recipeBigPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(recipeBigPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
		
		// ACTION LISTENERS!!!
//		
//		newButton.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(final ActionEvent e)
//			{
//				generateShoppingList(strings, num);
//			}
//		});

	}
	
	public static void main(String[] args) {
		new MealEditor();
		
	}
}
