import javax.swing.JPanel;

public class ball {
	
	int[] arraydx = {-3, 3};
	int[] arraydy = {-2, 2};
	int ballx = 400;
	int bally = 375;
	int balldx = arraydx[(int) (Math.random() * 2)];
	int balldy = arraydy[(int) (Math.random() * 2)];
	boolean ballUp = true;
	
	public int[] ballMvt(int playerx, int playery, int compx, int compy) {
		
		int width = 740;
		int height = 720; 

		ballx = ballx + balldx;
		bally = bally + balldy;
		
		//ball bounces off the top and bottom walls
		if (bally < 10) {
			balldy = -balldy;
			bally = 10;
		} else if ((bally + 50) > (height - 5)) {
			balldy = -balldy;
			bally = height - 60;
		}

		//changes direction of the ball when it hits player
		if ((ballx == (playerx + 15)) && ((bally > playery - 25) && 
				(bally < playery + 100))) {
			balldx = -balldx;
		}
		
		//changes direction of the ball when  it hits computer
		if ((ballx >= (compx - 45)) && (bally > compy - 25) && (bally < compy + 100)) {
			balldx = -balldx;
		}
				
		return new int[] {ballx, bally};
		
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
