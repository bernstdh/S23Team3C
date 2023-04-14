package calculators;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.Serializer;
import ingredients.Formatter;
import ingredients.Ingredient;
import meals.Meals;
import recipe.Recipes;
import shopping.ShoppingListViewer;

public class CalorieWindowSelector extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  private JComboBox<String> typeBox;
  private JButton confirmType;
  private JButton confirmItem;
  
  private JPanel type;
  private JPanel file;
  
  private GridLayout gl;
  private FlowLayout fl;
  
  private JFileChooser fileChooser;
  private JButton chooseFile;
  private JLabel fileName;
  
  private int fileSelection;
  
  private final String recipe = "Recipe";
  private final String meal = "Meal";
  private final String ing = "Ingredient";
  
  public CalorieWindowSelector()
  {
    super("Calorie Calculator Selector");
    
    setSize(200, 200);
    gl = new GridLayout(1, 1);
    gl.setVgap(10);
    fl = new FlowLayout();
    
    type = new JPanel();
    typeBox = new JComboBox<String>();
    typeBox.addItem(ing);
    typeBox.addItem(recipe);
    typeBox.addItem(meal);
    typeBox.setSelectedItem(null);
    setLayout(gl);
    
    //Type selector button
    confirmType = new JButton("Confirm Type");
    confirmType.addActionListener(this);
    confirmType.setSize(50, 50);
    
    //Finalize type section
    type.setLayout(fl);
    type.add(typeBox);
    type.add(confirmType);
    add(type);
    
    file = new JPanel();
    file.setLayout(new FlowLayout());
    chooseFile = new JButton("Choose File");
    chooseFile.addActionListener(this);
    confirmItem = new JButton("Confirm Item");
    confirmItem.addActionListener(this);
    fileName = new JLabel("");
    file.add(chooseFile);
    file.add(confirmItem);
    file.add(fileName);
    
    setVisible(true);
    setResizable(false);
  }
  
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    if(e.getSource().equals(confirmType) && typeBox.getSelectedItem() != null
        && typeBox.getSelectedItem().toString().equals(ing))
    {
      new CalorieCalculatorWindow();
    }
    else if(e.getSource().equals(confirmType) && typeBox.getSelectedItem() != null
        && typeBox.getSelectedItem().toString().equals(recipe))
    {
      new CalorieRecipeWindow();
    }
    else if(e.getSource().equals(confirmType) && typeBox.getSelectedItem() != null
        && typeBox.getSelectedItem().toString().equals(meal))
    {
      new CalorieMealWindow();
    }
  }
}

