package meals;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import app.Serializer;
import ingredients.Ingredient;
import ingredients.Ingredients;
import recipe.Recipes;
import steps.Steps;
import utensil.Utensils;

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
	
	public MealEditor() {
		
		super("KiLowBites Meal Editor");
		
		// set this.meal to something so it wouldnt break
		Ingredient newIngredient = new Ingredient(Ingredients.COD, "cod", 5.0, "pds");
		ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
		ingredientList.add(newIngredient);
		Utensils newUtensil = new Utensils("spoon", "spoon");
		ArrayList<Utensils> utensilList = new ArrayList<Utensils>();
		utensilList.add(newUtensil);
		Steps testStep = new Steps("julian steps", newIngredient, newUtensil);
		ArrayList<Steps> stepList = new ArrayList<Steps>();
		stepList.add(testStep);

		Recipes newRecipe = new Recipes("Julian7", 5, ingredientList, utensilList, stepList);
		Recipes newRecipe2 = new Recipes("Julian8", 5, ingredientList, utensilList, stepList);
		Recipes newRecipe3 = new Recipes("recipe3", 4, ingredientList, utensilList, stepList);

		ArrayList<Recipes> recipeTestList = new ArrayList<Recipes>();
		// recipeTestList.add(newRecipe);
		recipeTestList.add(newRecipe2);
		recipeTestList.add(newRecipe3);

		Meals testMeal = new Meals("testMeal", recipeTestList);
		this.meal = new Meals("julian3", recipeTestList);
		
		try {
			Serializer.serializeRecipe("C:\\Users\\Julian Barrett\\OneDrive\\Desktop\\345FinalProject\\julianrepository\\S23Team3C", newRecipe3);
			Serializer.serializeRecipe("C:\\Users\\Julian Barrett\\OneDrive\\Desktop\\345FinalProject\\julianrepository\\S23Team3C", newRecipe2);
			Serializer.serializeMeal("C:\\Users\\Julian Barrett\\OneDrive\\Desktop\\345FinalProject\\julianrepository\\S23Team3C", testMeal);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// all of these are for testing above
		// maybe I should initialize this.meal to a new null meal
		
				
		nameLabel = new JLabel("Name:");
		nameBox = new JTextField(10); 
		
		Dimension buttonSize = new Dimension(30, 30);
		
		newButton = new JButton(new ImageIcon("newButton.png"));
		newButton.setPreferredSize(buttonSize);
		newButton.addActionListener(this);
		openButton = new JButton(new ImageIcon("openButton.png"));
		openButton.setPreferredSize(buttonSize);
		openButton.addActionListener(this);
		saveButton = new JButton(new ImageIcon("saveButton.png"));
		saveButton.setPreferredSize(buttonSize);
		saveButton.addActionListener(this);
		saveAsButton = new JButton(new ImageIcon("saveAsButton.png"));
		saveAsButton.setPreferredSize(buttonSize);
		saveAsButton.addActionListener(this);
		closeButton = new JButton(new ImageIcon("closeButton.png"));
		closeButton.setPreferredSize(buttonSize);
		closeButton.addActionListener(this);

		
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
	    	int returnVal = fileChooser.showOpenDialog(MealEditor.this);
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
		        String tempFileName = file.toString();
		        // System.out.println(tempFileName);
		        // System.out.println(this.meal.getName());
		        // System.out.println(this.meal.getRecipes().get(0).getName());
		        try {
		        	if (tempFileName.contains(".rcp")) {
		        		meal.addRecipe(Serializer.deserializeRecipe(tempFileName));
		        		recipeListModel.addElement(meal.getRecipes().get(meal.getRecipes().size() - 1).getName());
		        	}
		        } catch (IOException | ClassNotFoundException ia) {
		        	ia.printStackTrace();
		        }
	        }
	    } else if (e.getSource() == deleteRecipeButton) {
	    	int index = this.jlistModel.getSelectedIndex();
	        recipeListModel.remove(index);
	        this.meal.getRecipes().remove(index);
	    } else if (e.getSource() == openButton) {
	    	int returnVal = fileChooser.showOpenDialog(MealEditor.this);
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
		        String tempFileName = file.getName();
		        // String fileName = tempFileName.substring(0, tempFileName.length() - 4);
		        try {
		        	if (tempFileName.contains(".mel")) {
		        		this.meal = Serializer.deserializeMeal(tempFileName);
		        		this.recipeListModel.removeAllElements();
		        	}
		        	System.out.println(meal.getRecipes().size());
		        	for (int i = 0; i < meal.getRecipes().size(); i++) {
		        		this.recipeListModel.addElement(meal.getRecipes().get(i).getName());
		        	}
		        } catch (IOException | ClassNotFoundException ia) {
		        	
		        }
	        }
	    } else if (e.getSource() == newButton) {
	        this.meal = new Meals("", new ArrayList<Recipes>());	
	        
	    } else if (e.getSource() == saveButton) {
				try {
					Serializer.serializeMeal(this.meal);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
	    } else if (e.getSource() == saveAsButton) {
			File newFile = new File(this.meal.getName() + ".mel");
	        fileChooser.setSelectedFile(newFile);
    		int returnVal = fileChooser.showSaveDialog(MealEditor.this);
    		try {
				Serializer.serializeMeal(fileChooser.getCurrentDirectory().toString(), 
						meal);
				System.out.println(fileChooser.getCurrentDirectory().toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    } else if (e.getSource() == closeButton) {
	        this.dispose();
	    } else if (e.getSource() == nameBox) {
	    	meal.setName(nameBox.getText());
	    }
	  }
	  
}
