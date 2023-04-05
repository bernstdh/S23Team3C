package process;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.Serializer;
import recipe.Recipes;

/**
 * The middle-ground between the main menu and the ProcessViewer.
 * @author Beau Mueller
 *
 */
public class ProcessSelector extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;
  
  private JButton confirmRecipe;
  private FlowLayout fl;
  private JButton chooseFile;
  private JFileChooser fileChooser;
  private JLabel fileName;
  private int fileSelection;
  /**
   * Creates a new process selector window which is used to select a recipe to be viewed.
   */
  public ProcessSelector()
  {
    //Create the frame
    super("Recipe Selector");
    setSize(200, 200);
    fl = new FlowLayout();
    
    
    setLayout(fl);
    
    //Recipe selector button
    confirmRecipe = new JButton("Confirm Recipe");
    confirmRecipe.addActionListener(this);
    confirmRecipe.setSize(50, 50);
    
    //Choosefile button
    chooseFile = new JButton("Choose Recipe File");
    chooseFile.addActionListener(this);
    
    //File name
    fileName = new JLabel("");
    //Add elements and set visible to tru
    add(chooseFile);
    add(confirmRecipe);
    add(fileName);
    setVisible(true);
  }
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // If 'Confirm Recipe' is pressed and there is a file selected, create a new ProcessViewer
    if(e.getSource() == confirmRecipe && fileSelection == JFileChooser.APPROVE_OPTION)
    {
      ProcessViewer pv = new ProcessViewer();
      System.out.println(fileChooser.getSelectedFile().toString());
      Recipes r = null;
      try
      {
        r = Serializer.deserializeRecipe(fileChooser.getSelectedFile().toString());
      }
      catch (ClassNotFoundException | IOException e1)
      {
        System.out.println("Failed to deserialize recipe: " + e1.toString());
      }
      r.alphabetize(r.getIngredients());
      String utensils = "Test\ntest2\ntest3";
      String steps = "Test\ntest2\ntest33";
      pv.setUtensils(utensils);
      pv.setSteps(steps);
    }
    // If 'Choose File' is pressed, open fileChooser so the user can select a .rcp.
    if(e.getSource() == chooseFile)
    {
      fileChooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Recipes", "rcp");
      fileChooser.setFileFilter(filter);
      fileSelection = fileChooser.showOpenDialog(this);
      fileName.setText(fileChooser.getSelectedFile().getName());
    }
    
  }

}
