import java.awt.*;
import javax.swing.*;

/**
 * GUI used to open, save, and edit recipes.
 * @author Mike Buckingham (gui components)
 */
public class RecipeEditor extends JFrame
{
  private static final long serialVersionUID = 1L;
  private static final String ADD = "Add";
  private static final String DELETE = "Delete";
  private static final String DETAILS = "Details:";
  private static final String NAME = "Name:";
  
  private JButton closeButton, ingredientsAddButton, ingredientsDeleteButton, newButton, 
          openButton, saveAsButton, saveButton, stepsAddButton, stepsDeleteButton, 
          utensilAddButton, utensilDeleteButton;
  private JComboBox<String> ingredientsUnitsBox, stepsActionBox, stepsOnBox, stepsUtensilBox;
  private JPanel buttonPanel, ingredientsPanel, recipeAttributesPanel, 
      recipePanel, stepsPanel, utensilsPanel, topPanel;
  private JTextArea ingredientsTextArea, stepsTextArea, utensilsTextArea;
  private JTextField ingredientsAmountBox, ingredientsDetailsBox, ingredientsNameBox, 
          numberServedBox, recipeNameBox, stepsDetailsBox, utensilNameBox, utensilDetailsBox;

  /**
   * Constructor for the RecipeEditor Window.
   */
  public RecipeEditor()
  {
    super("KiLowBites Recipe Editor");
    this.setLayout(new BorderLayout());
    this.setSize(new Dimension(600, 800));
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    buildButtonPanel();
    buildRecipeAttributesPanel();
    buildUtensilPanel();
    buildIngredientsPanel();
    buildStepsPanel();
    
    topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(2, 1));
    topPanel.add(buttonPanel);
    topPanel.add(recipeAttributesPanel);
    this.add(topPanel, BorderLayout.NORTH);
    
    recipePanel = new JPanel();
    recipePanel.setLayout(new GridLayout(3, 1));
    recipePanel.add(utensilsPanel);
    recipePanel.add(ingredientsPanel);
    recipePanel.add(stepsPanel);
    
