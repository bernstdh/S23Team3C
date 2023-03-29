import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class KILowBites implements Runnable{

	private String[] args;
	private JFrame frame;
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(new KILowBites(args));

	}
	
	public KILowBites(final String[] args) {
		this.args = args;
	}
	
	public void run() {
		
		frame = new MainWindow("KILowBites");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}

}
