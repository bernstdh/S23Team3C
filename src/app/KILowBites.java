package app;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * The driver class for the KILowBites program.
 * @author Beau Mueller
 *
 */
public class KILowBites implements Runnable
{

	@SuppressWarnings("unused")
  private String[] args;
	private JFrame frame;
	
	/**
   * Sets the local arguments array to the parameter passed in.
   * @param args The array of arguments (if needed).
   */
  public KILowBites (final String[] args)
  {
    this.args = args;
  }
	/**
	 * 
	 * @param args Command line arguments (if needed).
	 * @throws InvocationTargetException When there's an InvocationTargetException
	 * @throws InterruptedException      When there's an InterruptedException
	 */
	public static void main(final String[] args) throws InvocationTargetException,
	  InterruptedException
	{
		SwingUtilities.invokeAndWait(new KILowBites(args));
	}
	
	/**
	 * Starts the program (basically a second main method).
	 */
	public void run()
	{
		
		frame = new MainWindow("KILowBites");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}

}
