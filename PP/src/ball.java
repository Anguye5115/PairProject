import javax.swing.JPanel;

public class ball {
	int ballx = 380;
	int bally = 375;
	int balldx = 2;
	int balldy = 2;
	boolean ballUp = true;
	
	private boolean gameOver = false;
	private int winner; //0 = player, 1 = bot

	public int[] ballMvt(int playerx, int playery, int compx, int compy) {
		
		int width = 740;
		int height = 720; 

		ballx = ballx + balldx;
		bally = bally + balldy;

//		decides the winner
//		if (ballx < 10) {
//			gameOver = true;
//			winner = 1;
//		} else if ((ballx + 50) > (width - 10)) {
//			gameOver = true;
//			winner = 0;
//		}

		//needs to be removed after testing-----------------------
//		if (ballx < 10) {
//			balldx = -balldx;
//			ballx = 10;
//		} else if ((ballx + 50) > (width - 10)){
//			balldx = -balldx;
//			ballx = width - 60;
//		}
		//---------------------------------------------------------
		
		if (bally < 10) {
			balldy = -balldy;
			bally = 10;
		} else if ((bally + 50) > (height - 5)) {
			balldy = -balldy;
			bally = height - 60;
		}

		
//		//testing but spawns in and out 
//		if (ballx < 10 && bally>=playery && bally<(playery+100)) {
//			balldx = -balldx;
//			ballx = 10;
//		} else if ((ballx + 50) > compx && (bally>=compy) && (bally<(compy+100))){
//			balldx = -balldx;
//			ballx = compx - 60;
//		}
//		
		
		//changes direction of the ball when it hits player
		if ((ballx == (playerx + 45)) && ((bally > playery) && (bally < playery + 100))) {
			balldx = -balldx;
		}
		
		//changes direction of the ball when  it hits computer
		if ((ballx >= (compx - 45)) && (bally >= compy) && (bally < compy + 100)) {
			balldx = -balldx;
		}
				
		return new int[] {ballx, bally};
		
	}
	
	public boolean gameOver() {
		return this.gameOver;
	}
	
	public int balldx() {
		return balldx;
	}
	
	public int balldy() {
		return balldy;
	}
	
	public int ballx() {
		return ballx;
	}
	
	public int bally() {
		return bally;
	}

}
