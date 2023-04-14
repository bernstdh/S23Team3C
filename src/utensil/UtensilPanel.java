package utensil;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import recipe.RecipeEditor;
import steps.*;

/**
 * A JPanel used to construct and store Utensil objects.
 * @author Mike Buckingham
 *
 */
public class UtensilPanel extends JPanel 
    implements ActionListener, DocumentListener, ListSelectionListener
{ 
  private static final long serialVersionUID = 1L;
  
  private DefaultListModel<String> utensilListModel;
  private JButton utensilAddButton, utensilDeleteButton;
  private JLabel utensilNameLabel, utensilDetailsLabel;
  private JList<String> utensilJList;
  private JScrollPane utensilScrollPane;
  private JTextField utensilNameBox, utensilDetailsBox;
  private List<Utensils> utensilList;
  private RecipeEditor recipeEditor;
  private StepPanel stepPanel;
  
  /**
   * Constructor for a UtensilPanel object.
   * @param re RecipeEditor object
   */
  public UtensilPanel(final RecipeEditor re)
  {
    super();
    buildPanel();
    utensilList = new ArrayList<>();
    utensilAddButton.addActionListener(this);
    utensilDeleteButton.addActionListener(this);
    utensilDetailsBox.getDocument().addDocumentListener(this);
    utensilNameBox.getDocument().addDocumentListener(this);
    this.recipeEditor = re;
  }
  
  private void buildPanel()
  {    
    this.setBorder(BorderFactory.createTitledBorder("Utensils"));
    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    utensilAddButton = new JButton("Add");
    utensilAddButton.setEnabled(false);
    utensilDeleteButton = new JButton("Delete");
    utensilDeleteButton.setEnabled(false);
     
    utensilNameLabel = new JLabel("Name:");
    utensilDetailsLabel = new JLabel("Details:");
    
    utensilNameBox = new JTextField();
    utensilNameBox.setPreferredSize(new Dimension(175, 20));
    
    utensilDetailsBox = new JTextField();
    utensilDetailsBox.setPreferredSize(new Dimension(235, 20));
 
    utensilListModel = new DefaultListModel<>(); 
    utensilJList = new JList<>(utensilListModel);
    utensilJList.setPreferredSize(new Dimension(400, 300));
    utensilJList.addListSelectionListener(this);
    
    
    utensilScrollPane = new JScrollPane();
    utensilScrollPane.setViewportView(utensilJList);
    utensilScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    utensilScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    utensilScrollPane.setPreferredSize(new Dimension(400, 150));
    
    this.add(utensilNameLabel);
    this.add(utensilNameBox);
    this.add(utensilDetailsLabel);
    this.add(utensilDetailsBox);
    this.add(utensilAddButton); 
    this.add(utensilScrollPane);
    this.add(utensilDeleteButton);  
  }
  
  /**
   * Returns the DefaultListModel attribute.
   * @return utensilListModel
   */
  public DefaultListModel<String> getModel()
  {
    return utensilListModel;
  }
  
  /**
   * Returns the utensilList attribute.
   * @return utensilList
   */
  
  public List<Utensils> getUtensilList() 
  {
    return utensilList;
  }

  @Override
  public void actionPerformed(final ActionEvent ae)
  { 
    if(ae.getSource() == utensilAddButton)
    {
      Utensils utensil;
      utensil = new Utensils(utensilNameBox.getText(), utensilDetailsBox.getText());
      utensilList.add(utensil);
      utensilListModel.addElement(utensil.toString());
      recipeEditor.setChanged();
    }
    else if(ae.getSource() == utensilDeleteButton)
    {
      int[] indices = utensilJList.getSelectedIndices();
      int numRemoved = 0;
      for(int i : indices) 
      {
        int index = i - numRemoved;
        String utensilString = utensilListModel.get(index);
        utensilListModel.removeElementAt(index);
        numRemoved++;
        for(Utensils u: utensilList) 
        {
          if(u.toString().equals(utensilString))
          {
            utensilList.remove(u);
            break;
          }
        }
      }
      recipeEditor.setChanged();
    }
    stepPanel.updateBoxes();
  }
  
  /**
   * Sets the stepsPanel object.
   * @param sp stepPanel object
   */
  public void setStepsPanel(final StepPanel sp) 
  {
    this.stepPanel = sp;
  }

  private void processTextChanges(final DocumentEvent e) 
  {
    if(utensilNameBox.getText().equals("")) 
      utensilAddButton.setEnabled(false);
    else utensilAddButton.setEnabled(true);
  }
  
  @Override
  public void insertUpdate(final DocumentEvent e)
  {
    processTextChanges(e);
  }

  @Override
  public void removeUpdate(final DocumentEvent e)
  {
    processTextChanges(e);
  }

  @Override
  public void changedUpdate(final DocumentEvent e)
  {
    processTextChanges(e);
  }

  /**
   * Determines if any elements are selected. If not, the delete button is inaccessible.
   */
  @Override
  public void valueChanged(final ListSelectionEvent e)
  {
    if(utensilJList.isSelectionEmpty()) utensilDeleteButton.setEnabled(false);
    else utensilDeleteButton.setEnabled(true);
  }
  
  /**
   * Clears the utensilPanel.
   */
  public void reset()
  {
    utensilNameBox.setText("");
    utensilDetailsBox.setText("");
    utensilListModel.removeAllElements();
    utensilList.clear();
  }
  
  /**
   * Loads in a Utensils object from an open file.
   * @param u Utensil object
   */
  public void load(final Utensils u) 
  {
    utensilList.add(u);
    utensilListModel.addElement(u.toString());
  }
}
