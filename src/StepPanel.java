import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A JPanel used to construct and store steps of a recipe.
 * @author Mike Buckingham
 *
 */
public class StepPanel extends JPanel
{
  private static final long serialVersionUID = 1L;
  private DefaultListModel<String> stepsListModel;
  private JButton stepsAddButton, stepsDeleteButton;
  private JComboBox<String> stepsActionBox, stepsOnBox, stepsUtensilBox;
  private JList<String> stepsJList;
  private JScrollPane stepsScrollPane;
  private JTextField stepsDetailsBox;
  private List<Steps> stepsObjectList;
  private StepsPanelListener stepsListener;
  
  /**
   * Constructor for a StepPanel object.
   */
  public StepPanel()
  {
    super();
    buildPanel();
    stepsObjectList = new ArrayList<>();
    stepsListener = new StepsPanelListener(stepsListModel, stepsActionBox, stepsOnBox, 
        stepsUtensilBox, stepsJList, stepsDetailsBox, stepsObjectList);
    stepsAddButton.addActionListener(stepsListener);
    stepsDeleteButton.addActionListener(stepsListener);
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
    
    stepsActionBox.addItem("air-fry");
    stepsActionBox.addItem("bake");
    stepsActionBox.addItem("boil");
    stepsActionBox.addItem("cook");
    stepsActionBox.addItem("dip");
    stepsActionBox.addItem("fry");
    stepsActionBox.addItem("drain");
    stepsActionBox.addItem("heat");
    stepsActionBox.addItem("ignite");
    stepsActionBox.addItem("melt");
    stepsActionBox.addItem("put");
    stepsActionBox.addItem("saute");
    stepsActionBox.addItem("sear");
    stepsActionBox.addItem("simmer");
    
    
    stepsOnBox = new JComboBox<>();
    stepsOnBox.setPreferredSize(new Dimension(60, 20));
    stepsOnBox.setEditable(false);
    stepsUtensilBox = new JComboBox<>();
    stepsUtensilBox.setPreferredSize(new Dimension(90, 20));
    stepsUtensilBox.setEditable(false);
    stepsDetailsBox = new JTextField();
    stepsDetailsBox.setPreferredSize(new Dimension(90, 20));
    
    stepsListModel = new DefaultListModel<String>();

    stepsJList = new JList<>(stepsListModel);
    stepsJList.setPreferredSize(new Dimension(400, 300));
   
    stepsScrollPane = new JScrollPane(stepsJList);
    stepsScrollPane.setPreferredSize(new Dimension(400, 150));
    stepsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    stepsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
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
