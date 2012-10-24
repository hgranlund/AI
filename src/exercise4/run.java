package exercise4;

public class run {
	
	
	public static void PrintGrafvalues(LocalSearchKQueen kQueen, int kLimit){
		int av = 5;
		long time;
		long temp1;
		for (int k = 5; k < kLimit; k++) {
			time=0;
			for (int j = 0; j < av; j++) {
				temp1 = System.currentTimeMillis();
				if (kQueen.minConflict(k, 10000000) ==null) {
					System.out.println(" \n\nstop at k = " + k);
					return;
				}
				time+= System.currentTimeMillis()-temp1;
				//System.out.println(time);
			}
			time= time/av;
			System.out.println(k + "  " + time );
		}
	}

	public static void main(String[] args) {
		LocalSearchKQueen kQueen = new LocalSearchKQueen();
		//kQueen.printBoard(kQueen.minConflict(5, 10000000));
		PrintGrafvalues(kQueen, 500);
	}
}


