package steps;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import ingredients.*;

/**
 * A JPanel used to construct and store steps of a recipe.
 * @author Mike Buckingham
 *
 */
public class StepPanel extends JPanel implements ActionListener
{
  private static final long serialVersionUID = 1L;
  private static final String ADD = "Add";
  private static final String DELETE = "Delete";
  
  private DefaultListModel<String> stepsListModel;
  private JButton stepsAddButton, stepsDeleteButton;
  private JComboBox<String> stepsActionBox, stepsOnBox, stepsUtensilBox;
  private JList<String> stepsJList;
  private JScrollPane stepsScrollPane;
  private JTextField stepsDetailsBox;
  private List<Steps> stepsObjectList;
  private List<Ingredient> ingredientObjectList;
  private StepsPanelListener stepsListener;

  
  /**
   * Constructor for a StepPanel object.
   */
  public StepPanel()
  {
    super();
    buildPanel();
    stepsObjectList = new ArrayList<>();
    stepsAddButton.addActionListener(this);
    stepsDeleteButton.addActionListener(this);
  }
  
  /**
   * Processes inputs for the add and delete buttons.
   * @param ae ActionEvent object.
   */
  public void actionPerformed(final ActionEvent ae)
  {
    String command;
    command = ae.getActionCommand();
    if(command.equals(ADD))
    {
      String action, destinationUtensil, details, formattedStep, sourceUtensil;
      action = (String)stepsActionBox.getSelectedItem();
      details = stepsDetailsBox.getText();
      sourceUtensil = (String)stepsOnBox.getSelectedItem();
      destinationUtensil = (String)stepsUtensilBox.getSelectedItem();
      
      System.out.println(sourceUtensil);
      if(destinationUtensil.equals(sourceUtensil)) 
      {
        formattedStep = String.format(Formatter.STEP_SINGLE, action, destinationUtensil, details);
      } 
      else if(" " + Ingredients.fromCode(sourceUtensil) != null) 
      {
        formattedStep = String.format(
            Formatter.STEP_INGREDIENT, action, sourceUtensil, destinationUtensil, details);
      } 
      else 
      {
        formattedStep = String.format(
            Formatter.STEP_MUL, action, sourceUtensil, destinationUtensil, details);
      }
      stepsListModel.addElement(formattedStep);
    }
    else if(command.equals(DELETE))
    {
      int[] indices = stepsJList.getSelectedIndices();
      for(int i = 0; i < indices.length; i++)
      {
        for(int j = 0; j < stepsListModel.size(); j++) 
        {
          if(j == indices[i]) 
          { 
            stepsListModel.remove(j);
//            stepsObjectList.remove(j);
            int k = i;
            while(k < indices.length)
            {
              indices[k]--;
              k++;
            }         
            break;
          }
        }
      }
    }
  }
  
  private void buildPanel()
  {
    JLabel stepsActionLabel, stepsOnLabel, stepsUtensilLabel, stepsDetailsLabel;

    this.setBorder(BorderFactory.createTitledBorder("Steps"));
    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    stepsActionLabel = new JLabel("Action:");
    stepsOnLabel = new JLabel("On:");
    stepsUtensilLabel = new JLabel("Utensil:");
    stepsDetailsLabel = new JLabel("Details");
    
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
    stepsActionBox.addItem("heat");
    stepsActionBox.addItem("ignite");
    stepsActionBox.addItem("melt");
    stepsActionBox.addItem("put");
    stepsActionBox.addItem("saute");
    stepsActionBox.addItem("sear");
    stepsActionBox.addItem("simmer");
    
    
    stepsOnBox = new JComboBox<>();
    stepsOnBox.setPreferredSize(new Dimension(60, 20));
    stepsOnBox.setEditable(false);
    stepsUtensilBox = new JComboBox<>();
    stepsUtensilBox.setPreferredSize(new Dimension(90, 20));
    stepsUtensilBox.setEditable(false);
    stepsDetailsBox = new JTextField();
    stepsDetailsBox.setPreferredSize(new Dimension(90, 20));
    
    stepsListModel = new DefaultListModel<String>();

    stepsJList = new JList<>(stepsListModel);
    stepsJList.setPreferredSize(new Dimension(400, 300));
   
    stepsScrollPane = new JScrollPane(stepsJList);
    stepsScrollPane.setPreferredSize(new Dimension(400, 150));
    stepsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    stepsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    stepsAddButton = new JButton(ADD);
    stepsDeleteButton = new JButton(DELETE);
    
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
   * @param ingredientsModel object
   * @param utensilModel object
   */
  public void updateBoxes(final DefaultListModel<String> ingredientsModel, 
      final DefaultListModel<String> utensilModel) 
  {
    if(ingredientsModel != null)
    {
      stepsOnBox.removeAllItems();
      for(int i = 0; i < ingredientsModel.size(); i++)
      {
        String ingredientString;
        ingredientString = ingredientsModel.get(i);
        stepsOnBox.addItem(ingredientString.substring(
            ingredientString.lastIndexOf(" "), ingredientString.length()));
      }
      for(int j = 0; j < stepsUtensilBox.getItemCount(); j++) 
      {
        stepsOnBox.addItem(stepsUtensilBox.getItemAt(j));
      }
    }
    if(utensilModel != null)
    { 
      stepsOnBox.removeAllItems();
      stepsUtensilBox.removeAllItems();
      for(int i = 0; i < utensilModel.size(); i++)
      {
        stepsOnBox.addItem(utensilModel.get(i));
        stepsUtensilBox.addItem(utensilModel.get(i));
      }
    }
  }
  

}