    this.add(recipePanel, BorderLayout.CENTER);
  }
  
  //gui methods
  private void buildButtonPanel()
  {
    final Dimension buttonSize;
    buttonSize = new Dimension(30, 30);
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    newButton = new JButton(new ImageIcon("newButton.png"));
    newButton.setPreferredSize(buttonSize);
    openButton = new JButton(new ImageIcon("openButton.png"));
    openButton.setPreferredSize(buttonSize);
    saveButton = new JButton(new ImageIcon("saveButton.png"));
    saveButton.setPreferredSize(buttonSize);
    saveAsButton = new JButton(new ImageIcon("saveAsButton.png"));
    saveAsButton.setPreferredSize(buttonSize);
    closeButton = new JButton(new ImageIcon("closeButton.png"));
    closeButton.setPreferredSize(buttonSize);
    
    buttonPanel.add(newButton);
    buttonPanel.add(openButton);
    buttonPanel.add(saveButton);
    buttonPanel.add(saveAsButton);
    buttonPanel.add(closeButton);
  }
  
  private void buildIngredientsPanel()
  {
    JLabel ingredientsAmountLabel, ingredientsDetailsLabel, 
        ingredientsNameLabel, ingredientsUnitsLabel;
    JScrollPane ingredientsScrollPane;
    
    ingredientsPanel = new JPanel();
    ingredientsPanel.setBorder(BorderFactory.createTitledBorder("Ingredients"));
    ingredientsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    ingredientsNameLabel = new JLabel(NAME);
    ingredientsDetailsLabel = new JLabel(DETAILS);
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

    ingredientsAddButton = new JButton(ADD);
    ingredientsDeleteButton = new JButton(DELETE);
    
    ingredientsTextArea = new JTextArea();
    ingredientsTextArea.setEditable(false);
    ingredientsTextArea.setPreferredSize(new Dimension(450, 300));
    ingredientsTextArea.setLineWrap(true);
    ingredientsScrollPane = new JScrollPane(ingredientsTextArea);
    ingredientsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    ingredientsScrollPane.setPreferredSize(new Dimension(400, 150));
    
    ingredientsPanel.add(ingredientsNameLabel);
    ingredientsPanel.add(ingredientsNameBox);
    ingredientsPanel.add(ingredientsDetailsLabel);
    ingredientsPanel.add(ingredientsDetailsBox);
    ingredientsPanel.add(ingredientsAmountLabel);
    ingredientsPanel.add(ingredientsAmountBox);
    ingredientsPanel.add(ingredientsUnitsLabel);
    ingredientsPanel.add(ingredientsUnitsBox);
    ingredientsPanel.add(ingredientsAddButton);
    ingredientsPanel.add(ingredientsScrollPane);
    ingredientsPanel.add(ingredientsDeleteButton);
  }
  
  private void buildRecipeAttributesPanel()
  {
    JLabel recipeNameLabel, numberServedLabel;
    recipeAttributesPanel = new JPanel();
    recipeAttributesPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    recipeNameLabel = new JLabel(NAME);
    recipeNameBox = new JTextField();
    recipeNameBox.setPreferredSize(new Dimension(220, 20));
    recipeAttributesPanel.add(recipeNameLabel);
    recipeAttributesPanel.add(recipeNameBox);
 
    numberServedLabel = new JLabel("Serves:" );
    numberServedBox = new JTextField();
    numberServedBox.setPreferredSize(new Dimension(60, 20));
    recipeAttributesPanel.add(numberServedLabel);
    recipeAttributesPanel.add(numberServedBox);
  }
  
  private void buildStepsPanel()
  {
    JLabel stepsActionLabel, stepsOnLabel, stepsUtensilLabel, stepsDetailsLabel;
    JScrollPane stepsScrollPane;

    stepsPanel = new JPanel();
    stepsPanel.setBorder(BorderFactory.createTitledBorder("Steps"));
    stepsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    stepsActionLabel = new JLabel("Action:");
    stepsOnLabel = new JLabel("On:");
    stepsUtensilLabel = new JLabel("Utensil:");
    stepsDetailsLabel = new JLabel(DETAILS);
    
    stepsActionBox = new JComboBox<>();
    stepsActionBox.setPreferredSize(new Dimension(80, 20));
    stepsActionBox.setEditable(false);
    stepsOnBox = new JComboBox<>();
    stepsOnBox.setPreferredSize(new Dimension(60, 20));
    stepsOnBox.setEditable(false);
    stepsUtensilBox = new JComboBox<>();
    stepsUtensilBox.setPreferredSize(new Dimension(90, 20));
    stepsUtensilBox.setEditable(false);
    stepsDetailsBox = new JTextField();
    stepsDetailsBox.setPreferredSize(new Dimension(90, 20));
    
    stepsTextArea = new JTextArea();
    stepsTextArea.setEditable(false);
    stepsTextArea.setPreferredSize(new Dimension(450, 300));
    stepsTextArea.setLineWrap(true);
   
    stepsScrollPane = new JScrollPane(stepsTextArea);
    stepsScrollPane.setPreferredSize(new Dimension(400, 150));
    stepsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
    stepsAddButton = new JButton(ADD);
    stepsDeleteButton = new JButton(DELETE);
    
    stepsPanel.add(stepsActionLabel);
    stepsPanel.add(stepsActionBox);
    stepsPanel.add(stepsOnLabel);
    stepsPanel.add(stepsOnBox);
    stepsPanel.add(stepsUtensilLabel);
    stepsPanel.add(stepsUtensilBox);
    stepsPanel.add(stepsDetailsLabel);
    stepsPanel.add(stepsDetailsBox);
    stepsPanel.add(stepsAddButton);
    stepsPanel.add(stepsScrollPane);
    stepsPanel.add(stepsDeleteButton);
  }
  
  private void buildUtensilPanel()
  {
    JLabel utensilNameLabel, utensilDetailsLabel;
    JScrollPane utensilScrollPane;
    
    utensilAddButton = new JButton(ADD);
    utensilDeleteButton = new JButton(DELETE);
    
    utensilNameLabel = new JLabel(NAME);
    utensilDetailsLabel = new JLabel(DETAILS);
    
    utensilNameBox = new JTextField();
    utensilNameBox.setPreferredSize(new Dimension(175, 20));
    
    utensilDetailsBox = new JTextField();
    utensilDetailsBox.setPreferredSize(new Dimension(235, 20));
    
    utensilsTextArea = new JTextArea();
    utensilsTextArea.setEditable(false);
    utensilsTextArea.setPreferredSize(new Dimension(450, 300));
    utensilsTextArea.setLineWrap(true);
    utensilScrollPane = new JScrollPane(utensilsTextArea);
    utensilScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    utensilScrollPane.setPreferredSize(new Dimension(400, 150));
    
    utensilsPanel = new JPanel();
    utensilsPanel.setBorder(BorderFactory.createTitledBorder("Utensils"));
    utensilsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    utensilsPanel.add(utensilNameLabel);
    utensilsPanel.add(utensilNameBox);
    utensilsPanel.add(utensilDetailsLabel);
    utensilsPanel.add(utensilDetailsBox);
    utensilsPanel.add(utensilAddButton);
    utensilsPanel.add(utensilScrollPane);
    utensilsPanel.add(utensilDeleteButton); 
  }
}
