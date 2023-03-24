import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class runGame {
	JFrame frame;
	JPanel gamePanel;
	
	static int width = 500;
	static int height = 750;
	
	static gameState state;
	
	enum gameState {
		WELCOMESCREEN,
		GAMESCREEN,
		FINISHSCREEN
	}
	
	private welcomeScreen wScreen;
	private finishScreen fScreen;
	
	runGame() {
		frame = new JFrame();
		gamePanel = new gamePanel(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		state = gameState.WELCOMESCREEN;
		wScreen = new welcomeScreen(frame, gamePanel);
		fScreen = new finishScreen();
	}
	
	int counter = 0;
	ActionListener animate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (state == gameState.WELCOMESCREEN) {
				
			} else if (state == gameState.GAMESCREEN) {
				
			} else if (state == gameState.FINISHSCREEN) {
				
			}
			gamePanel.repaint();
		}
	};
	Timer timer = new Timer(5, animate);
	
	public void playPP() {
		frame.setContentPane(gamePanel);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
//		state = gameState.WELCOMESCREEN;
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
