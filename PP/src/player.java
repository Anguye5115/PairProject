import java.awt.event.KeyEvent;

public class player {
	int playerx = 15;
	int playery = 330;
	int playerdx, playerdy;
	
//	player(KeyEvent e){
//		if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_UP)) {
//			if (playery > 10) {
//				playery -= 25;	
//			}
//		}
//
//		if ((e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
//			if (playery < 740) {
//				playery += 25;	
//			}
//		}		
//		
//		if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
//			playerdy = 0;
//		}	
//	}
//
//
//	public void keyPressed(KeyEvent e) {
//		if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_UP)) {
//			if (playery > 10) {
//				playery -= 25;	
//			}
//		}
//
//		if ((e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
//			if (playery < 740) {
//				playery += 25;	
//			}
//		}			
//	}
//
//	public void keyReleased(KeyEvent e) {
//		if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_S) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
//			playerdy = 0;
//		}		
//	}
	
	public int playerx(){return playerx;}
	public int playery(){return playery;}

}


