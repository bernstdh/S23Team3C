package gui;
import javax.swing.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.languageField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import items.Ingredient;
import items.Steps;
import items.Utensils;

/**
 * A JPanel used to construct and store steps of a recipe.
 * @author Mike Buckingham
 *
 */
public class StepPanel extends JPanel implements ActionListener, ListSelectionListener
{
  private static final long serialVersionUID = 1L;
  
  private DefaultListModel<String> stepsListModel;
  private JButton stepsAddButton, stepsDeleteButton;
  private JComboBox<String> stepsActionBox, stepsOnBox, stepsUtensilBox;
  private JList<String> stepsJList;
  private JScrollPane stepsScrollPane;
  private JTextField stepsDetailsBox;
  private List<Steps> stepsList;
  private List<Ingredient> ingredientList;
  private List<Utensils> utensilList;
  private RecipeEditor recipeEditor;

  
  /**
   * Constructor for a StepPanel object.
   * @param il List of Ingredient objects
   * @param ul List of Utensils objects
   * @param re RecipeEditor object
   */
  public StepPanel(final List<Ingredient> il, final List<Utensils> ul, final RecipeEditor re)
  {
    super();
    buildPanel();
    stepsList = new ArrayList<>();
    stepsAddButton.addActionListener(this);
    stepsDeleteButton.addActionListener(this);
    stepsJList.addListSelectionListener(this);
    this.ingredientList = il;
    this.utensilList = ul;
    this.recipeEditor = re;
  }
  
  /**
   * Processes inputs for the add and delete buttons.
   * @param ae ActionEvent object.
   */
  public void actionPerformed(final ActionEvent ae)
  {
    
    if(ae.getSource() == stepsOnBox || ae.getSource() == stepsUtensilBox)
    {
      if(stepsOnBox.getSelectedItem() != null && stepsUtensilBox.getSelectedItem() != null) 
        stepsAddButton.setEnabled(true);
      else stepsAddButton.setEnabled(false);
    } 
    if(ae.getSource() == stepsAddButton)
    {
      Steps step;
      Ingredient sourceIngredient;
      Utensils sourceUtensil, destinationUtensil;
      String action, details, sourceText, destinationText;
      
      sourceIngredient = null;
      sourceUtensil = null;
      destinationUtensil = null;
      action = (String)stepsActionBox.getSelectedItem();
      details = stepsDetailsBox.getText();

      sourceText = (String)stepsOnBox.getSelectedItem();
      destinationText = (String)stepsUtensilBox.getSelectedItem();
      
      for(Utensils u : utensilList)
      {
        if(destinationText.equals(u.toString())) destinationUtensil = u;
        if(sourceText.equals(u.toString())) sourceUtensil = u;
      }
      for(Ingredient i : ingredientList)
      {
        if(sourceText.equals(i.toString())) sourceIngredient = i;
      }
      
      if(sourceIngredient == null)
        step = new Steps(details, action, sourceUtensil, destinationUtensil);
      else
        step = new Steps(details, action, sourceIngredient, destinationUtensil);
      
      stepsList.add(step);
      if(step.getIngredientSource() != null)
      {
        stepsListModel.addElement(step.ingredientStepToString());
      }
      else
      {
        stepsListModel.addElement(step.utensilStepToString());
      }
      recipeEditor.setChanged();
      stepsDetailsBox.setText("");
    }
    else if(ae.getSource() == stepsDeleteButton)
    {
      int[] indices = stepsJList.getSelectedIndices();
      int numRemoved = 0;
      for(int i : indices) 
      {
        int index = i - numRemoved;
        String stepsString = stepsListModel.get(index);
        stepsListModel.removeElementAt(index);
        numRemoved++;
        for(Steps s: stepsList) 
        {
          if(s.getIngredientSource() != null && s.ingredientStepToString().equals(stepsString)) 
          {
            stepsList.remove(s);
            break;
          }
          else if(s.utensilStepToString().equals(stepsString))
          {
            stepsList.remove(s);
            break;
          }
        }
      }
      recipeEditor.setChanged();
    }
  }
  
