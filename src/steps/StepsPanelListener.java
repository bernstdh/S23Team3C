package steps;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 * Listener for a StepsPanel object.
 * @author Mike Buckingham
 *
 */
public class StepsPanelListener implements ActionListener
{
  private DefaultListModel<String> stepsListModel;
  private JComboBox<String> stepsActionBox, stepsOnBox, stepsUtensilBox;
  private JList<String> stepsJList;
  private JTextField stepsDetailsBox;
  private List<Steps> stepsObjectList;
  
 
  /**
   * Constructor for a StepsPanelListener object.
   * @param stepsListModel 
   * @param stepsActionBox
   * @param stepsOnBox
   * @param stepsUtensilBox
   * @param stepsJList
   * @param stepsDetailsBox
   * @param stepsObjectList
   */

  public StepsPanelListener(final DefaultListModel<String> stepsListModel, 
      final JComboBox<String> stepsActionBox, final JComboBox<String> stepsOnBox, 
      final JComboBox<String> stepsUtensilBox, final JList<String> stepsJList,
      final JTextField stepsDetailsBox, final List<Steps> stepsObjectList)
  {
    this.stepsListModel = stepsListModel;
    this.stepsActionBox = stepsActionBox;
    this.stepsOnBox = stepsOnBox;
    this.stepsUtensilBox = stepsUtensilBox;
    this.stepsJList = stepsJList;
    this.stepsDetailsBox = stepsDetailsBox;
    this.stepsObjectList = stepsObjectList;
  }
  
  /**
   * Processes inputs for the add and delete buttons.
   * @param ae ActionEvent object.
   */
  public void actionPerformed(final ActionEvent ae)
  {
    String command;
    command = ae.getActionCommand();
    if(command.equals("Add"))
    {
      String action, details;
      action = (String)stepsActionBox.getSelectedItem();
      details = stepsDetailsBox.getText();
      
      
      //temp to test if remove method other stuff still works
      stepsListModel.addElement(action);
      stepsListModel.addElement(details);
    }
    else if(command.equals("Delete"))
    {
      int[] indices = stepsJList.getSelectedIndices();
      for(int i = 0; i < indices.length; i++)
      {
        for(int j = 0; j < stepsListModel.size(); j++) 
        {
          if(j == indices[i]) 
          { 
            stepsListModel.remove(j);
            stepsObjectList.remove(j);
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
