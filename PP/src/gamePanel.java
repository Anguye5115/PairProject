import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;


public class gamePanel extends JPanel {
	
	JFrame frame;
	JPanel contentPane;
	
	gamePanel(/*int width, int height*/) {
//		setPreferredSize(new Dimension(width, height));
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		frame.setSize(500, 750);
		frame.setVisible(true);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.drawLine(10, 10, 480, 10);
		g.drawLine(480, 10, 480, 730);
		g.drawLine(480, 730, 10, 730);
		g.drawLine(10, 730, 10, 10);
		
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				gamePanel test = new gamePanel();
			}
		});
	}
}
