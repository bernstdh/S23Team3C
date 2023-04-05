package recipe;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import app.*;
import steps.*;
import ingredients.*;
import utensil.*;
/**
 * GUI used to open, save, and edit recipes.
 * @author Mike Buckingham (gui components)
 */
public class RecipeEditor extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
 
  
  private JButton closeButton, newButton, 
          openButton, saveAsButton, saveButton;
  private JPanel buttonPanel, recipeAttributesPanel, recipePanel, topPanel;
  private JTextField numberServedBox, recipeNameBox;
  private IngredientPanel ingredientsPanel;
  
  private StepPanel stepsPanel;
  private String numberServed, recipeName;
  private UtensilPanel utensilsPanel;
 
 

  /**
   * Constructor for the RecipeEditor Window.
   */
  public RecipeEditor()
  {
    super("KiLowBites Recipe Editor");
    this.setLayout(new BorderLayout());
    this.setSize(new Dimension(600, 800));
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    buildButtonPanel();
    buildRecipeAttributesPanel();
    
    topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(2, 1));
    topPanel.add(buttonPanel);
    topPanel.add(recipeAttributesPanel);
    this.add(topPanel, BorderLayout.NORTH);
    
    recipePanel = new JPanel();
    recipePanel.setLayout(new GridLayout(3, 1));
    
    ingredientsPanel = new IngredientPanel();
    stepsPanel = new StepPanel();
    utensilsPanel = new UtensilPanel();
    
    ingredientsPanel.setStepsPanel(stepsPanel);
    utensilsPanel.setStepsPanel(stepsPanel);
    
    recipePanel.add(utensilsPanel);
    recipePanel.add(ingredientsPanel);
    recipePanel.add(stepsPanel);
    
    this.add(recipePanel, BorderLayout.CENTER);
    this.setVisible(true);
  }
  
  /**
   * Processes top row button inputs.
   * @param ae ActionEvent
   */
  public void actionPerformed(final ActionEvent ae) 
  {
    if(ae.getSource() == closeButton)
    {
      this.dispose();
    }
    else if(ae.getSource() == openButton)
    {
      
    }
    else if(ae.getSource() == newButton)
    {
      
    }
    else if(ae.getSource() == saveAsButton)
    {
      
    }
    else if(ae.getSource() == saveButton)
    {
      List<Utensils> utensilList;
      List<Ingredient> ingredientList;
      List<Steps> stepsList;
      recipeName = recipeNameBox.getText();
      numberServed = numberServedBox.getText();
      int serves;
      try
      {
        serves = Integer.parseInt(numberServed);
      }
      catch(NumberFormatException nfe)
      {
        serves = 0;
      }
      
      utensilList = utensilsPanel.getUtensilList();
      ingredientList = ingredientsPanel.getIngredientList();
      stepsList = new ArrayList<>();
      
      Recipes r = new Recipes(recipeName, serves, ingredientList, utensilList, stepsList);
      try
      {
        Serializer.serializeRecipe(r);
      }
      catch (IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      
    }
  }
  // GUI  helper methods
  private void buildButtonPanel()
  {
    final Dimension buttonSize;
    buttonSize = new Dimension(30, 30);
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
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
    
    buttonPanel.add(newButton);
    buttonPanel.add(openButton);
    buttonPanel.add(saveButton);
    buttonPanel.add(saveAsButton);
    buttonPanel.add(closeButton);
  }
  
  private void buildRecipeAttributesPanel()
  {
    JLabel recipeNameLabel, numberServedLabel;
    recipeAttributesPanel = new JPanel();
    recipeAttributesPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    recipeNameLabel = new JLabel("Name:");
    recipeNameBox = new JTextField();
    recipeNameBox.setPreferredSize(new Dimension(220, 20));
    recipeAttributesPanel.add(recipeNameLabel);
    recipeAttributesPanel.add(recipeNameBox);
 
    numberServedLabel = new JLabel("Serves:" );
    numberServedBox = new JTextField();
    numberServedBox.setPreferredSize(new Dimension(60, 20));
    recipeAttributesPanel.add(numberServedLabel);
    recipeAttributesPanel.add(numberServedBox);
  }
}
