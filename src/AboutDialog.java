import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * About Dialog.
 * @author Shaury Gautam
 *
 */
public class AboutDialog 
{
	/**
	 * Constructor.
	 */
	public AboutDialog() 
	{
		JFrame frame = new JFrame("About Dialog");

		JLabel label = new JLabel("Hello, world!");

		frame.add(label);

		frame.setSize(300, 200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
