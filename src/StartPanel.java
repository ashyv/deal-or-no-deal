import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StartPanel extends JPanel{
	BufferedImage image;	
	
	public StartPanel(){	 

	       try {                
	          image = ImageIO.read(new File("deal_or_no_deal.gif"));
	       } catch (IOException ex) {
	            // handle exception...
	       }
		
	}
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		
		/*g.setColor(new Color(216, 210, 121));
		for (int x = 0; x < 800; x += 15){
			for (int y = 0; y < 500; y+= 15){
				g.fillOval(x, y, 7, 7);
			}
		}
		*/
	}	
	
}
