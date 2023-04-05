import javax.swing.*;
import java.awt.*;

/**
 * A JPanel used to construct and store steps of a recipe.
 * @author Mike Buckingham
 *
 */
public class StepPanel extends JPanel
{
  private static final long serialVersionUID = 1L;
  private JButton stepsAddButton, stepsDeleteButton;
  private JComboBox<String> stepsActionBox, stepsOnBox, stepsUtensilBox;
  private JScrollPane stepsScrollPane;
  private JTextArea stepsTextArea;
  private JTextField stepsDetailsBox;
  
  /**
   * Constructor for a StepPanel object.
   */
  public StepPanel()
  {
    super();
    buildPanel();
  }
  
  private void buildPanel()
  {
    JLabel stepsActionLabel, stepsOnLabel, stepsUtensilLabel, stepsDetailsLabel;

    this.setBorder(BorderFactory.createTitledBorder("Steps"));
    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    stepsActionLabel = new JLabel("Action:");
    stepsOnLabel = new JLabel("On:");
    stepsUtensilLabel = new JLabel("Utensil:");
    stepsDetailsLabel = new JLabel("Details");
    
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
    
    stepsAddButton = new JButton("Add");
    stepsDeleteButton = new JButton("Delete");
    
    this.add(stepsActionLabel);
    this.add(stepsActionBox);
    this.add(stepsOnLabel);
    this.add(stepsOnBox);
    this.add(stepsUtensilLabel);
    this.add(stepsUtensilBox);
    this.add(stepsDetailsLabel);
    this.add(stepsDetailsBox);
    this.add(stepsAddButton);
    this.add(stepsScrollPane);
    this.add(stepsDeleteButton);
  }
}
