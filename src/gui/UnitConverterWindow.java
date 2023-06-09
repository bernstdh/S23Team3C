package gui;
import javax.swing.*;

import app.languageField;
import items.IngredientTable;
import items.Ingredients;
import math.UnitConversion;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.*;
/**
 * The window for the unit converter.
 * @author Trace Jones, James Madison University
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code.
 */
public class UnitConverterWindow extends JFrame implements ActionListener, WindowListener
{
  static final String CALCULATE = "Calculate";
  static final String RESET = "Reset";
  private static final long serialVersionUID = 1L;
  private static boolean exists = false;
  private static UnitConverterWindow instance = null;
  
  private JComboBox<String> fromUnitsBox;
  private JComboBox<String> toUnitsBox;
  private JComboBox<String> ingredientsBox;
  private JTextField amountBox;
  private JButton calc;
  private JButton reset;
  private JLabel amountLabel;

  private String dr = "dr";
  private String oz = "oz";
  private String lb = "lb";
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
  private String ind = "individual";
  private String toAmount = "To Amount:";
  private String invalidUC = "To Amount: Please Enter a Valid Number.";
  private String negativeUC = "To Amount: Please Enter a Positive Number";
  private String frU = "From Units";
  private String tU = "To Units";
  private String in = "Ingredient";
  private String frA = "From Amount";
  private String indErrUC = "To Amount: Please Pick an Ingredient with an Individual Value.";
  String[] units = {dr, g, oz, lb, p, tsp, tbs, floz, cup,
      pt, qt, gal, ml, ind};
  ArrayList<String> weight = new ArrayList<String>(
      Arrays.asList(dr, g, oz, lb));
  ArrayList<String> volume = new ArrayList<String>(
      Arrays.asList(ml, p, tsp, tbs, floz, cup, pt, qt, gal));
  
  /**
   * The constructor for the UnitConverterWindow.
   */
  private UnitConverterWindow()
  {
    super("Unit Converter");
    addWindowListener(this);
    IngredientTable ingredients = IngredientTable.createInstance();
    
    ingredientsBox = new JComboBox<>();
    for (int i = 0; i < ingredients.size(); i++)
    {
      ingredientsBox.addItem(ingredients.get(i).getIngredientName());
    }
    ingredientsBox.addActionListener(this);
    
    
    fromUnitsBox = new JComboBox<>(units);
    fromUnitsBox.addActionListener(this);
    
    toUnitsBox = new JComboBox<>(units);
    toUnitsBox.addActionListener(this);

    amountBox = new JTextField(10);
    
    
    amountLabel = new JLabel(languageField.STRINGS.getString("toAmount"));
    
    calc =  createJButton("calculate.png", CALCULATE);
    reset = createJButton("reset.png", RESET);
    reset.addActionListener(this);

    JPanel panel = new JPanel(new GridLayout(2, 1));
    JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    upperPanel.add(calc);
    upperPanel.add(reset);
    lowerPanel.add(new JLabel(languageField.STRINGS.getString("frU") + ":"));
    lowerPanel.add(fromUnitsBox);
    lowerPanel.add(new JLabel(languageField.STRINGS.getString("tU") + ":"));
    lowerPanel.add(toUnitsBox);
    lowerPanel.add(new JLabel(languageField.STRINGS.getString("in") + ":"));
    lowerPanel.add(ingredientsBox);
    lowerPanel.add(new JLabel(languageField.STRINGS.getString("frA") + ": "));
    lowerPanel.add(amountBox);
    lowerPanel.add(amountLabel);
    panel.add(upperPanel, 0);
    panel.add(lowerPanel, 1);
    add(panel);
    
    setSize(400, 100);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
    setResizable(false);
    setSize(650, 200);
  }
  
  /**
   * Overridden method.
   * @param e ActionEvent
   */
  public void actionPerformed(final ActionEvent e) throws NumberFormatException
  {
    String ingredient = "";
    String fromUnit = (String) fromUnitsBox.getSelectedItem();
    String toUnit = (String) toUnitsBox.getSelectedItem();
    double amount = 0.0;
    double newAmount = 0.0;
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
    IngredientTable ingredients = IngredientTable.createInstance();
    Ingredients ing = ingredients.fromCode(ingredient);
    if (fromUnit.equals(ind) || toUnit.equals(ind)) ingredientsBox.setEnabled(true);
  
    if (amountBox.getText().equals("")) amount = 0.0;
    
    if (e.getSource() == calc)
    {
      try
      {
        amount = Double.parseDouble(amountBox.getText());
        if (amount < 0) amountLabel.setText(languageField.STRINGS.getString("negativeUC"));
        else
        {
          if (ing.getIndividualGrams() == -1.0 && (fromUnit.equals(ind) || toUnit.equals(ind)))
            amountLabel.setText(languageField.STRINGS.getString("indErrUC"));
          else
          {
            newAmount = converter(ingredient, fromUnit, toUnit, amount);
            amountLabel.setText(String.format(languageField.STRINGS.getString("toAmount")
                + " %.1f", newAmount));
          }
        }
      }
      catch (NumberFormatException nfe)
      {
        amountLabel.setText(languageField.STRINGS.getString("invalidUC"));
      }  
    } 
    
    if (e.getSource() == reset)
    {
      amountBox.setText("");
      amountLabel.setText(languageField.STRINGS.getString("toAmount"));
      ingredientsBox.setEnabled(true);
      ingredientsBox.setSelectedItem("Alcohol");
      fromUnitsBox.setSelectedItem(dr);
      toUnitsBox.setSelectedItem(dr);
    }
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
    double newAmount = 0.0;
    newAmount = UnitConversion.converter(ingredient, fromUnit, toUnit, amount);
    return newAmount;
  }
  
  private ImageIcon loadImageIcon(final String name)
  {
    URL url = this.getClass().getResource("/icons/"+ name);
    ImageIcon icon = new ImageIcon(url);
    return icon;
  }
  
  private JButton createJButton(final String name, final String actionCommand)
  {
    JButton result = new JButton(loadImageIcon(name));
    result.setActionCommand(actionCommand);
    result.addActionListener(this);
    return result;
  }
  
  /**
   * Makes a new UnitConverterWindow.
   * @return UnitConverterWindow
   */
  public static UnitConverterWindow createInstance()
  {
    if (exists)
    {
      return instance;
    }
    else
    {
      instance = new UnitConverterWindow();
      exists = true;
      return instance;
    }
  }
  
  @Override
  public void windowOpened(final WindowEvent e)
  {
    // Not needed

  }

  @Override
  public void windowClosing(final WindowEvent e)
  {
    exists = false;
    instance = null;
  }

  @Override
  public void windowClosed(final WindowEvent e)
  {
    // Not needed

  }

  @Override
  public void windowIconified(final WindowEvent e)
  {
    // Not needed

  }

  @Override
  public void windowDeiconified(final WindowEvent e)
  {
    // Not needed

  }

  @Override
  public void windowActivated(final WindowEvent e)
  {
    // Not needed

  }

  @Override
  public void windowDeactivated(final WindowEvent e)
  {
    // Not needed

  }

}
