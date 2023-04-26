import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class gamePanel extends JPanel implements KeyListener {

	JFrame frame;
	
	int ballx = 375;
	int bally = 375;
	int balldx = 3;
	int balldy = 3;
	
	int playerx = 15;
	int playery = 375;
	int playerdx, playerdy;
	

	gamePanel() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addKeyListener(this);
		frame.add(this);
		frame.setSize(750, 750);
		frame.setVisible(true);
	}
	
	public void ballMvt() {
		int width = getWidth();
		int height = getHeight();

		ballx = ballx + balldx;
		bally = bally + balldy;
		
		if (ballx < 10) {
			balldx = -balldx;
			ballx = 10;
		} else if ((ballx + 50) > (width - 10)){
			balldx = -balldx;
			ballx = width - 60;
		}

		if (bally < 10) {
			balldy = -balldy;
			bally = 10;
		} else if ((bally + 50) > (height - 5)) {
			balldy = -balldy;
			bally = height - 60;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//code for the borders
		g.setColor(Color.BLACK);
		g.drawLine(10, 10, 730, 10);
		g.drawLine(730, 10, 730, 710);
		g.drawLine(730, 710, 10, 710);
		g.drawLine(10, 710, 10, 10);
		
		//code for ball mvt
		g.setColor(Color.PINK);
		g.fillOval(ballx, bally, 50, 50);
		
		//code for player mvt
		g.setColor(Color.MAGENTA);
		g.fillRect(15, 15, 15, 100);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);

				gamePanel test = new gamePanel();
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {
					public void run() {
						test.ballMvt();
						test.repaint();
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
				timer.schedule(task, 1, 1);
			}
		});
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("Testing");
		switch (e.getKeyChar()) {
		case KeyEvent.VK_W:
			System.out.println("W pressed");
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}
	
}
