package gui;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import app.languageField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.URL;
/**
 * Process Viewer.
 * @author Shaury Gautam & Beau Mueller
 *
 */

public class ProcessViewer extends JFrame implements Printable, ActionListener
{
	private static final long serialVersionUID = 1L;
	private JTextArea utensilBox;
	private JTextArea stepsBox;
	private JButton printButton;
	/**
	 * Process viewer constructor.
	 * @param name name of recipe/meal
	 */
	public ProcessViewer(final String name) 
	{
		super("KiLowBites " + languageField.STRINGS.getString("Process_V") + " \t" + name);

		utensilBox = new JTextArea(10, 30);
		utensilBox.setEditable(false);
		utensilBox.setLineWrap(true);
		utensilBox.setWrapStyleWord(true);
		JScrollPane utensilScroll = new JScrollPane(utensilBox,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		stepsBox = new JTextArea(20, 30);
		stepsBox.setEditable(false);
		stepsBox.setLineWrap(true);
		stepsBox.setWrapStyleWord(true);
		JScrollPane stepsScroll = new JScrollPane(stepsBox,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JPanel printPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		URL url = this.getClass().getResource("/icons/printButton.png");
    printButton = new JButton(new ImageIcon(url));
    printButton.addActionListener(this);
		printPanel.add(printButton);
		add(printPanel, BorderLayout.NORTH);
		
		JPanel topPanel = new JPanel(new BorderLayout());
		TitledBorder topBorder = new TitledBorder(languageField.STRINGS.getString("Utensils"));
		topBorder.setTitlePosition(TitledBorder.CENTER);
		topBorder.setBorder(new LineBorder(Color.black));
		topPanel.add(utensilScroll, BorderLayout.CENTER);
		topPanel.setBorder(topBorder);
		add(topPanel, BorderLayout.CENTER);

		JPanel bottomPanel = new JPanel(new BorderLayout());
		TitledBorder bottomBorder = new TitledBorder(languageField.STRINGS.getString("Steps"));
		bottomBorder.setTitlePosition(TitledBorder.CENTER);
		bottomBorder.setBorder(new LineBorder(Color.black));
		bottomPanel.add(stepsScroll, BorderLayout.CENTER);
		bottomPanel.setBorder(bottomBorder);
		add(bottomPanel, BorderLayout.SOUTH);

		setResizable(false); 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
	}

	
	/**
	 * setter.
	 * @param s string
	 */
	public void setUtensils(final String s) 
	{
		utensilBox.setText(s);
	}
	
	/**
	 * setter.
	 * @param s string
	 */
	public void setSteps(final String s) 
	{
		stepsBox.setText(s);
	}


  @Override
  public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException
  {
    double cH, cW, h, scale, w, x, y;
    Graphics2D g2;
    int status;
    
    g2 = (Graphics2D)graphics;
    
    status = Printable.NO_SUCH_PAGE;
    
    if(pageIndex == 0) {
      x = pageFormat.getImageableX();
      y = pageFormat.getImageableY();
      
      g2.translate(x, y);
      
      h = pageFormat.getImageableHeight();
      w = pageFormat.getImageableWidth();
      cW = (double)(this.getWidth());
      cH = (double)(this.getHeight());
      scale = Math.min(w/cW,  h/cH);
      g2.scale(scale,  scale);
      
      this.paint(g2);
      
      status = Printable.PAGE_EXISTS;
    }
    return status;
  }
  
  public void printProcess() {
    PrinterJob job = PrinterJob.getPrinterJob();
    PageFormat format = job.defaultPage();
    try {
      job.setPrintable(this, format);
      boolean shouldPrint = job.printDialog();
      if(shouldPrint) job.print();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  @Override
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource().equals(printButton)) {
      printProcess();
    }
    
  }

}

