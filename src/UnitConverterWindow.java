import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//import utilities.*;
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
  private JButton calc;
  private JButton reset;
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
  String[] units = {dr, g, oz, lbs, p, tsp, tbs, floz, cup,
      pt, qt, gal, ml};
  ArrayList<String> weight = new ArrayList<String>(
      Arrays.asList(dr, g, oz, lbs));
  ArrayList<String> volume = new ArrayList<String>(
      Arrays.asList(ml, p, tsp, tbs, floz, cup, pt, qt, gal));
  
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
    
    
    fromUnitsBox = new JComboBox<>(units);
    fromUnitsBox.addItemListener(this);
    
    toUnitsBox = new JComboBox<>(units);
    toUnitsBox.addItemListener(this);
    
    Double[] amounts = {0.25, 0.5, 1.0, 1.5, 2.0, 10.0};
    amountBox = new JComboBox<>(amounts);
    amountBox.addItemListener(this);
    
    amountLabel = new JLabel("To Amount:");
    
    calc = new JButton(new ImageIcon("calculate.png"));
    reset = new JButton(new ImageIcon("reset.png"));
    reset.addItemListener(this);
    
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//    panel.add(calc);
//    panel.add(reset);
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
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
    setResizable(false);
    setSize(600, 200);
  }
  
  /**
   * Overridden method.
   * @param e ItemEvent
   */
  public void itemStateChanged(final ItemEvent e)
  {
    String ingredient = "";
    String fromUnit = (String) fromUnitsBox.getSelectedItem();
    String toUnit = (String) toUnitsBox.getSelectedItem();
    boolean weight1 = false;
    boolean weight2 = false;
    boolean vol1 = false;
    boolean vol2 = false;
    
    if (weight.contains(fromUnit)) weight1 = true;
    if (weight.contains(toUnit)) weight2 = true;
    if (volume.contains(fromUnit)) vol1 = true;
    if (volume.contains(toUnit)) vol2 = true;
    
    if (weight1 && weight2) ingredientsBox.setEnabled(false);
    else if (vol1 && vol2) ingredientsBox.setEnabled(false);
    if (weight1 && vol2) ingredientsBox.setEnabled(true);
    if (vol1 && weight2) ingredientsBox.setEnabled(true);
    ingredient = (String) ingredientsBox.getSelectedItem();
    
    double amount = (double) amountBox.getSelectedItem();
    
//    calc.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(final ActionEvent e)
//      {
//        converter(ingredient, fromUnit, toUnit, amount);
//      }
//    });
    double newAmount = converter(ingredient, fromUnit, toUnit, amount);
    amountLabel.setText(String.format("To Amount: %f", newAmount));
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
        UnitConversion.dramsConversions(ingredient, toUnit, amount);
    else if (fromUnit.equals(g)) newAmount = 
        UnitConversion.gramsConversions(ingredient, toUnit, amount);
    else if (fromUnit.equals(oz)) newAmount = 
        UnitConversion.ozConversions(ingredient, toUnit, amount);
    else if (fromUnit.equals(lbs)) newAmount = 
        UnitConversion.lbsConversions(ingredient, toUnit, amount);
    else if (fromUnit.equals(p)) newAmount = 
        UnitConversion.pinchesConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(tsp)) newAmount = 
        UnitConversion.tspConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(tbs)) newAmount = 
        UnitConversion.tbsConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(floz)) newAmount = 
        UnitConversion.flozConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(cup)) newAmount = 
        UnitConversion.cupConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(pt)) newAmount = 
        UnitConversion.ptConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(qt)) newAmount = 
        UnitConversion.qtConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(gal)) newAmount = 
        UnitConversion.galConversion(ingredient, toUnit, amount);
    else if (fromUnit.equals(ml)) newAmount = 
        UnitConversion.mlConversion(ingredient, toUnit, amount);
    return newAmount;
  }
  
  /**
   * temp Main
   */
  public static void main(String args[])
  {
    new UnitConverterWindow();
  }

}
