package gui;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.languageField;
import utilities.Serializer;
import items.Recipes;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
/**
 * Calorie Calculator from Grams GUI.
 * @author Trace Jones
 *
 */
public class CalorieRecipeWindow extends JFrame implements ActionListener, WindowListener
{
  static final String CALCULATE = "Calculate";
  static final String RESET = "Reset";
  private static final long serialVersionUID = 1L;
  private static boolean exists = false;
  private static CalorieRecipeWindow instance = null;
  private String calor = "Calories:";
  private String invalid = "Calories: Please Enter a Valid Number";
  private String negative = "Calories: Please Enter a Positive Number";
  private String choose = "Choose File";
  private String noRep = "Couldn't load recipe.";
  private String se = "Servings";
  private String re = "Recipe";
  
  private JTextField servingsBox;
  private JLabel calorieLabel;
  private JButton calc;
  private JButton reset;
  private JButton recipeButton;
  
  private JFileChooser fileChooser;
  private JButton chooseFile;
  private JLabel fileName;
  
  private int fileSelection;
  
  /**
   * Constructor. 
   */
  private CalorieRecipeWindow() 
  {
    super(languageField.STRINGS.getString("calC"));
    addWindowListener(this);
    recipeButton = new JButton();
    recipeButton.addActionListener(this);
    recipeButton.setText(languageField.STRINGS.getString("choose"));
    servingsBox = new JTextField(10);

    calorieLabel = new JLabel(languageField.STRINGS.getString("calor"));
    calc = createJButton("calculate.png", CALCULATE);
    reset = createJButton("reset.png", RESET);
    reset.addActionListener(this);
    fileName = new JLabel("");

    JPanel panel = new JPanel(new GridLayout(2,1));
    JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    upperPanel.add(calc);
    upperPanel.add(reset);
    lowerPanel.add(new JLabel(languageField.STRINGS.getString("re") + ":"));
    lowerPanel.add(recipeButton);
    lowerPanel.add(new JLabel(languageField.STRINGS.getString("se") + ":"));
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
    if (e.getSource() == recipeButton)
    {
      fileChooser = new JFileChooser();
      fileChooser.addActionListener(this);
      FileNameExtensionFilter filter = null;
      filter = new FileNameExtensionFilter("Recipes", "rcp");
      fileChooser.setFileFilter(filter);
      fileSelection = fileChooser.showOpenDialog(this);
      fileName.setText(fileChooser.getSelectedFile().getName());
      try
      {
        Recipes rec = Serializer.deserializeRecipe(fileChooser.getSelectedFile().toString());
        recipeButton.setText(rec.getName());
      }
      catch (ClassNotFoundException | IOException e1)
      {
        System.out.println(languageField.STRINGS.getString("noRep"));
      } 
    }
    else if (e.getSource() == calc)
    {
      double servings = -1.0;
      if (servingsBox.getText().equals("")) servings = 0.0;
      try
      {
        Recipes rec = Serializer.deserializeRecipe(fileChooser.getSelectedFile().toString());
        calories = rec.calorieCalculator();
        recipeButton.setText(rec.getName());
      }
      catch (ClassNotFoundException | IOException e1)
      {
        System.out.println(languageField.STRINGS.getString("noRep"));
      } 
      try
      {
        servings = Double.parseDouble(servingsBox.getText());
        if (servings < 0) calorieLabel.setText(languageField.STRINGS.getString("negative"));
        else
        {
          calorieLabel.setText(String.format(languageField.STRINGS.getString("calor")
              + " %.1f", calories * servings));
        } 
      }
      catch (NumberFormatException nfe)
      {
        calorieLabel.setText(languageField.STRINGS.getString("invalid"));
      } 
    }
    if (e.getSource() == reset)
    {
      recipeButton.setText(languageField.STRINGS.getString("choose"));
      calorieLabel.setText(languageField.STRINGS.getString("calor"));
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
   * makes new CalorieRecipeWindow.
   * @return CalorieRecipeWindow.
   */
  public static CalorieRecipeWindow createInstance()
  {
    if (exists)
    {
      return instance;
    }
    else
    {
      instance = new CalorieRecipeWindow();
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
