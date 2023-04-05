

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * A JPanel used to construct and store Utensil objects.
 * @author Mike Buckingham
 *
 */
public class UtensilPanel extends JPanel
{ 
  private static final long serialVersionUID = 1L;
  
  private DefaultListModel<String> utensilListModel;
  private JButton utensilAddButton, utensilDeleteButton;
  private JLabel utensilNameLabel, utensilDetailsLabel;
  private JList<String> utensilJList;
  private JScrollPane utensilScrollPane;
  private JTextField utensilNameBox, utensilDetailsBox;
  private List<Utensils> utensilList;
  private UtensilPanelListener utensilListener;
  
  /**
   * Constructor for a UtensilPanel object.
   */
  public UtensilPanel()
  {
    super();
    
    buildPanel();
    utensilList = new ArrayList<>();
    utensilListener = new UtensilPanelListener(utensilDetailsBox, utensilList, 
        utensilNameBox, utensilJList, utensilListModel);
    utensilAddButton.addActionListener(utensilListener);
    utensilDeleteButton.addActionListener(utensilListener);
  }
  
  private void buildPanel()
  {    
    this.setBorder(BorderFactory.createTitledBorder("Utensils"));
    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    utensilAddButton = new JButton("Add");
    utensilDeleteButton = new JButton("Delete");
     
    utensilNameLabel = new JLabel("Name:");
    utensilDetailsLabel = new JLabel("Details:");
    
    utensilNameBox = new JTextField();
    utensilNameBox.setPreferredSize(new Dimension(175, 20));
    
    utensilDetailsBox = new JTextField();
    utensilDetailsBox.setPreferredSize(new Dimension(235, 20));
 
    utensilListModel = new DefaultListModel<>(); 
    utensilJList = new JList<>(utensilListModel);
    utensilJList.setPreferredSize(new Dimension(400, 300));
    
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
}
