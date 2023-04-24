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
	
	private static boolean signal = false;
	
	private int difficulty;
	
	public welcomeScreen(JFrame frame, JPanel contentPane) {
		this.frame = frame;
		this.contentPane = contentPane;
		contentPane.setLayout(null);
		frame = new JFrame();
		ezButt = new JButton("Easy");
		hardButt = new JButton("Hard");
		logo = new JLabel(new ImageIcon("images/ppLogo.png"));
	}
	
	public void display() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(500, 750));
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		ezButt.setActionCommand("click");
		ezButt.addActionListener(this);
		ezButt.setFont(new Font("Serif", Font.PLAIN, 20));
		ezButt.setBounds(150, 500, 200, 50);
		contentPane.add(ezButt);
		
		hardButt.setActionCommand("click");
		hardButt.addActionListener(this);
		hardButt.setFont(new Font("Serif", Font.PLAIN, 20));
		hardButt.setBounds(150, 575, 200, 50);
		contentPane.add(hardButt);
	
		logo.setBounds(-5, 50, 500, 500);
		contentPane.add(logo);
	
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void hide(JFrame frame, JPanel panel) {
		panel.remove(ezButt);
		panel.remove(hardButt);
		panel.remove(logo);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "click") {
			signal = true;
			hide(frame, contentPane);
		}
	}
	
	public int getDiff() {
		return difficulty;
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
				welcomeScreen test = new welcomeScreen(new JFrame(), new JPanel());
				test.display();
			}
		});
	}
}

