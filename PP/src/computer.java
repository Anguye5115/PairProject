import java.util.Random;

public class computer {
	int compx = 710, compy = 330;
	int compdy = -5;

	Random rand = new Random();
	
	public void compTrack(int bally) {
        compy = bally;
        if(bally>=610) {
            compy = 610;
        }
    }
	
	public int compx(){return compx;}
	public int compy(){return compy;}
	
}
