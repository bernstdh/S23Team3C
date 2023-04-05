import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Listener class for an IngredientPanel.
 * @author Mike Buckingham
 *
 */
public class IngredientPanelListener implements ActionListener
{
  public static final String NEWLINE = "\n";
  private JComboBox<String> ingredientsUnitsBox;
  private List<Ingredient> ingredientList;
  private JTextArea ingredientsTextArea;
  private JTextField ingredientsAmountBox, ingredientsDetailsBox, ingredientsNameBox;
  
  /**
   * Constructor for an ingredientPanelListener.
   * @param iab ingredientsAmountBox
   * @param idb ingredientsDetailsBox
   * @param il  ingredientsLIst
   * @param inb ingredientsNameBox
   * @param ita ingredientsTextArea
   * @param iub ingredientsUnitsBox
   */
  public IngredientPanelListener(final JTextField iab, final JTextField idb, 
      final List<Ingredient> il, final JTextField inb, final JTextArea ita, 
      final JComboBox<String> iub)
  {
    this.ingredientsAmountBox = iab;
    this.ingredientsDetailsBox = idb;
    this.ingredientList = il;
    this.ingredientsNameBox = inb;
    this.ingredientsTextArea = ita;
    this.ingredientsUnitsBox = iub;
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
      System.out.println(ingredientName);
      i = Ingredients.fromCode(ingredientName);
      System.out.println(i);
      details = ingredientsDetailsBox.getText();
      unit = (String)ingredientsUnitsBox.getSelectedItem();

      ingredient = new Ingredient(i, details, amount, unit);
      formattedIngredient = String.format(
          Formatter.INGREDIENT, amount, unit, details, ingredient.getName());
      ingredientList.add(ingredient);
      ingredientsTextArea.setText(ingredientsTextArea.getText() + formattedIngredient + NEWLINE);
      System.out.println(ingredientList.size());
    }
    else if(command.equals("Delete"))
    {

      if(ingredientList.size() > 0) 
      {
        String[] textAreaLines;
        textAreaLines = ingredientsTextArea.getText().split(NEWLINE);
        ingredientList.remove(ingredientList.size() - 1);
        ingredientsTextArea.setText("");
        for(int i = 0; i < textAreaLines.length - 1; i++) 
        {
          ingredientsTextArea.setText(ingredientsTextArea.getText() + textAreaLines[i] + NEWLINE);
        }   
        System.out.println(ingredientList.size());
      }
 
    }
  }
}
