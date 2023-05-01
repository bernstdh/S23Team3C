package gui;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import app.languageField;
import items.Ingredient;
import math.UnitConversion;

/**
 * 
 * @author Shaury Gautam Shopping Viewer
 */

public class ShoppingListViewer extends JFrame implements Printable, ActionListener
{
  private static final long serialVersionUID = 1L;
  private JLabel numPeopleLabel;
  private JTextField numPeopleBox;
  private JButton generateButton;
  private JButton unitsButton;
  private JButton printButton;
  private JTextArea shoppingListBox;
  private ArrayList<Ingredient> box;
  private ArrayList<String> repeat = new ArrayList<String>();
  private ArrayList<String> repeatIng = new ArrayList<String>();

  private int count = 0;

  /**
   * Constructor.
   * 
   * @param ingrds
   *          Array List of Ingredients
   * @param title
   *          Title
   */

  public ShoppingListViewer(final ArrayList<Ingredient> ingrds, final String title)
  {
    super("KiLowBites " + languageField.STRINGS.getString("Shopping_LV") + " \t" + title);

    box = new ArrayList<Ingredient>();
    numPeopleLabel = new JLabel(languageField.STRINGS.getString("NumPpl"));
    numPeopleBox = new JTextField(10);
    generateButton = new JButton(languageField.STRINGS.getString("GenSL"));
    URL url = this.getClass().getResource("/icons/printButton.png");
    printButton = new JButton(new ImageIcon(url));
    printButton.addActionListener(this);
    unitsButton = new JButton(languageField.STRINGS.getString("Change_Units"));
    shoppingListBox = new JTextArea(20, 40);
    shoppingListBox.setEditable(false);

    setLayout(new FlowLayout());
    add(printButton);
    add(numPeopleLabel);
    add(numPeopleBox);
    add(generateButton);
    add(unitsButton);
    add(new JScrollPane(shoppingListBox));

    generateButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        numPeopleCalc(ingrds);
      }
    });

    unitsButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent e)
      {
        changeUnit();
        new ShoppingUnitWindow(ShoppingListViewer.this, repeat);
      }
    });

    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500, 400);
    setVisible(true);

  }

  /**
   * calculate Amounts.
   * 
   * @param ingredients
   *          String
   */
  private void numPeopleCalc(final ArrayList<Ingredient> ingredients)
  {
    double numPeople = 0;
    try
    {
      numPeople = Double.parseDouble(numPeopleBox.getText());
    }
    catch (NumberFormatException ex)
    {
      shoppingListBox.setText(languageField.STRINGS.getString("PlsValid"));
      return;
    }

    for (Ingredient str : ingredients)
    {
      double multiplier = 1.0;
      multiplier = str.getOgAmount();
      double result = numPeople * multiplier;
      str.setAmount(result);
      if (count < 1)
        box.add(str);
    }
    count++;
    changeUnit();
    if (repeat.size() != 0)
    {
      convertUnits(repeat.get(0));
    }
    mergeDuplicateIngredients();
    updateShoppingListDisplay();
  }

  /**
   * Adds items to repeated list.
   */
  private void changeUnit()
  {
    for (int i = 0; i < box.size(); i++)
    {
      for (int j = 0; j < box.size(); j++)
      {
        if (box.get(i).getIngredient().getIngredientName()
            .equals(box.get(j).getIngredient().getIngredientName()) && i != j)
        {
          repeat.add(box.get(i).getUnit());
          repeat.add(box.get(j).getUnit());
          repeatIng.add(box.get(i).getIngredient().getIngredientName());
          repeatIng.add(box.get(j).getIngredient().getIngredientName());

        }
      }
    }
  }

  /**
   * Converts units.
   * 
   * @param newUnit
   *          Unit to be converted to
   */
  public void convertUnits(final String newUnit)
  {
    for (int i = 0; i < box.size(); i++)
    {
      String ingredient = box.get(i).getIngredient().getIngredientName();
      String fromUnit = box.get(i).getUnit();
      double amount = box.get(i).getAmount();

      if (repeat.contains(fromUnit) && repeatIng.contains(ingredient) && !fromUnit.equals(newUnit))
      {
        double convertedAmount = UnitConversion.converter(ingredient, fromUnit, newUnit, amount);
        box.get(i).setUnit(newUnit);
        box.get(i).setAmount(convertedAmount);
      }
    }
    updateShoppingListDisplay();
  }

  /**
   * updates Display.
   */
  private void updateShoppingListDisplay()
  {
    String display = "";
    for (Ingredient entry : box)
    {
      display += (entry.toString()) + "\n";
    }
    shoppingListBox.setText(display);
  }

  /**
   * Merges duplicate ingredients.
   */
  private void mergeDuplicateIngredients()
  {
    for (int i = 0; i < box.size(); i++)
    {
      for (int j = i + 1; j < box.size(); j++)
      {
        Ingredient ingr1 = box.get(i);
        Ingredient ingr2 = box.get(j);

        if (equal(ingr1, ingr2))
        {
          ingr1.setAmount(ingr1.getAmount() + ingr2.getAmount());
          box.remove(j);
          j--;
        }
      }
    }
  }

  /**
   * Checks if two ingredients are equal except for their amount.
   * 
   * @param ingr1
   *          first ingredient
   * @param ingr2
   *          second ingredient
   * @return if equal
   */
  private boolean equal(Ingredient ingr1, Ingredient ingr2)
  {
    return ingr1.getIngredient().equals(ingr2.getIngredient())
        && ingr1.getName().equals(ingr2.getName()) && ingr1.getDetails().equals(ingr2.getDetails())
        && ingr1.getUnit().equals(ingr2.getUnit());
  }

  @Override
  public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException
  {
    double cH, cW, h, scale, w, x, y;
    Graphics2D g2;
    int status;

    g2 = (Graphics2D) graphics;

    status = Printable.NO_SUCH_PAGE;

    if (pageIndex == 0)
    {
      x = pageFormat.getImageableX();
      y = pageFormat.getImageableY();

      g2.translate(x, y);

      h = pageFormat.getImageableHeight();
      w = pageFormat.getImageableWidth();
      cW = (double) (this.getWidth());
      cH = (double) (this.getHeight());
      scale = Math.min(w / cW, h / cH);
      g2.scale(scale, scale);

      this.paint(g2);

      status = Printable.PAGE_EXISTS;
    }
    return status;
  }

  public void printShoppingList()
  {
    PrinterJob job = PrinterJob.getPrinterJob();
    PageFormat format = job.defaultPage();
    try
    {
      job.setPrintable(this, format);
      boolean shouldPrint = job.printDialog();
      if (shouldPrint)
        job.print();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource().equals(printButton)) {
      printShoppingList();
    }
  }
}
