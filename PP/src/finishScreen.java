import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class finishScreen implements ActionListener {
	
	JFrame frame;
	JPanel contentPane;
	JButton playAgainButt;
	
	
	public void display(/*JFrame frame, gamePanel contentPane*/) {
		this.frame = frame;
		this.contentPane = contentPane;
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(500, 750));
		frame.add(contentPane);
		frame.pack();
		frame.setVisible(true);
		
		
		
		contentPane.setLayout(null);
		
		
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				finishScreen test = new finishScreen();
				test.display();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {

	}

}
