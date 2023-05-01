package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import app.languageField;
import items.Meals;
import items.Recipes;
import utilities.Serializer;
import java.awt.Color;
import java.awt.Dimension;

/**
 * MeadEditor window.
 * 
 * @author Julian Barrett
 *
 */
public class MealEditor extends JFrame implements ActionListener
{


  private static final long serialVersionUID = 1L;
  private final String spaces = "    ";
  private final String mel = ".mel";
  private JLabel nameLabel;
  private JTextField nameBox;
  private JButton addRecipeButton;
  private JButton deleteRecipeButton;

  private JButton newButton;
  private JButton openButton;
  private JButton saveButton;
  private JButton saveAsButton;
  private JButton closeButton;

  private Meals meal;
  //
  private JFileChooser fileChooser;
  private DefaultListModel<String> recipeListModel;
  private JList<String> jlistModel;
  private JScrollPane recipeScrollPane;

  private final String changedState = "changedState";
  private final String unchangedState = "unchangedState";
  private final String nullState = "nullState";
  private String state;


  /**
   * MealEditor class.
   */
  public MealEditor()
  {

    super(languageField.STRINGS.getString("KiLowBites"));
    // this.setSize(1200, 800);
    setResizable(false);
    this.state = nullState;    
    nameLabel = new JLabel(languageField.STRINGS.getString("NameLabel"));
    nameBox = new JTextField(35);
    nameBox.setEnabled(false);
    Dimension buttonSize = new Dimension(30, 30);
    
    UIManager.put("FileChooser.cancelButtonText", "Cancelar");


    newButton = new JButton(loadImageIcon("newButton.png"));
    newButton.setPreferredSize(buttonSize);
    newButton.addActionListener(this);
    // newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));

    openButton = new JButton(loadImageIcon("openButton.png"));
    openButton.setPreferredSize(buttonSize);
    openButton.addActionListener(this);
    openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));

    saveButton = new JButton(loadImageIcon("saveButton.png"));
    saveButton.setPreferredSize(buttonSize);
    saveButton.addActionListener(this);
    saveButton.setEnabled(state.equals(changedState));

    saveAsButton = new JButton(loadImageIcon("saveAsButton.png"));
    saveAsButton.setPreferredSize(buttonSize);
    saveAsButton.addActionListener(this);
    saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));

    closeButton = new JButton(loadImageIcon("closeButton.png"));
    closeButton.setPreferredSize(buttonSize);
    closeButton.addActionListener(this);
    closeButton.setEnabled(state.equals(unchangedState));

    // whooo hooo
    this.setLayout(new BorderLayout());

    // buttons on the top
    JPanel p = new JPanel();
    p.setLayout(new FlowLayout(FlowLayout.LEFT));
    p.add(newButton);
    p.add(openButton);
    p.add(saveButton);
    p.add(saveAsButton);
    p.add(closeButton);

    // name panel
    JPanel nameFrame = new JPanel();
    nameFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
    nameFrame.add(nameLabel);
    nameFrame.add(nameBox);
    nameBox.setEditable(true);
    nameBox.addActionListener(this);

    // buttons panel and name panels, inside a borderPnl
    JPanel borderPnl = new JPanel(new BorderLayout());
    borderPnl.add(p, BorderLayout.NORTH);
    borderPnl.add(nameFrame, BorderLayout.CENTER);
    this.add(borderPnl, BorderLayout.NORTH);

    // JPanel with the add recipe and delete button
    JPanel recipeBigPanel = new JPanel(new BorderLayout());

    JPanel addRecipeFlow = new JPanel(new BorderLayout());
    JPanel addRecipeButtonFlow = new JPanel(new FlowLayout(FlowLayout.LEFT));
    addRecipeButton = new JButton(languageField.STRINGS.getString("addRecipe"));
    addRecipeButton.addActionListener(this);
    addRecipeButton.setEnabled(!state.equals(nullState));
    addRecipeButtonFlow.add(addRecipeButton);
    addRecipeFlow.add(addRecipeButtonFlow, BorderLayout.NORTH);

    recipeListModel = new DefaultListModel<>();
    jlistModel = new JList<>(recipeListModel);
    jlistModel.setPreferredSize(new Dimension(400, 400));
    recipeScrollPane = new JScrollPane(jlistModel);
    recipeScrollPane.setViewportView(jlistModel);
    recipeScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    recipeScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    recipeScrollPane.setPreferredSize(new Dimension(325, 200));
    addRecipeFlow.add(recipeScrollPane, BorderLayout.CENTER);

    JPanel deletePanel = new JPanel(new BorderLayout());
    deleteRecipeButton = new JButton(languageField.STRINGS.getString("deleteRecipe"));
    deleteRecipeButton.addActionListener(this);
    deleteRecipeButton.setEnabled(false);
    deletePanel.add(deleteRecipeButton, BorderLayout.SOUTH);
    addRecipeFlow.add(deletePanel, BorderLayout.EAST);
    recipeBigPanel.add(addRecipeFlow, BorderLayout.CENTER);
    JPanel spacerP = new JPanel(new BorderLayout());
    spacerP.add(new JLabel(spaces));
    recipeBigPanel.add(spacerP, BorderLayout.SOUTH);
    JPanel spacerS = new JPanel(new BorderLayout());
    spacerS.add(new JLabel(spaces));
    recipeBigPanel.add(spacerS, BorderLayout.WEST);
    JPanel spacerE = new JPanel(new BorderLayout());
    spacerE.add(new JLabel("       "));
    recipeBigPanel.add(spacerE, BorderLayout.EAST);
    recipeBigPanel.setBorder(BorderFactory.createLineBorder(Color.black));

    JPanel spacerEast = new JPanel(new BorderLayout());
    JPanel spacerWest = new JPanel(new BorderLayout());
    JPanel spacerSouth = new JPanel(new BorderLayout());
    spacerSouth.add(new JLabel(spaces));
    spacerEast.add(new JLabel(spaces));
    spacerWest.add(new JLabel(spaces));
    this.add(spacerEast, BorderLayout.EAST);
    this.add(spacerWest, BorderLayout.WEST);
    this.add(spacerSouth, BorderLayout.SOUTH);
    this.fileChooser = new JFileChooser();
    // jk jk  
    // UIManager.put("FileChooser.cancelButtonText", "Cancelar");


    this.add(recipeBigPanel, BorderLayout.CENTER);
    // add to east and west
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600, 350);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);

  }

  @Override
  public void actionPerformed(final ActionEvent e)
  {

    if (e.getSource() == addRecipeButton)
    {
      if (this.state != nullState)
      {
        this.state = changedState;
        nameBox.setEnabled(true);
        newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
        openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
        saveButton.setEnabled(state.equals(changedState));
        saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
        closeButton.setEnabled(state.equals(unchangedState));
        int returnVal = fileChooser.showOpenDialog(MealEditor.this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
          File file = fileChooser.getSelectedFile();
          String tempFileName = file.toString();
          try
          {
            if (tempFileName.contains(".rcp"))
            {
              meal.addRecipe(Serializer.deserializeRecipe(tempFileName));
              recipeListModel
                  .addElement(meal.getRecipes().get(meal.getRecipes().size() - 1).getName());
            }
          }
          catch (IOException | ClassNotFoundException ia)
          {
            System.out.println("Did not select .rcp file");
          }
        }
      }
    }
    else if (e.getSource() == deleteRecipeButton)
    {
      if (!state.equals(nullState)) 
      {
        newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
        openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
        saveButton.setEnabled(state.equals(changedState));
        saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
        closeButton.setEnabled(state.equals(unchangedState));
        int index = this.jlistModel.getSelectedIndex();
        recipeListModel.remove(index);
        this.meal.getRecipes().remove(index);
      }
    }
    else if (e.getSource() == openButton)
    {
      nameBox.setEnabled(true);
      this.state = unchangedState;
      deleteRecipeButton.setEnabled(true);
      addRecipeButton.setEnabled(true);
      newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
      openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
      saveButton.setEnabled(state.equals(changedState));
      saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
      closeButton.setEnabled(state.equals(unchangedState));
      int returnVal = fileChooser.showOpenDialog(MealEditor.this);
      if (returnVal == JFileChooser.APPROVE_OPTION)
      {
        File file = fileChooser.getSelectedFile();
        String tempFileName = file.getName();
        try
        {
          if (tempFileName.contains(mel))
          {
            this.meal = Serializer.deserializeMeal(tempFileName);
            this.recipeListModel.removeAllElements();
            nameBox.setText(this.meal.getName());
          }
          for (int i = 0; i < meal.getRecipes().size(); i++)
          {
            this.recipeListModel.addElement(meal.getRecipes().get(i).getName());
          }
        }
        catch (IOException | ClassNotFoundException ia)
        {
          System.out.println("Did not select correct file");
        }
      }
    }
    else if (e.getSource() == newButton)
    {
      nameBox.setEnabled(true);
      nameBox.setText("");
      this.state = unchangedState;
      addRecipeButton.setEnabled(true);
      deleteRecipeButton.setEnabled(true);
      newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
      openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
      saveButton.setEnabled(state.equals(changedState));
      saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
      closeButton.setEnabled(state.equals(unchangedState));
      this.meal = new Meals("", new ArrayList<Recipes>());
      this.recipeListModel.removeAllElements();
    }
    else if (e.getSource() == saveButton)
    {
      nameBox.setEnabled(true);
      this.state = unchangedState;
      newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
      openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
      saveButton.setEnabled(state.equals(changedState));
      saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
      closeButton.setEnabled(state.equals(unchangedState));
      try
      {
        Serializer.serializeMeal(this.meal);
      }
      catch (IOException e1)
      {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
    else if (e.getSource() == saveAsButton)
    {
      nameBox.setEnabled(true);
      this.state = unchangedState;
      newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
      openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
      saveButton.setEnabled(state.equals(changedState));
      saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
      closeButton.setEnabled(state.equals(unchangedState));
      File newFile = new File(this.meal.getName() + mel);
      fileChooser.setSelectedFile(newFile);
      // int returnVal =
      fileChooser.showSaveDialog(MealEditor.this);
      try
      {
        Serializer.serializeMeal(fileChooser.getCurrentDirectory().toString(), meal);
      }
      catch (IOException e1)
      {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
    else if (e.getSource() == closeButton)
    {
      this.state = nullState;
      newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
      openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
      saveButton.setEnabled(state.equals(changedState));
      saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
      closeButton.setEnabled(state.equals(unchangedState));
      this.dispose();
    }
    else if (e.getSource() == nameBox)
    {
      if (this.state != nullState)
      {
        this.state = changedState;
        newButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
        openButton.setEnabled(state.equals(unchangedState) || state.equals(nullState));
        saveButton.setEnabled(state.equals(changedState));
        saveAsButton.setEnabled(state.equals(unchangedState) || state.equals(changedState));
        closeButton.setEnabled(state.equals(unchangedState));
        meal.setName(nameBox.getText());
      }
    }
  }

  /**
   * loads a new ImageIcon from icons package.
   * 
   * @param name
   *          for png name.
   * @return a new ImageIcon.
   */
  private ImageIcon loadImageIcon(final String name)
  {
    URL url = this.getClass().getResource("/icons/" + name);
    ImageIcon icon = new ImageIcon(url);
    return icon;
  }

}
