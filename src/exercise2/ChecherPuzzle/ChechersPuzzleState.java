package exercise2.ChecherPuzzle;

import exercise2.GenericAstar.State;

public class ChechersPuzzleState extends State {

	// 1 = #, 0 = empty , -1 = @
	
	public int[] board;
	
	public ChechersPuzzleState(int[] board){
		this.board = board;
	}
	
	@Override
	public String toString() {
		String s = "Board: ";
		for (int check : board) {
			switch (check) {
			case 1:
				s += "+";
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
		return s;
	}
	
	
	public int[] getState(){
		return board;
	}
}
