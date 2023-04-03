import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Main window for the KILowBites application. Contains a JMenuBar with all menus.
 * 
 * @author beaumueller
 *
 */
public class MainWindow extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  JMenuBar menuBar;
  JMenu file, edit, view, tools, configure, help;
  JMenuItem exit, recipe, meal, shoppingList, process, calorieCalculator, unitsConverter,
      preferences, nutrition, about;

  /**
   * Creates a new MainWindow object and adds the all menus.
   * 
   * @param name
   *          Name of the window.
   */
  public MainWindow(final String name)
  {
    super(name);
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
    calorieCalculator = new JMenuItem("Calorie Counter");
    unitsConverter = new JMenuItem("Units Converter");
    tools.add(calorieCalculator);
    tools.add(unitsConverter);
    calorieCalculator.addActionListener(this);
    unitsConverter.addActionListener(this);
    mb.add(tools);

    configure = new JMenu("Configure");
    preferences = new JMenuItem("Preferences");
    nutrition = new JMenuItem("Nutrition");
    configure.add(preferences);
    configure.add(nutrition);
    preferences.addActionListener(this);
    nutrition.addActionListener(this);
    mb.add(configure);

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
      System.out.println("open recipe editor");
    }
    else if (e.getSource() == meal)
    {
      System.out.println("open meal editor");
    }
    else if (e.getSource() == shoppingList)
    {
      new ShoppingListSelector();
    }
    else if (e.getSource() == process)
    {
      new ProcessViewer();
    }
    else if (e.getSource() == calorieCalculator)
    {
      new CalorieCalculator();
    }
    else if (e.getSource() == unitsConverter)
    {
      System.out.println("open units converter");
    }
    else if (e.getSource() == preferences)
    {
      new Preferences();
    }
    else if (e.getSource() == nutrition)
    {
      System.out.println("open nutrition");
    }
    else if (e.getSource() == about)
    {
      new AboutDialog();
    }
  }
}
