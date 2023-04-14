package ingredients;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import recipe.RecipeEditor;
import steps.*;

/**
 * A JPanel used to construct and store ingredients.
 * @author Mike Buckingham
 */
public class IngredientPanel extends JPanel 
    implements ActionListener, DocumentListener, ListSelectionListener
{
  private static final long serialVersionUID = 1L;
  private DefaultListModel<String> ingredientsListModel;

  private IngredientDialog id;
  private JButton ingredientsAddButton, ingredientsDeleteButton;
  private JComboBox<String> ingredientsUnitsBox;
  private JFrame ingredientDialogFrame;
  private JLabel ingredientsAmountLabel, ingredientsDetailsLabel, 
      ingredientsNameLabel, ingredientsUnitsLabel;
  private JList<String> ingredientsJList;
  private JScrollPane ingredientsScrollPane;
  
  

  private JTextField ingredientsAmountBox, ingredientsDetailsBox, ingredientsNameBox;
  private IngredientTable ingredientTable;
  private List<Ingredient> ingredientList;
  private RecipeEditor recipeEditor;
  private StepPanel stepPanel;
  /**
   * Constructor for an Ingredients Panel object.
   * @param re RecipeEditor object
   */
  public IngredientPanel(final RecipeEditor re) 
  {
    super();
    buildPanel();
    ingredientList = new ArrayList<>();
    ingredientTable = IngredientTable.createInstance();
    
    ingredientDialogFrame = new JFrame();
    ingredientDialogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ingredientDialogFrame.setSize(600, 600);
    this.recipeEditor = re;
  }
  
  private void buildPanel()
  {
    this.setBorder(BorderFactory.createTitledBorder("Ingredients"));
    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    //build JLabels
    ingredientsNameLabel = new JLabel("Name");
    ingredientsDetailsLabel = new JLabel("Details");
    ingredientsAmountLabel = new JLabel("Amount");
    ingredientsUnitsLabel = new JLabel("Units:");
    
    //build JTextFields
    ingredientsNameBox = new JTextField();
    ingredientsNameBox.setPreferredSize(new Dimension(80, 20));
    ingredientsNameBox.getDocument().addDocumentListener(this);
    ingredientsDetailsBox = new JTextField();
    ingredientsDetailsBox.setPreferredSize(new Dimension(60, 20));
    ingredientsAmountBox = new JTextField();
    ingredientsAmountBox.setPreferredSize(new Dimension(80, 20));
    ingredientsAmountBox.getDocument().addDocumentListener(this);
    
    //build the ingredients units box
    ingredientsUnitsBox = new JComboBox<>();
    ingredientsUnitsBox.setPreferredSize(new Dimension(100, 20));
    ingredientsUnitsBox.setEditable(false);
    ingredientsUnitsBox.addItem("cup");
    ingredientsUnitsBox.addItem("dr");
    ingredientsUnitsBox.addItem("floz");
    ingredientsUnitsBox.addItem("g");
    ingredientsUnitsBox.addItem("gal");
    ingredientsUnitsBox.addItem("individual");
    ingredientsUnitsBox.addItem("lbs");
    ingredientsUnitsBox.addItem("ml");
    ingredientsUnitsBox.addItem("oz");
    ingredientsUnitsBox.addItem("p");
    ingredientsUnitsBox.addItem("pt");
    ingredientsUnitsBox.addItem("qt");
    ingredientsUnitsBox.addItem("tbs");
    ingredientsUnitsBox.addItem("tsp");

    //build the add and delete buttons
    ingredientsAddButton = new JButton("Add");
    ingredientsAddButton.setEnabled(false);
    ingredientsAddButton.addActionListener(this);
    ingredientsDeleteButton = new JButton("Delete");
    ingredientsDeleteButton.setEnabled(false);
    ingredientsDeleteButton.addActionListener(this);
    
    //build JList and its JScrollPane
    ingredientsListModel = new DefaultListModel<>();
    ingredientsJList = new JList<>(ingredientsListModel);
    ingredientsJList.setPreferredSize(new Dimension(400, 300));
    ingredientsJList.addListSelectionListener(this);
    
    ingredientsScrollPane = new JScrollPane(ingredientsJList);
    ingredientsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    ingredientsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    ingredientsScrollPane.setPreferredSize(new Dimension(400, 150));
    
    //add all components
    this.add(ingredientsNameLabel);
    this.add(ingredientsNameBox);
    this.add(ingredientsDetailsLabel);
    this.add(ingredientsDetailsBox);
    this.add(ingredientsAmountLabel);
    this.add(ingredientsAmountBox);
    this.add(ingredientsUnitsLabel);
    this.add(ingredientsUnitsBox);
    this.add(ingredientsAddButton);
    this.add(ingredientsScrollPane);
    this.add(ingredientsDeleteButton);
  }
  
  /**
   * Returns DefaultListModel object.
   * @return ingredientsListModel
   */
  public DefaultListModel<String> getModel()
  {
    return ingredientsListModel;
  }
  
  /**
   * Sets the stepsPanel attribute.
   * @param sp StepPanel object
   */
  public void setStepsPanel(final StepPanel sp) 
  {
    this.stepPanel = sp;
  }
  
  /**
   * Returns ingredientList attribute.
   * @return ingredientList
   */
  public List<Ingredient> getIngredientList() 
  {
    return ingredientList;
  }

  @Override
  public void actionPerformed(final ActionEvent ae)
  {
    if(ae.getSource() == ingredientsAddButton)
    {
      double amount;
      Ingredients i;
      Ingredient ingredient;
      String details, ingredientName, unit;
      
      ingredientName = ingredientsNameBox.getText();
      i = ingredientTable.fromCode(ingredientName);
      if(i == null) 
      {
        id = new IngredientDialog(ingredientDialogFrame);
        ingredientDialogFrame.setVisible(true);
        
        String newIngredientName = id.getIngredient();
        ingredientTable.add(new Ingredients(newIngredientName, -1, -1));
        ingredientsNameBox.setText(newIngredientName);
        ingredientsAmountBox.setText(id.getAmount());
        
        
        ingredientDialogFrame.dispose();
        
      }

      try
      {
        amount = Double.parseDouble(ingredientsAmountBox.getText());
      }
      catch(NumberFormatException nfe)
      {
        amount = -1.0;
      }

      details = ingredientsDetailsBox.getText();
      unit = (String)ingredientsUnitsBox.getSelectedItem();
      if(i != null) 
      {
        ingredient = new Ingredient(i, details, amount, unit);

        ingredientList.add(ingredient);
        ingredientsListModel.addElement(ingredient.toString());
      }
      

    }
    else if(ae.getSource() == ingredientsDeleteButton)
    {
      int[] indices = ingredientsJList.getSelectedIndices();
      int numRemoved = 0;
      for(int i : indices) 
      {
        int index = i - numRemoved;
        String ingredientString = ingredientsListModel.get(index);
        ingredientsListModel.removeElementAt(index);
        numRemoved++;
        for(Ingredient ing: ingredientList) 
        {
          if(ing.toString().equals(ingredientString))
          {
            ingredientList.remove(ing);
            break;
          }
        }
      }
      
    }
    recipeEditor.setChanged();
    stepPanel.updateBoxes();
  }

  private void processTextChanges(final DocumentEvent e) 
  {
    boolean cantFormatAmount;
    try 
    {
      Double.valueOf(ingredientsAmountBox.getText());
      cantFormatAmount = false;
    } catch(NumberFormatException nfe) 
    {
      cantFormatAmount = true;
    }
    if(cantFormatAmount || ingredientsNameBox.getText().equals("") ) 
    {
      ingredientsAddButton.setEnabled(false);
    }
    else
    {
      ingredientsAddButton.setEnabled(true);
    }
  }
  @Override
  public void insertUpdate(final DocumentEvent e)
  {
    processTextChanges(e);
  }

  @Override
  public void removeUpdate(final DocumentEvent e)
  {
    processTextChanges(e);
  }

  @Override
  public void changedUpdate(final DocumentEvent e)
  {
    processTextChanges(e);
  }

  @Override
  public void valueChanged(final ListSelectionEvent e)
  {
    if(ingredientsJList.isSelectionEmpty()) ingredientsDeleteButton.setEnabled(false);
    else ingredientsDeleteButton.setEnabled(true);
  }
  
  /**
   * Resets the ingredientPanel.
   */
  public void reset()
  {
    ingredientsNameBox.setText("");
    ingredientsDetailsBox.setText("");
    ingredientsAmountBox.setText("");
    ingredientList.clear();
    ingredientsListModel.removeAllElements();
  }
  
  /**
   * Loads in a steps object from an opened recipe.
   * @param i Ingredients object
   */
  public void load(final Ingredient i) 
  {
    ingredientList.add(i);
    ingredientsListModel.addElement(i.toString());
  }
}
