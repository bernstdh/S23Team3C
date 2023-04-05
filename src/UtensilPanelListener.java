import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A listener for the UtensilPanel class.
 * @author Mike Buckingham
 */
public class UtensilPanelListener implements ActionListener
{
  private static final String NEWLINE = "\n";
  
  private List<Utensils> utensilList;
  private JTextArea utensilTextArea;
  private JTextField utensilNameBox, utensilDetailsBox;
  
  
  
  /**
   * Constructor for a UtensilPanelListener object.
   * @param utensilList attribute from UtensilPanel
   * @param utensilNameBox attribute from UtensilPanel
   * @param utensilDetailsBox attribute from UtensilPanel
   * @param utensilTextArea attribute from UtensilPanel
   */
  public UtensilPanelListener(final JTextField utensilDetailsBox, final List<Utensils> utensilList, 
      final JTextField utensilNameBox,  final JTextArea utensilTextArea)
  {
    this.utensilList = utensilList;
    this.utensilDetailsBox = utensilDetailsBox;
    this.utensilNameBox = utensilNameBox;
    this.utensilTextArea = utensilTextArea;
  }
  
  /**
   * Processes button input.
   * @param ae ActionEvent object
   */
  public void actionPerformed(final ActionEvent ae) 
  {
    String command;
    command = ae.getActionCommand();
    if(command.equals("Add"))
    {
      //string is added to list of utensils
      Utensils utensil;
      utensil = new Utensils(utensilNameBox.getText(), utensilDetailsBox.getText());
      utensilList.add(utensil);
      //also uploaded to text area
      utensilTextArea.setText(utensilTextArea.getText() 
          + String.format(Formatter.UTENSIL, utensil.getName(), utensil.getDetails()) + "\n");
    }
    else if(command.equals("Delete"))
    {
      if(utensilList.size() > 0) 
      { 
        String[] textAreaLines;
        
        utensilList.remove(utensilList.size() - 1);
        textAreaLines = utensilTextArea.getText().split("\n");
        utensilTextArea.setText("");
        for(int i = 0; i < textAreaLines.length - 1; i++) 
        {
          utensilTextArea.setText(utensilTextArea.getText() + textAreaLines[i] + NEWLINE);
        }    
      }
      //most previous line added is removed both
      //from the list and from the jtextarea
      
    }
  }
}
