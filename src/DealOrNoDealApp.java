import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class DealOrNoDealApp {
	public static void main (String [] args){
		boolean continueGame = true;
		JFrame window = new JFrame("Deal or No Deal");
	    DealOrNoDealPanel content = new DealOrNoDealPanel();
	    window.setContentPane(content);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	    window.setLocation( (screensize.width - 800)/2, 
	                                 (screensize.height - 600)/2);
	    window.setSize(800,600);
	    window.setVisible(true);
	}
}
