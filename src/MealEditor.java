import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import java.awt.Color;
import java.awt.Dimension;



public class MealEditor extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel;
	private JTextField nameBox;
	private JTextArea recipeTextBox;
	private JButton addRecipeButton;
	private JButton deleteRecipeButton;
	
	// private 


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
		
		newButton = new JButton(new ImageIcon("newButton.png"));
		newButton.setPreferredSize(buttonSize);
		openButton = new JButton(new ImageIcon("openButton.png"));
		openButton.setPreferredSize(buttonSize);
		saveButton = new JButton(new ImageIcon("saveButton.png"));
		saveButton.setPreferredSize(buttonSize);
		saveAsButton = new JButton(new ImageIcon("saveAsButton.png"));
		saveAsButton.setPreferredSize(buttonSize);
		closeButton = new JButton(new ImageIcon("closeButton.png"));
		closeButton.setPreferredSize(buttonSize);

		
		this.setLayout(new BorderLayout());
		// changed layout to grid
		//this.setLayout(new GridLayout(2, 0));
		
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
		this.add(borderPnl, BorderLayout.NORTH);
		
		// JPanel with the add recipe and delete button	
		JPanel recipeBigPanel = new JPanel(new BorderLayout());
		
		JPanel addRecipeFlow = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addRecipeButton = new JButton("Add Recipe");
		addRecipeButton.addActionListener(this);
		addRecipeFlow.add(addRecipeButton);
				
		recipeTextBox = new JTextArea ( 15, 25 );
	    recipeTextBox.setEditable ( false ); // set textArea non-editable
	    JScrollPane scroll = new JScrollPane (recipeTextBox);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        addRecipeFlow.add(scroll, BorderLayout.CENTER);
	    
        JPanel deletePanel = new JPanel(new BorderLayout());
		deleteRecipeButton = new JButton("Delete");
		deleteRecipeButton.addActionListener(this);
		deletePanel.add(deleteRecipeButton, BorderLayout.SOUTH);
		addRecipeFlow.add(deletePanel);

		recipeBigPanel.add(addRecipeFlow, BorderLayout.CENTER);
		recipeBigPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(recipeBigPanel); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);

	}
	
	  @Override
	  public void actionPerformed(final ActionEvent e)
	  {
	    if (e.getSource() == addRecipeButton)
	    {
	      // new ;
	    } else if (e.getSource() == deleteRecipeButton) {
	    	
	    }
	  }
	
	   public void write(String filename) throws IOException
	   {
	     ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename + ".mel"));
	     out.writeObject(this);
	     out.flush();
	     out.close();
	   }
	   
	   
	   // return value is a File Object?
	   // maybe return value should be a meal
	    public static File open(String filename) throws IOException
	   {
	     ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename + ".txt"));
	     File file;
	     try
	     {
	       file = (File)in.readObject();
	     }
	     catch (ClassNotFoundException cnfe)
	     {
	       file = new File("Unknown");
	     }
	     in.close();
	     
	     return file;
	   }
	
	public static void main(String[] args) {
		new MealEditor();
		
	}
}
