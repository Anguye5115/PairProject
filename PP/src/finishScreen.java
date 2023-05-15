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
	JPanel panel;
	JButton playAgainButt;
	JLabel winnerPic;
	
	private boolean signal = false;
	
	public void display(JFrame frame, JPanel panel) {	
		this.frame = frame;
		this.panel = panel;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		panel.setPreferredSize(new Dimension(750, 750));
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		playAgainButt = new JButton("Play Again");
		playAgainButt.setActionCommand("click");
		playAgainButt.addActionListener(this);
		playAgainButt.setFont(new Font("Serif", Font.PLAIN, 20));
		playAgainButt.setBounds(280, 600, 200, 50);
		panel.add(playAgainButt);
		
		winnerPic = new JLabel(new ImageIcon("images/gameOver.png"));
		
		winnerPic.setBounds(25, 0, 700, 700);
		panel.add(winnerPic);
		
		frame.setContentPane(panel);
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
			hide(frame, panel);
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
				test.display(new JFrame(), new JPanel());
			}
		});
	}

}
