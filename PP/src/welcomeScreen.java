import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class welcomeScreen implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JButton ezButt, hardButt;
	JLabel logo;
	
	welcomeScreen(JFrame frame, JPanel panel){
		this.frame = frame;
		this.panel = panel;
		panel.setLayout(null);
		logo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("ppLogo.png")));
	}
	
	public void display(JFrame frame, JPanel panel) {
		
		
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
}
