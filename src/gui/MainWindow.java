package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import items.IngredientTable;
import items.Ingredients;
import utilities.Serializer;

/**
 * Main window for the KILowBites application. Contains a JMenuBar with all menus.
 * 
 * @author Beau Mueller
 *
 */
public class MainWindow extends JFrame implements ActionListener, WindowListener
{
  private static final long serialVersionUID = 1L;
  JMenuBar menuBar;
  JMenu file, edit, view, tools, help;
  JMenuItem exit, recipe, meal, shoppingList, process, calorieCalculator, unitsConverter, about;

  /**
   * Creates a new MainWindow object and adds the all menus.
   * 
   * @param name
   *          Name of the window.
   */
  public MainWindow(final String name)
  {
    super(name);
    addWindowListener(this);
    menuBar = new JMenuBar();
    addMenuItems(menuBar);
    setJMenuBar(menuBar);
  }

  private void addMenuItems(final JMenuBar mb)
  {

    file = new JMenu("File");
    exit = new JMenuItem("Exit");
    file.add(exit);
    exit.addActionListener(this);
    mb.add(file);

    edit = new JMenu("Edit");
    recipe = new JMenuItem("Recipe");
    meal = new JMenuItem("Meal");
    edit.add(recipe);
    edit.add(meal);
    recipe.addActionListener(this);
    meal.addActionListener(this);
    mb.add(edit);

    view = new JMenu("View");
    shoppingList = new JMenuItem("Shopping List");
    process = new JMenuItem("Process");
    view.add(shoppingList);
    view.add(process);
    shoppingList.addActionListener(this);
    process.addActionListener(this);
    mb.add(view);

    tools = new JMenu("Tools");
    calorieCalculator = new JMenuItem("Calorie Calculator");
    unitsConverter = new JMenuItem("Units Converter");
    tools.add(calorieCalculator);
    tools.add(unitsConverter);
    calorieCalculator.addActionListener(this);
    unitsConverter.addActionListener(this);
    mb.add(tools);

    help = new JMenu("Help");
    about = new JMenuItem("About");
    help.add(about);
    about.addActionListener(this);
    mb.add(help);
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    if (e.getSource() == exit)
    {
      System.exit(0);
    }
    else if (e.getSource() == recipe)
    {
      new RecipeEditor();
    }
    else if (e.getSource() == meal)
    {
      new MealEditor();
    }
    else if (e.getSource() == shoppingList)
    {
      new ShoppingListSelector();
    }
    else if (e.getSource() == process)
    {
      new ProcessSelector();
    }
    else if (e.getSource() == calorieCalculator)
    {
      new CalorieWindowSelector();
    }
    else if (e.getSource() == unitsConverter)
    {
      new UnitConverterWindow();
    }
    else if (e.getSource() == about)
    {
      new AboutDialog();
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
    ArrayList<Ingredients> table = IngredientTable.createInstance();
    ArrayList<Ingredients> al = new ArrayList<Ingredients>();
    for (int i = 77; i < table.size(); i++)
    {
      al.add(table.get(i));
    }
    try
    {
      Serializer.saveIngredients(al);
    }
    catch (IOException e1)
    {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

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
