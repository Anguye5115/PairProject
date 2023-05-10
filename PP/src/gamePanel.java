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
	JPanel panel;

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
	private int difficulty; //1 is ez, 2 is hard

	gamePanel(JFrame frame, JPanel panel, int difficulty) {
		this.frame = frame;
		this.panel = panel;	
		
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
		//System.out.println(ballx +" "+bally);

		//decides the winner
		//		if (ballx < 10) {
		//			gameOver = true;
		//			winner = 2;
		//		} else if ((ballx + 50) > (width - 10)) {
		//			gameOver = true;
		//			winner = 1;
		//		}

		//needs to be removed after testing-----------------------
		if (ballx < 10) {
			balldx = -balldx;
			ballx = 10;
		} else if ((ballx + 50) > (width - 10)){
			balldx = -balldx;
			ballx = width - 60;
		}
		//---------------------------------------------------------
		
		
		if (bally < 10) {
			balldy = -balldy;
			bally = 10;
		} else if ((bally + 50) > (height - 5)) {
			balldy = -balldy;
			bally = height - 60;
		}

		//changes direction of the ball when it hits player/bot
		if ((ballx == (playerx + 5)) && ((bally > playery) && (bally < playery + 100))) {
			balldx = -balldx;
		}
		
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
		g.fillOval(ballx, bally, 50, 50);

		//code for player
		g.setColor(Color.MAGENTA);
		g.fillRect(playerx, playery, 15, 100);
		
		//code for bot
		g.fillRect(compx, compy, 15, 100);
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

	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_UP)) {
			if (playery > 10) {
				playery -= 25;	
			}
		}

		if ((e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
			if (playery < 740) {
				playery += 25;	
			}
		}			
	}

	public void keyReleased(KeyEvent e) {
		if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
			playerdy = 0;
		}		
	}
	
	public void compMove() {
		boolean direction = true;
		if ((compy + 100 == 710) || (compy == 10)) {
			compdy = -compdy;
		}
		
		compy += compdy;	
	}
	
	public void compSmart() {
//		if(bally is decreasing)
//			bar go down 
		if(balldy<0) {
			System.out.println("up");
		}
		int[] a = newDest();
		if(balldx>0) {
			compx = a[0];
			compy = a[1];
		}
		
	}
	
	public int[] newDest() {
		int x = ballx, y = bally;
		int x2 = 0, y2 = 0;
		int xTimes = 0, yTimes = 0;
		
		xTimes = (689 - ballx)/balldx;
		if(balldy<0) {
			yTimes = (710 - y)/balldy;
		}else {
			yTimes = (y-10)/balldy;
		}
		
		if(balldx>0) {
			if(xTimes<yTimes) {
				x2 = x + (xTimes * balldx);
				y2 = y + (xTimes * balldy);
			}else {
				x2 = x + (yTimes * balldx);
				y2 = y + (yTimes * balldy);
			}
		}
		
		int[] a = new int[] {x2,y2};
		System.out.printf("original: (%d, %d) \nnew dest: (%d, %d)\n\n", x,y,a[0],a[1]);
		
		
//		return new int[] {x2,y2};
		return a;
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);

				gamePanel test = new gamePanel(new JFrame(), new JPanel(), 1);
				Timer timer = new Timer();
				TimerTask task = new TimerTask() {
					public void run() {
						test.ballMvt();
						test.repaint();
//						test.compMove();
						test.ballScore();
						test.compSmart();
						test.newDest();
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




