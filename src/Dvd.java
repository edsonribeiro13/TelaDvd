
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.lang.Thread;

public class Dvd extends JFrame{
	
	public static void main (String[] args) {
		JFrame frame = new JFrame();
		JLabel label = new JLabel();
		BufferedImage img = new ImgUtils().scaleImage(50,50,"C:\\Users\\UESB-USR\\eclipse-workspace\\TelaDvd\\src\\download.png");
		label.setIcon(new ImageIcon(img));
		JPanel panel = new JPanel();
		
		label.setBounds(0, 0, 50, 50);
		
		
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		panel.setSize(700, 700);
		panel.add(label);
		panel.setVisible(true);
		
		frame.setVisible(true);
		frame.setSize(700, 700);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(panel);
		
		boolean contX = false;
		boolean contY = false;
		
		while(true) {
			if (contX == false) {
				label.setLocation(label.getLocation().x + 3, label.getLocation().y);
				if(label.getLocation().x >= 635)
					contX = true;
			}
			else {
				label.setLocation(label.getLocation().x - 3, label.getLocation().y);
				if(label.getLocation().x <= 0)
					contX = false;
			}
			if (contY == false) {
				label.setLocation(label.getLocation().x, label.getLocation().y + 2);
				if(label.getLocation().y >= 610)
					contY = true;
			}
			else {
				label.setLocation(label.getLocation().x, label.getLocation().y - 2);
				if(label.getLocation().y <= 0)
					contY = false;
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public static class ImgUtils {

		public BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
		    BufferedImage bi = null;
		    try {
		        ImageIcon ii = new ImageIcon(filename);//path to image
		        bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		        Graphics2D g2d = (Graphics2D) bi.createGraphics();
		        g2d.addRenderingHints((Map<?, ?>) new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
		        g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
		    return bi;
		}

		 }
}
