package gui;
import javax.swing.*;

import items.IngredientTable;
import math.UnitConversion;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * The window for the unit converter.
 * @author Trace Jones, James Madison University
 * @version 1.0
 * 
 * This work complies with the JMU Honor Code.
 */
public class UnitConverterWindow extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  
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
  private String ind = "indivdual";
  private String toAmount = "To Amount:";
  private String invalid = "To Amount: Please Enter a Valid Number.";
  private String negative = "To Amount: Please Enter a Positive Number";
  String[] units = {dr, g, oz, lb, p, tsp, tbs, floz, cup,
      pt, qt, gal, ml, ind};
  ArrayList<String> weight = new ArrayList<String>(
      Arrays.asList(dr, g, oz, lb));
  ArrayList<String> volume = new ArrayList<String>(
      Arrays.asList(ml, p, tsp, tbs, floz, cup, pt, qt, gal));
  
  /**
   * The constructor for the UnitConverterWindow.
   */
  public UnitConverterWindow()
  {
    super("Unit Converter");
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
    
    
    amountLabel = new JLabel(toAmount);
    
    calc = new JButton(new ImageIcon("calculate.png"));
    calc.addActionListener(this);
    reset = new JButton(new ImageIcon("reset.png"));
    reset.addActionListener(this);

    JPanel panel = new JPanel(new GridLayout(2, 1));
    JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    upperPanel.add(calc);
    upperPanel.add(reset);
    lowerPanel.add(new JLabel("From Units:"));
    lowerPanel.add(fromUnitsBox);
    lowerPanel.add(new JLabel("To Units:"));
    lowerPanel.add(toUnitsBox);
    lowerPanel.add(new JLabel("Ingredient:"));
    lowerPanel.add(ingredientsBox);
    lowerPanel.add(new JLabel("From Amount: "));
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
    if (fromUnit.equals(ind)) toUnitsBox.setEnabled(false);
    else toUnitsBox.setEnabled(true);
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
  
    if (amountBox.getText().equals("")) amount = 0.0;
    
    if (e.getSource() == calc)
    {
      if (fromUnit.equals(ind))
      {
        try
        {
          amount = Double.parseDouble(amountBox.getText());
          if (amount < 0) amountLabel.setText(negative);
          else amountLabel.setText(String.format("%s %.1f", toAmount, amount));
        }
        catch (NumberFormatException nfe)
        {
          amountLabel.setText(invalid);
        }
        
      }
      else
      {
        try
        {
          amount = Double.parseDouble(amountBox.getText());
          if (amount < 0) amountLabel.setText(negative);
          else
          {
            newAmount = converter(ingredient, fromUnit, toUnit, amount);
            amountLabel.setText(String.format("To Amount: %.1f", newAmount));
          }
        }
        catch (NumberFormatException nfe)
        {
          amountLabel.setText(invalid);
        }  
      } 
    }
    
    if (e.getSource() == reset)
    {
      amountBox.setText("");
      amountLabel.setText(toAmount);
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

}
