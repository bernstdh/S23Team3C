package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import items.Meals;
import items.Recipes;
import utilities.Serializer;

import java.awt.Color;
import java.awt.Dimension;




public class MealEditor extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel;
	private JTextField nameBox;
	private JButton addRecipeButton;
	private JButton deleteRecipeButton;
	
	private JButton newButton;
	private JButton openButton;
	private JButton saveButton;
	private JButton saveAsButton;
	private JButton closeButton;

	private Meals meal;
	// 
	private JFileChooser fileChooser;
	private DefaultListModel<String> recipeListModel;
	private JList<String> jlistModel;
	private JScrollPane recipeScrollPane;
	
	static final String NEWBUTTON = "newButton";
	static final String OPENBUTTON = "openButton";
	static final String SAVEBUTTON = "saveButton";
	static final String SAVEASBUTTON = "saveAsButton";
	static final String CLOSEBUTTON = "closeButton";
	private final String changedState = "changedState";
	private final String unchangedState = "unchangedState";
	private final String nullState = "nullState";
	private String state;
	
	public MealEditor() {
		
		super("KiLowBites Meal Editor");
		setSize(700, 800);
		setResizable(false);
		this.state = nullState;
		//this.nullstate true if doc is null state		
		
		nameLabel = new JLabel("Name:");
		nameBox = new JTextField(10); 
		Dimension buttonSize = new Dimension(30, 30);
		
		newButton = createJButton("newButton.png", NEWBUTTON);
		newButton.setPreferredSize(buttonSize);
		newButton.addActionListener(this);
		newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
		
		openButton = createJButton("openButton.png", OPENBUTTON);
		openButton.setPreferredSize(buttonSize);
		openButton.addActionListener(this);
		openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));

		saveButton = createJButton("saveButton.png", SAVEBUTTON);
		saveButton.setPreferredSize(buttonSize);
		saveButton.addActionListener(this);
		saveButton.setEnabled(state.equals(changedState));

		saveAsButton = createJButton("saveAsButton.png", SAVEASBUTTON);
		saveAsButton.setPreferredSize(buttonSize);
		saveAsButton.addActionListener(this);
		saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));

		closeButton = createJButton("closeButton.png", CLOSEBUTTON);
		closeButton.setPreferredSize(buttonSize);
		closeButton.addActionListener(this);
		closeButton.setEnabled(state.equals(unchangedState));

		// whooo hooo
