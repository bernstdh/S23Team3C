package utensil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

import ingredients.Formatter;
/**
 * A listener for the UtensilPanel class.
 * @author Mike Buckingham
 */
public class UtensilPanelListener implements ActionListener
{  
  private DefaultListModel<String> utensilListModel;
  private List<Utensils> utensilObjectList;
  private JList<String> utensilJList;
  private JTextField utensilNameBox, utensilDetailsBox;
  
  /**
   * Constructor for a UtensilPanelListener object.
   * @param utensilObjectList attribute from UtensilPanel
   * @param utensilNameBox attribute from UtensilPanel
   * @param utensilDetailsBox attribute from UtensilPanel
   * @param utensilJList attribute from UtensilPanel
   * @param utensilListModel attribute from UtensilPanel
   */
  public UtensilPanelListener(final JTextField utensilDetailsBox, 
      final List<Utensils> utensilObjectList, final JTextField utensilNameBox,  
      final JList<String> utensilJList, final DefaultListModel<String> utensilListModel)
  {
    this.utensilObjectList = utensilObjectList;
    this.utensilDetailsBox = utensilDetailsBox;
    this.utensilNameBox = utensilNameBox;
    this.utensilJList = utensilJList;
    this.utensilListModel = utensilListModel;
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
      String utensilName, utensilDetails;
      Utensils utensil;
      utensilName = utensilNameBox.getText();
      utensilDetails = utensilDetailsBox.getText();
    
      utensil = new Utensils(utensilName, utensilDetails);
      utensilObjectList.add(utensil);
      
      utensilListModel.addElement(String.format(
          Formatter.UTENSIL, utensil.getDetails(), utensil.getName()));
    }
    else if(command.equals("Delete"))
    {
      int[] indices = utensilJList.getSelectedIndices();
      for(int i = 0; i < indices.length; i++)
      {
        for(int j = 0; j < utensilListModel.size(); j++) 
        {
          if(j == indices[i]) 
          { 
            utensilListModel.remove(j);
            utensilObjectList.remove(j);
            
            int k = i;
            while(k < indices.length)
            {
              indices[k]--;
              k++;
            }         
            break;
          }
        }
      }
    }
  }
}
