import java.awt.*;
import javax.swing.*;

/**
 * GUI used to open, save, and edit recipes.
 * @author Mike Buckingham (gui components)
 */
public class RecipeEditor extends JFrame
{
  private static final long serialVersionUID = 1L;
 
  
  private JButton closeButton, newButton, 
          openButton, saveAsButton, saveButton;
  private JPanel buttonPanel, recipeAttributesPanel, recipePanel, topPanel;
  private JTextField numberServedBox, recipeNameBox;
  private IngredientPanel ingredientsPanel;

  private StepPanel stepsPanel;
  private UtensilPanel utensilsPanel;
 
 

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
    
    topPanel = new JPanel();
    topPanel.setLayout(new GridLayout(2, 1));
    topPanel.add(buttonPanel);
    topPanel.add(recipeAttributesPanel);
    this.add(topPanel, BorderLayout.NORTH);
    
    recipePanel = new JPanel();
    recipePanel.setLayout(new GridLayout(3, 1));
    
    ingredientsPanel = new IngredientPanel();
    stepsPanel = new StepPanel();
    utensilsPanel = new UtensilPanel();
    
    recipePanel.add(utensilsPanel);
    recipePanel.add(ingredientsPanel);
    recipePanel.add(stepsPanel);
    
    this.add(recipePanel, BorderLayout.CENTER);
    this.setVisible(true);
  }
  
  // GUI  helper methods
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
  
  private void buildRecipeAttributesPanel()
  {
    JLabel recipeNameLabel, numberServedLabel;
    recipeAttributesPanel = new JPanel();
    recipeAttributesPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    recipeNameLabel = new JLabel("Name:");
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
}
