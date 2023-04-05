import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A JPanel used to construct and store ingredients.
 * @author Mike Buckingham
 *
 */
public class IngredientPanel extends JPanel
{
  private static final long serialVersionUID = 1L;
  private IngredientPanelListener ingredientListener;
  private JButton ingredientsAddButton, ingredientsDeleteButton;
  private JComboBox<String> ingredientsUnitsBox;
  private JLabel ingredientsAmountLabel, ingredientsDetailsLabel, 
      ingredientsNameLabel, ingredientsUnitsLabel;
  private JScrollPane ingredientsScrollPane;
  private JTextArea ingredientsTextArea;
  private JTextField ingredientsAmountBox, ingredientsDetailsBox, ingredientsNameBox;
  private List<Ingredient> ingredientList;
  /**
   * Constructor for an Ingredients Panel object.
   */
  public IngredientPanel() 
  {
    super();
    buildPanel();
    ingredientList = new ArrayList<>();
    ingredientListener = new IngredientPanelListener(ingredientsAmountBox, ingredientsDetailsBox, 
        ingredientList, ingredientsNameBox, ingredientsTextArea, ingredientsUnitsBox);
    ingredientsAddButton.addActionListener(ingredientListener);
    ingredientsDeleteButton.addActionListener(ingredientListener);
  }
  
  private void buildPanel()
  {

    this.setBorder(BorderFactory.createTitledBorder("Ingredients"));
    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    ingredientsNameLabel = new JLabel("Name");
    ingredientsDetailsLabel = new JLabel("Details");
    ingredientsAmountLabel = new JLabel("Amount");
    ingredientsUnitsLabel = new JLabel("Units:");
    
    ingredientsNameBox = new JTextField();
    ingredientsNameBox.setPreferredSize(new Dimension(80, 20));
    ingredientsDetailsBox = new JTextField();
    ingredientsDetailsBox.setPreferredSize(new Dimension(60, 20));
    ingredientsAmountBox = new JTextField();
    ingredientsAmountBox.setPreferredSize(new Dimension(80, 20));
    
    ingredientsUnitsBox = new JComboBox<>();
    ingredientsUnitsBox.setPreferredSize(new Dimension(100, 20));
    ingredientsUnitsBox.setEditable(false);
    ingredientsUnitsBox.addItem("cup");
    ingredientsUnitsBox.addItem("dr");
    ingredientsUnitsBox.addItem("floz");
    ingredientsUnitsBox.addItem("g");
    ingredientsUnitsBox.addItem("gal");
    ingredientsUnitsBox.addItem("individual");
    ingredientsUnitsBox.addItem("lbs");
    ingredientsUnitsBox.addItem("ml");
    ingredientsUnitsBox.addItem("oz");
    ingredientsUnitsBox.addItem("p");
    ingredientsUnitsBox.addItem("pt");
    ingredientsUnitsBox.addItem("qt");
    ingredientsUnitsBox.addItem("tbs");
    ingredientsUnitsBox.addItem("tsp");

    ingredientsAddButton = new JButton("Add");
    ingredientsDeleteButton = new JButton("Delete");
    
    ingredientsTextArea = new JTextArea();
    ingredientsTextArea.setEditable(false);
    ingredientsTextArea.setPreferredSize(new Dimension(450, 300));
    ingredientsTextArea.setLineWrap(true);
    ingredientsScrollPane = new JScrollPane(ingredientsTextArea);
    ingredientsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    ingredientsScrollPane.setPreferredSize(new Dimension(400, 150));
    
    this.add(ingredientsNameLabel);
    this.add(ingredientsNameBox);
    this.add(ingredientsDetailsLabel);
    this.add(ingredientsDetailsBox);
    this.add(ingredientsAmountLabel);
    this.add(ingredientsAmountBox);
    this.add(ingredientsUnitsLabel);
    this.add(ingredientsUnitsBox);
    this.add(ingredientsAddButton);
    this.add(ingredientsScrollPane);
    this.add(ingredientsDeleteButton);
  }
  
}