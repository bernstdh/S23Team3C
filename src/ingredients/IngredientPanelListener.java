package ingredients;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;

import steps.*;
/**
 * Listener class for an IngredientPanel.
 * @author Mike Buckingham
 *
 */
public class IngredientPanelListener implements ActionListener
{
  public static final String NEWLINE = "\n";
  
  private DefaultListModel<String> ingredientListModel;
  private JComboBox<String> ingredientsUnitsBox;
  private List<Ingredient> ingredientObjectList;
  private JList<String> ingredientJList;
  private JTextField ingredientsAmountBox, ingredientsDetailsBox, ingredientsNameBox;
  private StepPanel stepsPanel;
  
  /**
   * Constructor for an ingredientPanelListener.
   * @param iab ingredientsAmountBox
   * @param idb ingredientsDetailsBox
   * @param iol  ingredientsObjectList
   * @param inb ingredientsNameBox
   * @param ijl ingredientsJList
   * @param iub ingredientsUnitsBox
   * @param ilm ingredientsListModel
   */
  public IngredientPanelListener(final JTextField iab, final JTextField idb, 
      final List<Ingredient> iol, final JTextField inb, final JList<String>ijl, 
      final JComboBox<String> iub, final DefaultListModel<String> ilm)
  {
    this.ingredientsAmountBox = iab;
    this.ingredientsDetailsBox = idb;
    this.ingredientObjectList = iol;
    this.ingredientsNameBox = inb;
    this.ingredientJList = ijl;
    this.ingredientsUnitsBox = iub;
    this.ingredientListModel = ilm;
  }
  
  /**
   * Handles button input and text output.
   * @param ae ActionEvent object.
   */
  public void actionPerformed(final ActionEvent ae) 
  {
    String command, formattedIngredient;
    command = ae.getActionCommand();
    if(command.equals("Add"))
    {
      double amount;
      Ingredients i;
      Ingredient ingredient;
      String details, ingredientName, unit;
      
      try
      {
        amount = Double.parseDouble(ingredientsAmountBox.getText());
      }
      catch(NumberFormatException nfe)
      {
        amount = -1.0;
      }
      ingredientName = ingredientsNameBox.getText();
      i = Ingredients.fromCode(ingredientName);
      details = ingredientsDetailsBox.getText();
      unit = (String)ingredientsUnitsBox.getSelectedItem();
      ingredient = new Ingredient(i, details, amount, unit);
      formattedIngredient = String.format(
          Formatter.INGREDIENT, amount, unit, details, ingredient.getName());
      
      ingredientObjectList.add(ingredient);
      ingredientListModel.addElement(formattedIngredient);

    }
    else if(command.equals("Delete"))
    {
      int[] indices = ingredientJList.getSelectedIndices();
      for(int i = 0; i < indices.length; i++)
      {
        for(int j = 0; j < ingredientListModel.size(); j++) 
        {
          if(j == indices[i]) 
          { 
            ingredientListModel.remove(j);
            ingredientObjectList.remove(j);
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
    stepsPanel.updateBoxes(ingredientListModel, null);
  }
  
  /**
   * sets the StepsPanel object.
   * 
   * @param sp StepsPanel
   */
  public void setStepsPanel(final StepPanel sp)
  {
    this.stepsPanel = sp;
  }
}