//		newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
//		openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
//		saveButton.setEnabled(state.equals(changedState));
//		saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
//		closeButton.setEnabled(state.equals(unchangedState));

		
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
		nameBox.addActionListener(this);
		
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
		addRecipeButton.setEnabled(!state.equals(nullState));
		addRecipeFlow.add(addRecipeButton);
				
		
		recipeListModel = new DefaultListModel<>();
		jlistModel = new JList<>(recipeListModel);
		jlistModel.setPreferredSize(new Dimension(400, 250));
		recipeScrollPane = new JScrollPane(jlistModel);
	    recipeScrollPane.setViewportView(jlistModel);
		recipeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		recipeScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		recipeScrollPane.setPreferredSize(new Dimension(250, 200));
        addRecipeFlow.add(recipeScrollPane, BorderLayout.CENTER);
        
        JPanel deletePanel = new JPanel(new BorderLayout());
		deleteRecipeButton = new JButton("Delete");
		deleteRecipeButton.addActionListener(this);
		deleteRecipeButton.setEnabled(false);
		deletePanel.add(deleteRecipeButton, BorderLayout.SOUTH);
		addRecipeFlow.add(deletePanel);
		recipeBigPanel.add(addRecipeFlow, BorderLayout.CENTER);
		recipeBigPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		this.fileChooser = new JFileChooser();
		
		this.add(recipeBigPanel); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}
	
	  @Override
	  public void actionPerformed(final ActionEvent e)
	  {
		
	    if (e.getSource() == addRecipeButton)
	    {
	    	if (this.state != nullState) {
	    		this.state = changedState;
	    		this.state = nullState;
	    		newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
	    		openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
	    		saveButton.setEnabled(state.equals(changedState));
	    		saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
	    		closeButton.setEnabled(state.equals(unchangedState));
	    		int returnVal = fileChooser.showOpenDialog(MealEditor.this);
	    		if (returnVal == JFileChooser.APPROVE_OPTION) {
	    			File file = fileChooser.getSelectedFile();
	    			String tempFileName = file.toString();
		        try {
		        	if (tempFileName.contains(".rcp")) {
		        		meal.addRecipe(Serializer.deserializeRecipe(tempFileName));
		        		recipeListModel.addElement(meal.getRecipes().get(meal.getRecipes().size() - 1).getName());
		        	}
		        } catch (IOException | ClassNotFoundException ia) {
		        	System.out.println("Did not select .rcp file");
		        }
	    		}
	    	}
	    } else if (e.getSource() == deleteRecipeButton) {
	    	if (!state.equals(nullState)); {
	    		newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
	    		openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
	    		saveButton.setEnabled(state.equals(changedState));
	    		saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
	    		closeButton.setEnabled(state.equals(unchangedState));
	    		int index = this.jlistModel.getSelectedIndex();
	    		recipeListModel.remove(index);
	    		this.meal.getRecipes().remove(index);
	    	}
	    } else if (e.getSource() == openButton) {
	    	this.state = unchangedState;
	    	deleteRecipeButton.setEnabled(true);
	    	addRecipeButton.setEnabled(true);
	    	newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
			openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
			saveButton.setEnabled(state.equals(changedState));
			saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
			closeButton.setEnabled(state.equals(unchangedState));
	    	int returnVal = fileChooser.showOpenDialog(MealEditor.this);
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
		        String tempFileName = file.getName();
		        try {
		        	if (tempFileName.contains(".mel")) {
		        		this.meal = Serializer.deserializeMeal(tempFileName);
		        		this.recipeListModel.removeAllElements();
		        	}
		        	for (int i = 0; i < meal.getRecipes().size(); i++) {
		        		this.recipeListModel.addElement(meal.getRecipes().get(i).getName());
		        	}
		        } catch (IOException | ClassNotFoundException ia) {
		        	System.out.println("Did not select .mel file");
		        }
	        }
	    } else if (e.getSource() == newButton) {
	    	this.state = unchangedState;
	    	addRecipeButton.setEnabled(true);
	    	deleteRecipeButton.setEnabled(true);
	    	newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
			openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
			saveButton.setEnabled(state.equals(changedState));
			saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
			closeButton.setEnabled(state.equals(unchangedState));
	        this.meal = new Meals("", new ArrayList<Recipes>());
    		this.recipeListModel.removeAllElements();   
	    } else if (e.getSource() == saveButton) {
	    	this.state = unchangedState;
	    	newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
			openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
			saveButton.setEnabled(state.equals(changedState));
			saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
			closeButton.setEnabled(state.equals(unchangedState));
				try {
					Serializer.serializeMeal(this.meal);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
	    } else if (e.getSource() == saveAsButton) {
	    	this.state = unchangedState;
	    	newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
			openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
			saveButton.setEnabled(state.equals(changedState));
			saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
			closeButton.setEnabled(state.equals(unchangedState));
			File newFile = new File(this.meal.getName() + ".mel");
	        fileChooser.setSelectedFile(newFile);
    		// int returnVal = 
    		fileChooser.showSaveDialog(MealEditor.this);
    		try {
				Serializer.serializeMeal(fileChooser.getCurrentDirectory().toString(), 
						meal);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    } else if (e.getSource() == closeButton) {
	    	this.state = nullState;
	    	newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
			openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
			saveButton.setEnabled(state.equals(changedState));
			saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
			closeButton.setEnabled(state.equals(unchangedState));
	        this.dispose();
	    } else if (e.getSource() == nameBox) {
	    	if (this.state != nullState) {
	    		this.state = changedState;
	    		newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
	    		openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
	    		saveButton.setEnabled(state.equals(changedState));
	    		saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
	    		closeButton.setEnabled(state.equals(unchangedState));
	    		meal.setName(nameBox.getText());
	    	}
	    }
	  }
	  
	  private ImageIcon loadImageIcon(String name)
	  {
	    URL url = this.getClass().getResource("/icons/"+ name);
	    ImageIcon icon = new ImageIcon(url);
	    return icon;
	  }
	  
	  private JButton createJButton(String name, String actionCommand)
	  {
	    JButton result = new JButton(loadImageIcon(name));
	    result.setActionCommand(actionCommand);
	    result.addActionListener(this);
	    return result;
	  }
	  
}
