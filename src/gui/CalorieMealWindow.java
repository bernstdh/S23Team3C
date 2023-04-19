package gui;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import utilities.Serializer;
import items.Meals;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
/**
 * Calorie Calculator from Grams GUI.
 * @author Trace Jones
 *
 */
public class CalorieMealWindow extends JFrame implements ActionListener, WindowListener
{
  static final String CALCULATE = "Calculate";
  static final String RESET = "Reset";
  private static final long serialVersionUID = 1L;
  private static boolean exists = false;
  private static CalorieMealWindow instance = null;
  private String calor = "Calories:";
  private String invalid = "Calories: Please Enter a Valid Size";
  private String negative = "Calories: Please Enter a Positive Size";
  private String choose = "Choose File";
  private String noMeal = "Couldn't load meal.";
  
  private JTextField servingsBox;
  private JLabel calorieLabel;
  private JButton calc;
  private JButton reset;
  private JButton mealButton;
  
  private JFileChooser fileChooser;
  private JButton chooseFile;
  private JLabel fileName;
  
  private int fileSelection;
  
  /**
   * Constructor. 
   */
  private CalorieMealWindow() 
  {
    super("Calorie Calculator");
    addWindowListener(this);
    mealButton = new JButton();
    mealButton.addActionListener(this);
    mealButton.setText(choose);
    servingsBox = new JTextField(10);

    calorieLabel = new JLabel(calor);
    calc = createJButton("calculate.png", CALCULATE);
    reset = createJButton("reset.png", RESET);
    fileName = new JLabel("");

    JPanel panel = new JPanel(new GridLayout(2,1));
    JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    upperPanel.add(calc);
    upperPanel.add(reset);
    lowerPanel.add(new JLabel("Meal:"));
    lowerPanel.add(mealButton);
    lowerPanel.add(new JLabel("Servings:"));
    lowerPanel.add(servingsBox);
    lowerPanel.add(calorieLabel);
    panel.add(upperPanel, 0);
    panel.add(lowerPanel, 1);
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
  public void actionPerformed(final ActionEvent e) throws NumberFormatException
  {
    double calories = 0.0;
    if (e.getSource() == mealButton)
    {
      fileChooser = new JFileChooser();
      fileChooser.addActionListener(this);
      FileNameExtensionFilter filter = null;
      filter = new FileNameExtensionFilter("Meals", "mel");
      fileChooser.setFileFilter(filter);
      fileSelection = fileChooser.showOpenDialog(this);
      fileName.setText(fileChooser.getSelectedFile().getName());
      try
      {
        Meals meal = Serializer.deserializeMeal(fileChooser.getSelectedFile().toString());
        mealButton.setText(meal.getName());
      }
      catch (ClassNotFoundException | IOException e1)
      {
        System.out.println(noMeal);
      }
    }
    else if (e.getSource() == calc)
    {
      double servings = -1.0;
      if (servingsBox.getText().equals("")) servings = 0.0;
      try
      {
        Meals meal = Serializer.deserializeMeal(fileChooser.getSelectedFile().toString());
        calories = meal.calorieCalculator();
        mealButton.setText(meal.getName());
      }
      catch (ClassNotFoundException | IOException e1)
      {
        System.out.println(noMeal);
      }
      try
      {
        servings = Double.parseDouble(servingsBox.getText());
        if (servings < 0) calorieLabel.setText(negative);
        else
        {
          calorieLabel.setText(String.format("Calories: %.1f", calories * servings));
        } 
      }
      catch (NumberFormatException nfe)
      {
        calorieLabel.setText(invalid);
      } 
    }
    if (e.getSource() == reset)
    {
      mealButton.setText(choose);
      calorieLabel.setText(calor);
      servingsBox.setText("");
    }
    
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
   * makes new CalorieMealWindow.
   * @return CalorieMealWindow.
   */
  public static CalorieMealWindow createInstance()
  {
    if (exists)
    {
      return instance;
    }
    else
    {
      instance = new CalorieMealWindow();
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
