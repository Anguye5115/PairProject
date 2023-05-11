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
	JButton ezButt;
	JLabel logo;
	
	private static boolean signal = false;
	
	private int difficulty; //1 is ez, 2 is hard
	
	public welcomeScreen(JFrame frame, JPanel contentPane) {
		this.frame = frame;
		this.contentPane = contentPane;
		contentPane.setLayout(null);
		frame = new JFrame();
		ezButt = new JButton("Play");
		logo = new JLabel(new ImageIcon("images/ppLogo.png"));
	}
	
	public void display() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(750, 750));
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		ezButt.setActionCommand("ezClick");
		ezButt.addActionListener(this);
		ezButt.setFont(new Font("Serif", Font.PLAIN, 20));
		ezButt.setBounds(280, 500, 200, 50);
		contentPane.add(ezButt);
	
		logo.setBounds(125, 50, 500, 500);
		contentPane.add(logo);
	
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void hide(JFrame frame, JPanel panel) {
		panel.remove(ezButt);
		panel.remove(logo);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ezClick") {
			signal = true;
			hide(frame, contentPane);
			difficulty = 1;
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

