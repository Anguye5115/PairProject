import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class finishScreen implements ActionListener {
	
	JFrame frame;
	JPanel contentPane;
	JButton playAgainButt;
	JLabel winnerPic;
	int winIndex;
	//0 = player, 1 = bot
	
	private boolean signal = false;
	
	public void getWinIndex(int num) {
		winIndex = num;
	}
	
	public void display(/*JFrame frame, gamePanel contentPane*/) {
//		this.frame = frame;
//		this.contentPane = contentPane;
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(750, 750));
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		playAgainButt = new JButton("Play Again");
		playAgainButt.setActionCommand("click");
		playAgainButt.addActionListener(this);
		playAgainButt.setFont(new Font("Serif", Font.PLAIN, 20));
		playAgainButt.setBounds(280, 600, 200, 50);
		contentPane.add(playAgainButt);
		
		if (winIndex == 0) {
			winnerPic = new JLabel(new ImageIcon("images/youWin.png"));
		} else if (winIndex == 1) {
			winnerPic = new JLabel(new ImageIcon("images/youLose.png"));
		} else if (winIndex == 2) {
			winnerPic = new JLabel(new ImageIcon("images/tie.png"));
		}
		
		winnerPic.setBounds(130, 100, 500, 500);
		contentPane.add(winnerPic);
		
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	//WIP
	public void hide(JFrame frame, JPanel panel) {
		panel.remove(playAgainButt);
		panel.remove(winnerPic);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "click") {
			signal = true;
			hide(frame, contentPane);
		}
	}
	
	public boolean checkSignal() {
		return signal;
	}
	
	public void resetSignal() {
		signal = false;
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				finishScreen test = new finishScreen();
				test.getWinIndex(2);
				test.display();
			}
		});
	}

}
