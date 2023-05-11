import javax.swing.JPanel;

public class ball {
	int ballx = 375;
	int bally = 375;
	int balldx = 3;
	int balldy = 2;
	boolean ballUp = true;
	
	int playerx = 15;
	int playery = 330;
	int playerdx, playerdy;
	
	int compx = 710, compy = 330;
	int compdx; 
	int compdy = -5;


	public void ballMvt(JPanel panel) {
		int width = panel.getWidth();
		int height = panel.getHeight();

		ballx = ballx + balldx;
		bally = bally + balldy;
		//System.out.println(ballx +" "+bally);

		//decides the winner
		//		if (ballx < 10) {
		//			gameOver = true;
		//			winner = 2;
		//		} else if ((ballx + 50) > (width - 10)) {
		//			gameOver = true;
		//			winner = 1;
		//		}

		//needs to be removed after testing-----------------------
		if (ballx < 10) {
			balldx = -balldx;
			ballx = 10;
		} else if ((ballx + 50) > (width - 10)){
			balldx = -balldx;
			ballx = width - 60;
		}
		//---------------------------------------------------------
		
		
		if (bally < 10) {
			balldy = -balldy;
			bally = 10;
		} else if ((bally + 50) > (height - 5)) {
			balldy = -balldy;
			bally = height - 60;
		}

		//changes direction of the ball when it hits player/bot
		if ((ballx == (playerx + 5)) && ((bally > playery) && (bally < playery + 100))) {
			balldx = -balldx;
		}
		
		if ((ballx == (compx - 5)) && (bally > compy) && (bally < compy + 100)) {
			balldx = -balldx;
		}
		
	}
}
