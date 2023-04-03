import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * 
 * @author beaumueller
 *
 */
public class ProcessSelector extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  
  JButton confirmRecipe;
  JComboBox<String> recipes;
  FlowLayout fl;
  /**
   * Creates a new process selector window which is used to select a recipe to be viewed.
   */
  public ProcessSelector()
  {
    //Create the frame
    super("Recipe Selector");
    setSize(200, 200);
    fl = new FlowLayout();
    
    //Create the recipe selector
    recipes = new JComboBox<String>();
    recipes.addItem("eggs");
    recipes.addItem("waffles");
    recipes.addItem("burger");
    recipes.setSelectedItem(null);
    setLayout(fl);
    
    //Recipe selector button
    confirmRecipe = new JButton("Confirm Recipe");
    confirmRecipe.addActionListener(this);
    confirmRecipe.setSize(50, 50);
    
    //Add elements and set visible to true
    add(recipes);
    add(confirmRecipe);
    setVisible(true);
  }
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    if(e.getSource() == confirmRecipe && recipes.getSelectedItem() != null)
    {
      ProcessViewer pv = new ProcessViewer(); // Should be able to pass in a recipe and name of the
      //pv.setUtensils("spoon");
    }
    
  }

}
