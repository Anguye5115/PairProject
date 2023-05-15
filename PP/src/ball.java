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
		
		//ball bounces off the top and bottom walls
		if (bally < 10) {
			balldy = -balldy;
			bally = 10;
		} else if ((bally + 50) > (height - 5)) {
			balldy = -balldy;
			bally = height - 60;
		}

		//changes direction of the ball when it hits player
		System.out.println("Player: " + playery + " | Ball: " + bally);
		System.out.println("Player: " + playerx + " | Ball: " + ballx);
		if ((ballx == (playerx + 14)) && ((bally > (playery - 20)) && (bally < playery + 120))) {
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
