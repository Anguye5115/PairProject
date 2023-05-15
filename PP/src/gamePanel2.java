import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class gamePanel2 extends JPanel implements KeyListener {

	JFrame frame;
	JPanel panel;
	JLabel score; 
	
	static player p = new player();
	static computer c = new computer();
	static ball b = new ball();
	
	static int[] ball;

	private boolean signal = false;
	
	int ballx = 375;
	int bally = 375;
	int balldx = 3;
	int balldy = 2;
	boolean ballUp = true;

	int playerx = 15;
	int playery = 330;
	int playerdx, playerdy;
	
	int compx = 710, compy = 330;
	int compdx; 
	int compdy = -5;
	
	static int playerScore = 0;
	static int compScore = 0;

	private boolean gameOver = false;
	private int winner; //1 is player; 2 is bot

	public void display(JFrame frame, JPanel panel) {
		this.frame = frame;
		this.panel = panel;	
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.add(this);
		frame.setSize(750, 750);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		//how do you make this show
		score = new JLabel("Player Score: "+playerScore+"\nComputer Score: "+compScore);
		score.setLocation(10, 10);
		panel.add(score);
	}

	public void runGame() {
		ball = b.ballMvt(p.playerx(), p.playery(), c.compx(), c.compy());
		c.compTrack(ball[1]);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//top and bottom borders
		g.setColor(Color.BLACK);
		g.drawLine(10, 10, 730, 10);
		g.drawLine(730, 710, 10, 710);
		
		
		//left and right borders
		g.setColor(Color.RED);
		g.drawLine(730, 10, 730, 710);
		g.drawLine(10, 710, 10, 10);

		//code for ball
		g.setColor(Color.PINK);
		g.fillOval(ball[0], ball[1], 50, 50);

		//code for player
		g.setColor(Color.MAGENTA);
		g.fillRect(playerx, playery, 15, 100);
		
		//code for bot
		g.fillRect(c.compx(), c.compy(), 15, 100);
	}
	
	public void ballScore() {
		if(ballx<=10 && bally>playery && bally<playery+100) {
			playerScore++;
			System.out.println("Player point: "+playerScore);
		}
		
		if(ballx>=689 && bally>compy && bally<compy+100) {
			compScore++;
			System.out.println("Comp point: "+compScore);
		}
	}

	public boolean checkSignal() {
		return signal;
	}
	
	public void resetSignal() {
		signal = false;
	}
	
	public void keyTyped(KeyEvent e) {

	}

	//moves the player's bar
	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_UP)) {
			if (playery > 10) {
				playery -= 10;	
			}
		}

		if ((e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
			if (playery + 100 < 705) {
				playery += 10;	
			}
		}			
	}

	public void keyReleased(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
			playerdy = 0;
		}		
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);

				gamePanel2 test = new gamePanel2();
				test.display(new JFrame(), new JPanel());
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {
					public void run() {
						ball = b.ballMvt(p.playerx(), p.playery(), c.compx(), c.compy());
						test.repaint();
						test.ballScore();
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



