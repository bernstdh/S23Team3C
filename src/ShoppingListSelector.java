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

import Ingredient;
import Meals;
import Recipes;
import Serializer;
import ShoppingListViewer;

/**
 * A mid-point between the main menu and the ShoppingListViewer so the user can select what menu or
 * recipe they want to use.
 * @author Beau Mueller
 *
 */
public class ShoppingListSelector extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  private JButton confirmType;
  private JButton confirmItem;
  
  private JComboBox<String> typeBox;
  
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
  
  /**
   * Creates a new ShoppingListSelector that includes a dropdown for selecting whether the shopping
   * list should be made from a recipe or a meal.
   */
  public ShoppingListSelector()
  {
    //Create the frame
    super("Shopping List Selector");
    setSize(200, 200);
    gl = new GridLayout(1, 1);
    gl.setVgap(10);
    fl = new FlowLayout();
    
    //Create the Type selector
    type = new JPanel();
    typeBox = new JComboBox<String>();
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
    
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    if(e.getSource().equals(confirmType) && typeBox.getSelectedItem() != null)
    {
      //Reload the GridLayout
      gl = new GridLayout(2, 1);
      add(file);
      setSize(200, 250);
      setLayout(gl);
    } else if(e.getSource().equals(confirmItem) && fileSelection == JFileChooser.APPROVE_OPTION)
    {
      
      ArrayList<String> ingredients = new ArrayList<String>();
      String name;
      if(typeBox.getSelectedItem().equals(recipe))
      {
        try
        {
          Recipes r = Serializer.deserializeRecipe(fileChooser.getSelectedFile().toString());
          name = r.getName();
          loadIngredientsList(ingredients, r);
          new ShoppingListViewer(ingredients, name);
        }
        catch (ClassNotFoundException | IOException e1)
        {
          System.out.println("Couldn't load recipe shopping list: " + e1.toString());
        }
      } else if(typeBox.getSelectedItem().equals(meal))
      {
        try
        {
          Meals m = Serializer.deserializeMeal(fileChooser.getSelectedFile().toString());
          name = m.getName();
          for(Recipes r : m.getRecipes())
          {
            loadIngredientsList(ingredients, r);
            new ShoppingListViewer(ingredients, name);
          }
        }
        catch (ClassNotFoundException | IOException e1)
        {
          System.out.println("Couldn't load meal shopping list: " + e1.toString());
        }
      }
    } else if(e.getSource().equals(chooseFile))
    {
   // Create the file selection based on the type of item
      fileChooser = new JFileChooser();
      fileChooser.addActionListener(this);
      FileNameExtensionFilter filter = null;
      if(typeBox.getSelectedItem().equals(recipe))
      {
        filter = new FileNameExtensionFilter("Recipes", "rcp");
      } else if (typeBox.getSelectedItem().equals(meal))
      {
        filter = new FileNameExtensionFilter("Meals", "mel");
      }
      fileChooser.setFileFilter(filter);
      fileSelection = fileChooser.showOpenDialog(this);
      fileName.setText(fileChooser.getSelectedFile().getName());
    }
  }
  
  private void loadIngredientsList(final List<String> list,final Recipes r)
  {
    for(Ingredient i : r.getIngredients())
    {
      list.add(i.getName());
    }
  }
}
