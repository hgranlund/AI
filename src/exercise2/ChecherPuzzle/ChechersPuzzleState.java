package exercise2.ChecherPuzzle;

import exercise2.GenericAstar.State;

public class ChechersPuzzleState extends State {

	// 1 = red, 0 = empty , -1 = gray
	
	public int[] board;

	@Override
	public String toString() {
		String s = "Board: ";
		for (int check : board) {
			switch (check) {
			case 1:
				s += "#";
				break;
			case 0:
				s += "_";
				break;
			case -1:
				s+="@";
			default:
				break;
			}
		}
		return s + "\n";
	}
	
	
	public int[] getState(){
		return board;
	}
}
