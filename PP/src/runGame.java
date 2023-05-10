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
	
	static int width = 750;
	static int height = 750;
	
	int difficulty; //1 is ez, 2 is hard
	
	static gameState state;
	enum gameState {
		WELCOMESCREEN,
		GAMESCREEN,
		FINISHSCREEN
	}
	
	private welcomeScreen wScreen;
	private finishScreen fScreen;
	private gamePanel gameScreen;
	
	runGame() {
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		wScreen = new welcomeScreen(frame, panel);
		fScreen = new finishScreen();
		
		state = gameState.WELCOMESCREEN;
	}
	
	int counter = 0;
	ActionListener animate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (state == gameState.WELCOMESCREEN) {
				wScreen.display();
				if (wScreen.checkSignal()) {
					state = gameState.GAMESCREEN;
					wScreen.resetSignal();
				}
			} else if (state == gameState.GAMESCREEN) {
				wScreen.hide(frame, panel);
				difficulty = wScreen.getDiff();
				
				//testing
				difficulty = 1;
				gameScreen = new gamePanel(frame, panel, difficulty);
				
			} else if (state == gameState.FINISHSCREEN) {
				
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
