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
	int balldy = 2;

	int playerx = 15;
	int playery = 330;
	int playerdx, playerdy;
	
	int compx = 710, compy = 330;
	int compdx; 
	int compdy = -1;

	private boolean gameOver = false;
	private int winner; //1 is player; 2 is bot

	private boolean upPressed = false;
	private boolean downPressed = false;

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

		//		if (ballx < 10) {
		//			gameOver = true;
		//			winner = 2;
		//		} else if ((ballx + 50) > (width - 10)) {
		//			gameOver = true;
		//			winner = 1;
		//		}

		//for testing
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

		if ((ballx == (playerx + 10)) && ((bally > playery) && (bally < playery + 100))) {
			balldx = -balldx;
			balldy = -balldy;
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
		g.fillRect(playerx, playery, 15, 100);
		
		g.fillRect(compx, compy, 15, 100);
	}

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_UP)) {
			upPressed = true;
//			playerdy = -1;
//			playery = playery + playerdy;
			playery-=15;
		}

		if ((e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
			downPressed = true;
//			playerdy = 1;
//			playery = playery + playerdy;
			playery+=15;
		}			
	}

	public void keyReleased(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
			upPressed = false;
			downPressed = false;
			playerdy = 0;
		}		
	}
	
	public void compMove() {
		boolean direction = true;
		if((compy+100==710) || (compy == 10)) {
			compdy = -compdy;
		}
		
		compy += compdy;	
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
						test.compMove();
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

}
