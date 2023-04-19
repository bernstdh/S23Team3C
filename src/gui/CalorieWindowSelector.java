package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CalorieWindowSelector.
 * @author Trace Jones
 *
 */
public class CalorieWindowSelector extends JFrame implements ActionListener, WindowListener
{
  private static final long serialVersionUID = 1L;
  private static boolean exists = false;
  private static CalorieWindowSelector instance = null;
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
  
  /**
   * Constructor.
   */
  private CalorieWindowSelector()
  {
    super("Calorie Calculator Selector");
    addWindowListener(this);
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
      CalorieCalculatorWindow.createInstance();
    }
    else if(e.getSource().equals(confirmType) && typeBox.getSelectedItem() != null
        && typeBox.getSelectedItem().toString().equals(recipe))
    {
      CalorieRecipeWindow.createInstance();
    }
    else if(e.getSource().equals(confirmType) && typeBox.getSelectedItem() != null
        && typeBox.getSelectedItem().toString().equals(meal))
    {
      CalorieMealWindow.createInstance();
    }
  }
  
  /**
   * Makes a new UnitConverterWindow.
   * @return UnitConverterWindow
   */
  public static CalorieWindowSelector createInstance()
  {
    if (exists)
    {
      return instance;
    }
    else
    {
      instance = new CalorieWindowSelector();
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
