import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utilities.*;
/**
 * The window for the unit converter.
 * @author Trace Jones
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code.
 */
public class UnitConverterWindow extends JFrame implements ItemListener
{
  private static final long serialVersionUID = 1L;
  
  private JComboBox<String> fromUnitsBox;
  private JComboBox<String> toUnitsBox;
  private JComboBox<String> ingredientsBox;
  private JComboBox<Double> amountBox;
  private JLabel amountLabel;
  
  private String dr = "dr";
  private String oz = "oz";
  private String lbs = "lbs";
  private String g = "g";
  private String p = "p";
  private String tsp = "tsp";
  private String tbs = "tbs";
  private String floz = "floz";
  private String cup = "cup";
  private String pt = "pt";
  private String qt = "qt";
  private String gal = "gal";
  private String ml = "ml";
  
  public UnitConverterWindow()
  {
    super("Unit Converter");
    Ingredients[] ingredient = Ingredients.values();
    
    ingredientsBox = new JComboBox<>();
    for (int i = 0; i < ingredient.length; i++)
    {
      ingredientsBox.addItem(ingredient[i].getIngredientName());
    }
    ingredientsBox.addItemListener(this);
    
    String[] units = {dr, g, oz, lbs, p, tsp, tbs, floz, cup,
        pt, qt, gal, ml};
    fromUnitsBox = new JComboBox<>(units);
    fromUnitsBox.addItemListener(this);
    
    toUnitsBox = new JComboBox<>(units);
    toUnitsBox.addItemListener(this);
    
    Double[] amounts = {0.25, 0.5, 1.0, 1.5, 2.0};
    amountBox = new JComboBox<>(amounts);
    amountBox.addItemListener(this);
    
    amountLabel = new JLabel("To Amount:");
    
    JPanel panel = new JPanel(new FlowLayout());
    panel.add(new JLabel("From Units:"));
    panel.add(fromUnitsBox);
    panel.add(new JLabel("To Units:"));
    panel.add(toUnitsBox);
    panel.add(new JLabel("Ingredient:"));
    panel.add(ingredientsBox);
    panel.add(new JLabel("From Amount: "));
    panel.add(amountBox);
    panel.add(amountLabel);
    add(panel);
    
    setSize(400, 100);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setResizable(false);
    setSize(600, 150);
  }
  
  /**
   * Overridden method.
   * @param e ItemEvent
   */
  public void itemStateChanged(final ItemEvent e)
  {
    String fromUnit = (String) fromUnitsBox.getSelectedItem();
    String toUnit = (String) toUnitsBox.getSelectedItem();
    String ingredient = (String) ingredientsBox.getSelectedItem();
    double amount = (double) amountBox.getSelectedItem();
    
    double newAmount = converter(ingredient, fromUnit, toUnit, amount);
    
    amountLabel.setText("To Amount: " + newAmount);
  }
  
  /**
   * Helper method to get the newAmount.
   * @param ingredient - the ingredient being used.
   * @param fromUnit - the unit the ingredient is already in.
   * @param toUnit - the unit the user wants the ingredient in.
   * @param amount - the amount in the current unit.
   * @return the amount in the new unit.
   */
  private double converter(final String ingredient, final String fromUnit,
      final String toUnit, final double amount)
  {
    double newAmount = -1.0;
    if (fromUnit.equals(dr)) newAmount = 
        UnitConversion.dramsConversions(toUnit, amount);
    else if (fromUnit.equals(g)) newAmount = 
        UnitConversion.gramsConversions(toUnit, amount);
    else if (fromUnit.equals(oz)) newAmount = 
        UnitConversion.ozConversions(toUnit, amount);
    else if (fromUnit.equals(lbs)) newAmount = 
        UnitConversion.lbsConversions(toUnit, amount);
    else if (fromUnit.equals(p)) newAmount = 
        UnitConversion.pinchesConversion(toUnit, amount);
    else if (fromUnit.equals(tsp)) newAmount = 
        UnitConversion.tspConversion(toUnit, amount);
    else if (fromUnit.equals(tbs)) newAmount = 
        UnitConversion.tbsConversion(toUnit, amount);
    else if (fromUnit.equals(floz)) newAmount = 
        UnitConversion.flozConversion(toUnit, amount);
    else if (fromUnit.equals(cup)) newAmount = 
        UnitConversion.cupConversion(toUnit, amount);
    else if (fromUnit.equals(pt)) newAmount = 
        UnitConversion.ptConversion(toUnit, amount);
    else if (fromUnit.equals(qt)) newAmount = 
        UnitConversion.qtConversion(toUnit, amount);
    else if (fromUnit.equals(gal)) newAmount = 
        UnitConversion.galConversion(toUnit, amount);
    else if (fromUnit.equals(ml)) newAmount = 
        UnitConversion.mlConversion(toUnit, amount);
    return newAmount;
  }

}
