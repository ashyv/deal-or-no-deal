import java.awt.Color;
import java.awt.*;
import javax.swing.*;


public class EndPanel extends JPanel{
	public EndPanel(){
		setBackground(Color.black);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(new Color(216, 210, 121));
		for (int x = 0; x < 800; x += 15){
			for (int y = 0; y < 500; y+= 15){
				g.fillOval(x, y, 7, 7);
			}
		}	
		g.setColor(Color.YELLOW);
		g.fill3DRect(250, 50, 300, 400, true);
		
		g.setColor(Color.black);
		g.setFont(new Font ("Sans Seriff", Font.BOLD, 18));
		g.drawString("Congratulations! You won", 280, 80);
		
	}	
}
