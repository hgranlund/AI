package exercise4;

public class run {

	
	public void PrintGrafvalues(){
		
	}

	public static void main(String[] args) {
		LocalSearchKQueen kQueen = new LocalSearchKQueen();
		kQueen.printBoard(kQueen.minConflict(9, 500));
	}
}


