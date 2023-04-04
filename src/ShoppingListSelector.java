import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A mid-point between the main menu and the ShoppingListViewer so the user can select what menu or
 * recipe they want to use.
 * @author Beau Mueller
 *
 */
public class ShoppingListSelector extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  JButton confirmType;
  JButton confirmItem;
  
  JComboBox<String> typeBox;
  JComboBox<String> itemBox;
  
  JPanel type;
  JPanel item;
  
  GridLayout gl;
  FlowLayout fl;
  
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
    typeBox.addItem("Recipe");
    typeBox.addItem("Menu");
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
    
    confirmItem = new JButton("Confirm Item");
    confirmItem.addActionListener(this);
    
    setVisible(true);
    
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    if(e.getSource().equals(confirmType) && typeBox.getSelectedItem() != null)
    {
      //Reload the GridLayout
      gl = new GridLayout(2, 1);
      setSize(200, 400);
      setLayout(gl);
      
      //Create the item section
      itemBox = new JComboBox<String>();
      itemBox.addItem("recipe");
      itemBox.setSelectedItem(null);
      item = new JPanel();
      item.setLayout(fl);
      item.add(itemBox);
      item.add(confirmItem);
      add(item);
    } else if(e.getSource().equals(confirmItem) && itemBox.getSelectedItem() != null)
    {
      // This is an incomplete method. As of now there's no list of recipes for the user to select
      // from so I generated a list of 10 random items so ShoppingListViewer can be tested/observed.
      ArrayList<String> al = new ArrayList<String>();
      fakeList(al);
      new ShoppingListViewer(al, (String)itemBox.getSelectedItem());
      
      /* PSEUDO CODE:
       * if(type = recipe)
       *  Recipe r = find recipe
       *  new ShoppingListViewer(<stuff in the recipe>, recipeName)
       * if(type = meal)
       *  Meal m = find meal
       *  new ShoppingListViewer(<stuff in the meal>, mealName)
       */
    }
  }
  
  private void fakeList(final List<String> list)
  {
    for(int i = 0; i < 10; i++)
    {
      list.add("Item " + i + ": " + Math.random() * 50);
    }
    list.add("out of order test");
  }
}
