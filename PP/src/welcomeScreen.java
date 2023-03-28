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
	
	public void display(/*JFrame frame, JPanel panel*/) {
//		this.frame = frame;
//		this.contentPane = panel;
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(500, 750));
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		ezButt = new JButton("Easy");
		ezButt.setActionCommand("ezClick");
		ezButt.addActionListener(this);
		ezButt.setFont(new Font("Serif", Font.PLAIN, 20));
		ezButt.setBounds(150, 500, 200, 50);
		contentPane.add(ezButt);
		
		hardButt = new JButton("Hard");
		hardButt.setActionCommand("hardClick");
		hardButt.addActionListener(this);
		hardButt.setFont(new Font("Serif", Font.PLAIN, 20));
		hardButt.setBounds(150, 575, 200, 50);
		contentPane.add(hardButt);
	
		logo = new JLabel(new ImageIcon("images/ppLogo.png"));
		logo.setBounds(-5, 50, 500, 500);
		contentPane.add(logo);
	
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
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

