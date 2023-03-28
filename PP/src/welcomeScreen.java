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

public class welcomeScreen implements ActionListener {
	
	JFrame frame;
	JPanel contentPane;
	JButton ezButt, hardButt;
	JLabel logo;
	
	welcomeScreen(JFrame frame, JPanel contentPane){
		this.frame = frame;
		this.contentPane = contentPane;
		contentPane.setLayout(null);
		ezButt = new JButton("Easy");
		hardButt = new JButton("Hard");
		logo = new JLabel(new ImageIcon("images/ppLogo.png"));
	}
	
	public void display(JFrame frame, JPanel panel) {
//		this.frame = frame;
//		this.panel = panel;
		frame = new JFrame();
		panel = new JPanel();
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(500, 750));
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
	
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
//	public static void main(String[]args) {
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				JFrame.setDefaultLookAndFeelDecorated(true);
//				
//				JFrame testFrame = new JFrame();
//				
//				
//				new welcomeScreen().display(new JFrame(), new JPanel());
//			}
//		});
//	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				welcomeScreen test = new welcomeScreen();
				test.display();
			}
		});
	}
}

