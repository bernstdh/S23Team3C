package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import app.languageField;
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
  static final String LOGO = "Logo";
  private static final long serialVersionUID = 1L;
  JMenuBar menuBar;
  JMenu file, edit, view, tools, help;
  JMenuItem exit, recipe, meal, shoppingList, process, calorieCalculator, unitsConverter, about;
  private JLabel logo;

  /**
   * Creates a new MainWindow object and adds the all menus.
   * 
   * @param name
   *          Name of the window.
   */
  public MainWindow(final String name)
  {
    super(languageField.STRINGS.getString("KILowBites"));
    addWindowListener(this);
    menuBar = new JMenuBar();
    addMenuItems(menuBar);
    setJMenuBar(menuBar);
    logo = new JLabel(loadImageIcon("logoKILowBites.png"));
    this.add(logo);
  }
  
  private void addMenuItems(final JMenuBar mb)
  {

    file = new JMenu(languageField.STRINGS.getString("file"));
    exit = new JMenuItem(languageField.STRINGS.getString("exit"));
    file.add(exit);
    exit.addActionListener(this);
    mb.add(file);

    edit = new JMenu(languageField.STRINGS.getString("edit"));
    recipe = new JMenuItem(languageField.STRINGS.getString("recipe"));
    meal = new JMenuItem(languageField.STRINGS.getString("meal"));
    edit.add(recipe);
    edit.add(meal);
    recipe.addActionListener(this);
    meal.addActionListener(this);
    mb.add(edit);

    view = new JMenu(languageField.STRINGS.getString("view"));
    shoppingList = new JMenuItem(languageField.STRINGS.getString("shoppingList"));
    process = new JMenuItem(languageField.STRINGS.getString("process"));
    view.add(shoppingList);
    view.add(process);
    shoppingList.addActionListener(this);
    process.addActionListener(this);
    mb.add(view);

    tools = new JMenu(languageField.STRINGS.getString("tools"));
    calorieCalculator = new JMenuItem(languageField.STRINGS.getString("calorieCalculator"));
    unitsConverter = new JMenuItem(languageField.STRINGS.getString("unitsConverter"));
    tools.add(calorieCalculator);
    tools.add(unitsConverter);
    calorieCalculator.addActionListener(this);
    unitsConverter.addActionListener(this);
    mb.add(tools);

    help = new JMenu(languageField.STRINGS.getString("help"));
    about = new JMenuItem(languageField.STRINGS.getString("about"));
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
      CalorieWindowSelector.createInstance();
    }
    else if (e.getSource() == unitsConverter)
    {
      UnitConverterWindow.createInstance();
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
  
  private ImageIcon loadImageIcon(final String name)
  {
    URL url = this.getClass().getResource("/icons/"+ name);
    ImageIcon icon = new ImageIcon(url);
    return icon;
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
