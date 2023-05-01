package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.languageField;
import items.Meals;
import items.Recipes;
import items.Steps;
import items.Utensils;
import utilities.Formatter;
import utilities.Serializer;

/**
 * The middle-ground between the main menu and the ProcessViewer.
 * 
 * @author Beau Mueller
 *
 */
public class ProcessSelector extends JFrame implements ActionListener
{
  private static final long serialVersionUID = 1L;

  private final String newLine = "\n";

  private JButton confirmType;
  private JButton confirmFile;

  private JComboBox<String> typeBox;

  private JPanel type;
  private JPanel file;

  private GridLayout gl;
  private FlowLayout fl;

  private JButton chooseFile;
  private JFileChooser fileChooser;
  private JLabel fileName;

  private int fileSelection;

  private final String recipe = languageField.STRINGS.getString("recipe");
  private final String meal = languageField.STRINGS.getString("meal");

  /**
   * Creates a new process selector window which is used to select a recipe to be viewed.
   */
  public ProcessSelector()
  {
    // Create the frame
    super(languageField.STRINGS.getString("processSelector"));
    setSize(200, 200);
    gl = new GridLayout(1, 1);
    gl.setVgap(10);
    fl = new FlowLayout();

    // Create the type selector
    type = new JPanel();
    typeBox = new JComboBox<String>();
    typeBox.addItem(recipe);
    typeBox.addItem(meal);
    typeBox.setSelectedItem(null);
    setLayout(gl);

    // Type selector button
    confirmType = new JButton(languageField.STRINGS.getString("confirmType"));
    confirmType.addActionListener(this);
    confirmType.setSize(50, 50);

    // Finalize type section
    type.setLayout(fl);
    type.add(typeBox);
    type.add(confirmType);
    add(type);

    // File panel
    file = new JPanel();
    file.setLayout(fl);
    confirmFile = new JButton(languageField.STRINGS.getString("confirmFile"));
    confirmFile.addActionListener(this);
    confirmFile.setSize(50, 50);

    // Choose File Button
    chooseFile = new JButton(languageField.STRINGS.getString("chooseFile"));
    chooseFile.addActionListener(this);

    fileName = new JLabel("");
    file.add(chooseFile);
    file.add(confirmFile);
    file.add(fileName);
    setVisible(true);
  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // If 'Confirm Recipe' is pressed and there is a file selected, create a new ProcessViewer
    if (e.getSource() == confirmFile && fileSelection == JFileChooser.APPROVE_OPTION)
    {
      Recipes r = null;
      Meals m = null;
      if (typeBox.getSelectedItem().equals(recipe))
      {
        try
        {
          r = Serializer.deserializeRecipe(fileChooser.getSelectedFile().toString());
        }
        catch (ClassNotFoundException | IOException e1)
        {
          System.out.println("Failed to deserialize recipe: " + e1.toString());
        }
        if (r != null)
        {
          r.alphabetize(r.getIngredients());
          r.alphabetizeU(r.getUtensils());
          String steps = "";
          String utensils = "";
          System.out.println(r.getSteps().size());
          for (Steps s : r.getSteps())
          {
            if (s.getUtensilsSource() == s.getDestination()) // STEP_SINGLE
            {
              steps += String.format(Formatter.STEP_SINGLE, s.getAction(), s.getDestination(),
                  s.getDetails());
            }
            else if (s.getUtensilsSource() == null) // STEP_INGREDIENT
            {
              steps += String.format(Formatter.STEP_INGREDIENT, s.getAction(),
                  s.getIngredientSource(), s.getDestination(), s.getDetails()) + newLine;
            }
            else // STEP_MUL
            {
              steps += String.format(Formatter.STEP_MUL, s.getAction(), s.getUtensilsSource(),
                  s.getDestination(), s.getDetails()) + newLine;
            }
          }
          for (Utensils u : r.getUtensils())
          {
            utensils += String.format(Formatter.UTENSIL, u.getDetails(), u.getName()) + newLine;
          }
          ProcessViewer pv = new ProcessViewer(r.getName());
          pv.setUtensils(utensils);
          pv.setSteps(steps);
          dispose();
        }
      }
      else if (typeBox.getSelectedItem().equals(meal))
      {
        try
        {
          m = Serializer.deserializeMeal(fileChooser.getSelectedFile().toString());
        }
        catch (ClassNotFoundException | IOException e1)
        {
          System.out.println("(Process Selector) Failed to deserialize recipe: " + e1.toString());
        }

        if (m != null)
        {
          ArrayList<Utensils> utensils = new ArrayList<Utensils>();
          ArrayList<Steps> steps = new ArrayList<Steps>();
          String strSteps = "";
          String strUtensils = "";
          for (Recipes rcp : m.getRecipes())
          {
            for (Utensils u : rcp.getUtensils())
              utensils.add(u);
            for (Steps s : rcp.getSteps())
              steps.add(s);
          }
          for (Steps s : steps)
          {
            if (s.getUtensilsSource() == s.getDestination()) // STEP_SINGLE
            {
              strSteps += String.format(Formatter.STEP_SINGLE, s.getAction(), s.getDestination(),
                  s.getDetails());
            }
            else if (s.getUtensilsSource() == null) // STEP_INGREDIENT
            {
              strSteps += String.format(Formatter.STEP_INGREDIENT, s.getAction(),
                  s.getIngredientSource(), s.getDestination(), s.getDetails()) + newLine;
            }
            else // STEP_MUL
            {
              strSteps += String.format(Formatter.STEP_MUL, s.getAction(), s.getUtensilsSource(),
                  s.getDestination(), s.getDetails()) + newLine;
            }
          }
          for (Utensils u : utensils)
          {
            strUtensils += String.format(Formatter.UTENSIL, u.getDetails(), u.getName()) + newLine;
          }
          ProcessViewer pv = new ProcessViewer(m.getName());
          pv.setUtensils(strUtensils);
          pv.setSteps(strSteps);
          dispose();
        }
      }
    }
    // If 'Choose File' is pressed, open fileChooser so the user can select a .rcp.
    if (e.getSource() == chooseFile)
    {
      if (typeBox.getSelectedItem().equals(recipe))
      {
        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter =
            new FileNameExtensionFilter(languageField.STRINGS.getString("recipes"), "rcp");
        fileChooser.setFileFilter(filter);
        fileSelection = fileChooser.showOpenDialog(this);
        try
        {
          fileName.setText(fileChooser.getSelectedFile().getName());
        }
        catch (NullPointerException npe)
        {
          fileName.setText("");
        }
      }
      else if (typeBox.getSelectedItem().equals(meal))
      {
        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter =
            new FileNameExtensionFilter(languageField.STRINGS.getString("meals"), "mel");
        fileChooser.setFileFilter(filter);
        fileSelection = fileChooser.showOpenDialog(this);
        try
        {
          fileName.setText(fileChooser.getSelectedFile().getName());
        } catch(NullPointerException npe)
        {
          fileName.setText("");
        }
      }
    }
    else if (e.getSource().equals(confirmType) && typeBox.getSelectedItem() != null)
    {
      gl = new GridLayout(2, 1);
      add(file);
      setSize(200, 250);
      setLayout(gl);
    }
  }
}
