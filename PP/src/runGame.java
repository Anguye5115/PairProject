import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class runGame {
	JFrame frame;
	JPanel panel;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	static int[] ball;
	
	static int width = 750;
	static int height = 750;
	
	static gameState state;
	enum gameState {
		WELCOMESCREEN,
		GAMESCREEN,
		FINISHSCREEN
	}
	
	private welcomeScreen wScreen;
	private finishScreen fScreen;
	private gamePanel2 gameScreen;
	
	private boolean showWelcome = true;
	private boolean showGame = false;
	private boolean showFinish = false;
	
	runGame() {
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		wScreen = new welcomeScreen(frame, panel);
		fScreen = new finishScreen();
		gameScreen = new gamePanel2();
		
		state = gameState.WELCOMESCREEN;
	}
	
	int counter = 0;
	ActionListener animate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if (state == gameState.WELCOMESCREEN) {
				
				if (showWelcome) {
					wScreen.display();
					showWelcome = false;
				}
				
				if (wScreen.checkSignal()) {
					state = gameState.GAMESCREEN;
					wScreen.resetSignal();
					showGame = true;
				}
				
			} else if (state == gameState.GAMESCREEN) {
				
				if (showGame) {
					wScreen.frame.setVisible(false);
					gameScreen.display(frame, panel);
					showGame = false;
				}
				
				gameScreen.runGame();
				gameScreen.repaint();
				gameScreen.checkGameOver();
				
				if (gameScreen.checkSignal()) {
					state = gameState.FINISHSCREEN;
					showFinish = true;
					gameScreen.reset();
				}
				
			} else if (state == gameState.FINISHSCREEN) {
				
				if (showFinish) {
					gameScreen.frame.setVisible(false);
					fScreen.display(frame, panel);
					showFinish = false;
				}
				
				if (fScreen.checkSignal()) {
					fScreen.resetSignal();
					state = gameState.WELCOMESCREEN;
					showWelcome = true;
				}
				
			}
			panel.repaint();
		}
	};
	Timer timer = new Timer(5, animate);
	
	public void playPP() {
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		state = gameState.WELCOMESCREEN;
		timer.start();
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				runGame instance = new runGame();
				instance.playPP();
			}
		});
	}
}
