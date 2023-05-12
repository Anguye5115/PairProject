
public class computer {
	int compx = 710, compy = 330;
	int compdy = -5;

	public void compMove() {
		boolean direction = true;
		if ((compy + 100 == 630) || (compy == 10)) {
			compdy = -compdy;
		}
		
		System.out.println(compy);
		
		compy += compdy;	
	}
	
	public void compTrack(int bally) {
		compy = bally;
	}

	public int compx(){return compx;}
	public int compy(){return compy;}

//	public void compSmart() {
////		if(bally is decreasing)
////			bar go down 
//		int[] a = newDest();
//		if(balldx>0) {
//			//compx = a[0];
//			compy = a[1]-50;
//		}
//		
//	}
	
	
//	public int[] newDest() {
//		int x = ballx, y = bally;
//		int x2 = 0, y2 = 0;
//		int xTimes = 0, yTimes = 0;
//		
//		xTimes = (689 - ballx)/balldx;
//		if(balldy<0) {
//			yTimes = (710 - y)/balldy;
//		}else {
//			yTimes = (y-10)/balldy;
//		}
//		
//		if(balldx>0) {
//			if(xTimes<yTimes) {
//				x2 = x + (xTimes * balldx);
//				y2 = y + (xTimes * balldy);
//			}else {
//				x2 = x + (yTimes * balldx);
//				y2 = y + (yTimes * balldy);
//			}
//		}
//		
//		int[] a = new int[] {x2,y2};
//		System.out.printf("original: (%d, %d) \nnew dest: (%d, %d)\n\n", x,y,a[0],a[1]);
//		
//		
////		return new int[] {x2,y2};
//		return a;
//	}
	
}
