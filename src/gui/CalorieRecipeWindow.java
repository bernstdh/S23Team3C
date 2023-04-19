package gui;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

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
public class CalorieRecipeWindow extends JFrame implements ActionListener 
{
  static final String CALCULATE = "Calculate";
  static final String RESET = "Reset";
  private static final long serialVersionUID = 1L;
  private String calor = "Calories:";
  private String invalid = "Calories: Please Enter a Valid Size";
  private String negative = "Calories: Please Enter a Positive Size";
  private String choose = "Choose File";
  private String noRep = "Couldn't load recipe.";
  
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
  public CalorieRecipeWindow() 
  {
    super("Calorie Calculator");
    
    recipeButton = new JButton();
    recipeButton.addActionListener(this);
    recipeButton.setText(choose);
    servingsBox = new JTextField(10);

    calorieLabel = new JLabel(calor);
    calc = createJButton("calculate.png", CALCULATE);
    reset = createJButton("reset.png", RESET);
    reset.addActionListener(this);
    fileName = new JLabel("");

    JPanel panel = new JPanel(new GridLayout(2,1));
    JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    upperPanel.add(calc);
    upperPanel.add(reset);
    lowerPanel.add(new JLabel("Recipe:"));
    lowerPanel.add(recipeButton);
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
        System.out.println(noRep);
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
        System.out.println(noRep);
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
      recipeButton.setText(choose);
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
}
