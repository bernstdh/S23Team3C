import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for a StepsPanel object.
 * @author Mike Buckingham
 *
 */
public class StepsPanelListener implements ActionListener
{
  public StepsPanelListener()
  {
    
  }
  
  public void actionPerformed(ActionEvent ae)
  {
    String command;
    command = ae.getActionCommand();
    if(command.equals("Add"))
    {
      
    }
    else if(command.equals("Delete"))
    {
      
    }
  }
}
