package gui;

import javax.swing.*;

import app.languageField;
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
  private JTextField ingredientField, densityField, caloriesField, individualField;
  private JPanel ingredientPanel, densityPanel, caloriesPanel, individualPanel;
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
    super(parent, languageField.STRINGS.getString("addIng"), true);
    setSize(350, 200);
    setLocationRelativeTo(parent);
    setResizable(true);

    GridLayout gl = new GridLayout(5, 0);
    gl.setHgap(3);
    setLayout(gl); 
    // Create a panel for all the inputs

    JLabel ingredientLabel = new JLabel(languageField.STRINGS.getString("ing"));
    ingredientPanel = new JPanel();
    ingredientPanel.setLayout(new GridLayout(0, 2));
    ingredientField = new JTextField(10);
    ingredientPanel.add(ingredientLabel);
    ingredientPanel.add(ingredientField);
    add(ingredientPanel, 0);
    

    JLabel densityLabel = new JLabel(languageField.STRINGS.getString("density"));
    densityField = new JTextField(10);
    densityPanel = new JPanel();
    densityPanel.setLayout(new GridLayout(0, 2));
    densityPanel.add(densityLabel);
    densityPanel.add(densityField);
    add(densityPanel, 1);

    JLabel caloriesLabel = new JLabel(languageField.STRINGS.getString("calories"));
    caloriesField = new JTextField(10);
    caloriesPanel = new JPanel();
    caloriesPanel.setLayout(new GridLayout(0, 2));
    caloriesPanel.add(caloriesLabel);
    caloriesPanel.add(caloriesField);
    add(caloriesPanel, 2);
    
    JLabel individualLabel = new JLabel(languageField.STRINGS.getString("gramsPer"));
    individualField = new JTextField(10);
    individualPanel = new JPanel();
    individualPanel.setLayout(new GridLayout(0, 2));
    individualPanel.add(individualLabel);
    individualPanel.add(individualField);
    add(individualPanel, 3);
    

    JPanel buttonPanel = new JPanel(new GridLayout(0, 2));
    error = new JLabel("");
    okButton = new JButton(languageField.STRINGS.getString("confirm"));
    buttonPanel.setLayout(new FlowLayout());
    buttonPanel.add(okButton);
    buttonPanel.add(error);
    add(buttonPanel, 4);
    
    // Upon pressing the OK button, the system will validate the user's inputs.
    okButton.addActionListener(e ->
    {
      if (validateInputs())
      {
        dispose();
      }
    });
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
    double tempIndividual = -1;
    boolean useInd = false;
    // Try getting the ingredient, given the text isn't null or of length 0.
    if (it.fromCode(ingredientField.getText()) != null)
    {
      error.setText(languageField.STRINGS.getString("ingErr2"));
      return false;
    }
    if (ingredientField.getText().length() == 0) 
    {
      error.setText(languageField.STRINGS.getString("ingErr1"));
      return false;
    }
    else
    {
      ingredient = ingredientField.getText();
    }
    // Try setting the density.
    try
    {
      tempDensity = Double.valueOf(densityField.getText());
    }
    catch (NumberFormatException nfe)
    {
      tempDensity = -1;
    }
    
    // Try setting the calories.
    try
    {
      tempCalories = Double.valueOf(caloriesField.getText());
    }
    catch (NumberFormatException nfe)
    {
      tempCalories = -1;
    }

    /*
     * Try setting the individual grams. If it's NaN set to -1
     */
    if(caloriesField.getText() != null) 
    {
      try
      {
        tempIndividual = Double.valueOf(caloriesField.getText());
      } catch (NumberFormatException nfe) 
      {
        tempIndividual = -1;
      }
    }
    if (tempDensity < 0)
    {
      densityField.setText("");
      error.setText(languageField.STRINGS.getString("densErr"));
      return false;
    }
    if (tempCalories < 0)
    {
      caloriesField.setText("");
      error.setText(languageField.STRINGS.getString("calsErr"));
      return false;
    }
    if (tempIndividual < 0 && individualField.getText().length() < 1) 
    {
      useInd = false;
    } else 
    {
      useInd = true;
    }
    density = tempDensity;
    calories = tempCalories;
    if(!useInd) 
    {
      it.add(new Ingredients(ingredient, density, calories));
    } else 
    {
      it.add(new Ingredients(ingredient, density, calories, tempIndividual));
    }
    return true;
  }
}
