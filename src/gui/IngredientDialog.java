package gui;

import javax.swing.*;

import items.IngredientTable;
import items.Ingredients;

import java.awt.*;

/**
 * Lets the user enter an ingredient with its information and adds that ingredient to the table.
 * @author Shaury Guatam, Beau Mueller
 *
 */
public class IngredientDialog extends JDialog
{

  private static final long serialVersionUID = 1L;
  private JTextField ingredientField;
  private JTextField densityField;
  private JTextField caloriesField;
  private String ingredient;
  private double density;
  private double calories;
  private JButton okButton;
  private JLabel error;

  /**
   * Lets the user create a new ingredient and add it to the existing table.
   * @param parent The parent window of the dialog box. (Most likely Recipe Editor)
   */
  public IngredientDialog(final JFrame parent)
  {
    super(parent, "Add Ingredient", true);
    setSize(400, 200);
    setLocationRelativeTo(parent);
    setResizable(false);

    setLayout(new BorderLayout());
    
    // Create a panel for all the inputs
    JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
    inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    add(inputPanel, BorderLayout.CENTER);

    JLabel ingredientLabel = new JLabel("Ingredient:");
    ingredientField = new JTextField();
    inputPanel.add(ingredientLabel);
    inputPanel.add(ingredientField);

    JLabel densityLabel = new JLabel("Density (g/ml):");
    densityField = new JTextField();
    inputPanel.add(densityLabel);
    inputPanel.add(densityField);

    JLabel caloriesLabel = new JLabel("Calories (cals/gram):");
    caloriesField = new JTextField();
    inputPanel.add(caloriesLabel);
    inputPanel.add(caloriesField);

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    error = new JLabel("");
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
    okButton = new JButton("OK");
    
    // Upon pressing the OK button, the system will validate the user's inputs.
    okButton.addActionListener(e ->
    {
      if (validateInputs())
      {
        dispose();
      }
    });
    buttonPanel.add(error);
    buttonPanel.add(okButton);
    add(buttonPanel, BorderLayout.SOUTH);

    setVisible(true);
  }

  /**
   * @return The ingredient name.
   */
  public String getIngredient()
  {
    return ingredient;
  }

  /**
   * @return The density (in g/ml) of the ingredient
   */
  public double getDensity()
  {
    return density;
  }

  /**
   * @return The calories (per gram) of the ingredient
   */
  public double getCalories()
  {
    return calories;
  }

  /**
   * Check to make sure that all information (name, density, calories) is readable by the system,
   * then creates an Ingredients object if it is in the correct format. 
   * @return False if inputs can't be read, true if they can.
   */
  private boolean validateInputs()
  {
    IngredientTable it = IngredientTable.createInstance();
    double tempDensity = -1;
    double tempCalories = -1;
    if (it.fromCode(ingredientField.getText()) != null)
    {
      error.setText("Please enter a unique ingredient name.");
      return false;
    }
    else
    {
      ingredient = ingredientField.getText();
    }
    try
    {
      tempDensity = Double.valueOf(densityField.getText());
    }
    catch (NumberFormatException nfe)
    {
      tempDensity = -1;
    }
    try
    {
      tempCalories = Double.valueOf(caloriesField.getText());
    }
    catch (NumberFormatException nfe)
    {
      tempCalories = -1;
    }

    if (tempDensity <= 0)
    {
      densityField.setText("");
      error.setText("Please enter a valid density.");
      return false;
    }
    if (tempCalories <= 0)
    {
      caloriesField.setText("");
      error.setText("Please enter a valid calorie value.");
      return false;
    }
    density = tempDensity;
    calories = tempCalories;
    it.add(new Ingredients(ingredient, density, calories));
    return true;
  }
}