  private void buildPanel()
  {
    JLabel stepsActionLabel, stepsOnLabel, stepsUtensilLabel, stepsDetailsLabel;

    this.setBorder(BorderFactory.createTitledBorder
        (languageField.STRINGS.getString("stepsBorderText")));
    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    stepsActionLabel = new JLabel(languageField.STRINGS.getString("actionBoxText"));
    stepsOnLabel = new JLabel(languageField.STRINGS.getString("onBoxText"));
    stepsUtensilLabel = new JLabel(languageField.STRINGS.getString("utensilBoxText"));
    stepsDetailsLabel = new JLabel(languageField.STRINGS.getString("details"));
    
    stepsActionBox = new JComboBox<>();
    stepsActionBox.setPreferredSize(new Dimension(80, 20));
    stepsActionBox.setEditable(false);
    
    stepsActionBox.addItem("air-fry");
    stepsActionBox.addItem("bake");
    stepsActionBox.addItem("boil");
    stepsActionBox.addItem("cook");
    stepsActionBox.addItem("dip");
    stepsActionBox.addItem("fry");
    stepsActionBox.addItem("drain");
    stepsActionBox.addItem("grill");
    stepsActionBox.addItem("heat");
    stepsActionBox.addItem("ignite");
    stepsActionBox.addItem("juice");
    stepsActionBox.addItem("melt");
    stepsActionBox.addItem("put");
    stepsActionBox.addItem("saute");
    stepsActionBox.addItem("sear");
    stepsActionBox.addItem("simmer");
    stepsActionBox.addItem("smoke");
    stepsActionBox.addItem("spread");
    stepsActionBox.addItem("toast");
    
    
    stepsOnBox = new JComboBox<>();
    stepsOnBox.setPreferredSize(new Dimension(60, 20));
    stepsOnBox.setEditable(false);
    stepsOnBox.addActionListener(this);

    stepsUtensilBox = new JComboBox<>();
    stepsUtensilBox.setPreferredSize(new Dimension(90, 20));
    stepsUtensilBox.setEditable(false);
    stepsUtensilBox.addActionListener(this);
    stepsDetailsBox = new JTextField();
    stepsDetailsBox.setPreferredSize(new Dimension(90, 20));
    
    stepsListModel = new DefaultListModel<String>();

    stepsJList = new JList<>(stepsListModel);
    stepsJList.setPreferredSize(new Dimension(400, 300));
   
    stepsScrollPane = new JScrollPane(stepsJList);
    stepsScrollPane.setPreferredSize(new Dimension(400, 150));
    stepsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    stepsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    stepsAddButton = new JButton(languageField.STRINGS.getString("add"));
    stepsAddButton.setEnabled(false);
    stepsDeleteButton = new JButton(languageField.STRINGS.getString("delete"));
    stepsDeleteButton.setEnabled(false);
    
    this.add(stepsActionLabel);
    this.add(stepsActionBox);
    this.add(stepsOnLabel);
    this.add(stepsOnBox);
    this.add(stepsUtensilLabel);
    this.add(stepsUtensilBox);
    this.add(stepsDetailsLabel);
    this.add(stepsDetailsBox);
    this.add(stepsAddButton);
    this.add(stepsScrollPane);
    this.add(stepsDeleteButton);
  }
  
  /**
   * Updates JComboBoxes when something is added or removed from the other panels.
   */
  public void updateBoxes() 
  {
    stepsOnBox.removeAllItems();
    stepsUtensilBox.removeAllItems();
    for(Utensils u : utensilList)
    {
      stepsOnBox.addItem(u.toString());
      stepsUtensilBox.addItem(u.toString());
    }
    for(Ingredient i : ingredientList)
    {
      stepsOnBox.addItem(i.toString());
    }
  }

  @Override
  public void valueChanged(final ListSelectionEvent e)
  {
    if(stepsJList.isSelectionEmpty()) stepsDeleteButton.setEnabled(false);
    else stepsDeleteButton.setEnabled(true);
    
  }
  
  /**
   * Returns the list of steps.
   * @return stepsList attribute.
   */
  public List<Steps> getStepsList()
  {
    return stepsList;
  }
  
  /**
   * Resets the stepPanel.
   */
  public void reset()
  {
    stepsOnBox.removeAllItems();
    stepsUtensilBox.removeAllItems();
    stepsDetailsBox.setText("");
    stepsListModel.removeAllElements();
    stepsList.clear();
  }
  
  /**
   * Enables or disables all non button components.
   * @param set used to enable or disable
   */
  public void setEnabledAll(final boolean set) 
  {
    stepsOnBox.setEnabled(set);
    stepsUtensilBox.setEnabled(set);
    stepsActionBox.setEnabled(set);
    stepsDetailsBox.setEnabled(set);
    stepsScrollPane.setEnabled(set);
  }
  
  /**
   * Loads in a steps object from an opened recipe.
   * @param s Steps object
   */
  public void load(final Steps s) 
  {
    stepsList.add(s);
    if(s.getIngredientSource() != null)
    {
      stepsListModel.addElement(s.ingredientStepToString());
    }
    else stepsListModel.addElement(s.utensilStepToString());
  }

}
