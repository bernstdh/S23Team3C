package recipe;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.util.List;

import app.*;
import steps.*;
import ingredients.*;
import utensil.*;
/**
 * GUI used to open, save, and edit recipes.
 * @author Mike Buckingham (gui components)
 */
public class RecipeEditor extends JFrame implements ActionListener, KeyListener
{
  
  private static final long serialVersionUID = 1L;
  private static final String RECIPE = ".rcp";
  
  
  private JButton closeButton, newButton, 
          openButton, saveAsButton, saveButton;
  private JFileChooser fileChooser;
  private JPanel buttonPanel, recipeAttributesPanel, recipePanel, topPanel;
  private JTextField numberServedBox, recipeNameBox;
  private IngredientPanel ingredientsPanel;
  private Recipes recipe;
  private StepPanel stepsPanel;
  private String numberServed, recipeName, state;
  private final String changedState = "changedState";
  private final String unchangedState = "unchangedState";
  private final String nullState = "nullState";
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
    
    ingredientsPanel = new IngredientPanel(this);
    
    utensilsPanel = new UtensilPanel(this);
    stepsPanel = new StepPanel
    (ingredientsPanel.getIngredientList(), utensilsPanel.getUtensilList(), this);
    
    ingredientsPanel.setStepsPanel(stepsPanel);
    utensilsPanel.setStepsPanel(stepsPanel);
    
    recipePanel.add(utensilsPanel);
    recipePanel.add(ingredientsPanel);
    recipePanel.add(stepsPanel);
    
    
    fileChooser = new JFileChooser();
    this.state = nullState;
    updateButtonStates();
    recipe = null;
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
      this.state = nullState;
      updateButtonStates();
      this.dispose();
    }
    else if(ae.getSource() == openButton)
    {
      this.state = unchangedState;
      updateButtonStates();
      int returnVal = fileChooser.showOpenDialog(RecipeEditor.this);
      if(returnVal == JFileChooser.APPROVE_OPTION)
      {
        File file = fileChooser.getSelectedFile();
        String tempFileName = file.getName();
        try
        {
          if(tempFileName.contains(RECIPE))
          {
            this.recipe = Serializer.deserializeRecipe(tempFileName);
            //this. clear (will clear every field eventually)
          }
          this.reset();
          this.loadFromRecipe(recipe);
          //add attributes to their respective list models.
        }
        catch(IOException | ClassNotFoundException ia )
        {
          System.out.println("Did not select .rcp file");
        }
        
      }
      else
      {//have to fix something here i think, has to go back to whatever state it was before
        this.state = nullState;
        updateButtonStates();
      }
    }
    else if(ae.getSource() == newButton)
    {
      this.state = nullState;
      updateButtonStates();
      recipe = null;
      this.reset();
    }
    else if(ae.getSource() == saveAsButton)
    {
      this.state = unchangedState;
      updateButtonStates();
      File newFile = new File(recipeNameBox.getText() + RECIPE);
      fileChooser.setSelectedFile(newFile);
      fileChooser.showSaveDialog(RecipeEditor.this);
      
      try
      {
        Serializer.serializeRecipe(fileChooser.getCurrentDirectory().toString(), recipe);
      }
      catch(IOException ioe)
      {
        ioe.printStackTrace();
      }
    }
    else if(ae.getSource() == saveButton)
    {
      this.state = unchangedState;
      updateButtonStates();
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
      stepsList = stepsPanel.getStepsList();
      
      
      recipe = new Recipes(recipeName, serves, ingredientList, utensilList, stepsList);
      try
      {
        Serializer.serializeRecipe(recipe);
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
    numberServedBox.addKeyListener(this);
    recipeAttributesPanel.add(numberServedLabel);
    recipeAttributesPanel.add(numberServedBox);
  }

  
  @Override
  public void keyTyped(final KeyEvent ke)
  {
    
  }

  @Override
  public void keyPressed(final KeyEvent ke)
  {
  }

  @Override
  public void keyReleased(final KeyEvent ke)
  {
  }
  
  private void updateButtonStates() 
  {
    newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
    openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
    saveButton.setEnabled(state.equals(changedState));
    saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
    closeButton.setEnabled(state.equals(unchangedState));
  }
  
  /**
   * Resets the recipe editor to its default state.
   */
  public void reset()
  {
    recipeNameBox.setText("");
    numberServedBox.setText("");
    utensilsPanel.reset();
    ingredientsPanel.reset();
    stepsPanel.reset();
  }
  
  /**
   * Loads in the recipe onto gui on opening.
   * @param r RecipeEditor's recipe attribute.
   */
  private void loadFromRecipe(final Recipes r)
  {
    for(Ingredient i : r.getIngredients()) 
    {
      ingredientsPanel.load(i);
    }
    for(Utensils u : r.getUtensils()) 
    {
      utensilsPanel.load(u);
    }
    for(Steps s : r.getSteps()) 
    {
      stepsPanel.load(s);
    }
    stepsPanel.updateBoxes();
  }
  
  /**
   * Used to set the state to changed.
   */
  public void setChanged() 
  {
    this.state = changedState;
    updateButtonStates();
  }

}
