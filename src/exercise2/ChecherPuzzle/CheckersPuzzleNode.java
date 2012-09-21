package exercise2.ChecherPuzzle;

import java.util.ArrayList;

import com.sun.corba.se.pept.transport.InboundConnectionCache;
import com.sun.org.apache.bcel.internal.generic.IINC;

import exercise2.GenericAstar.Node;
import exercise2.GenericAstar.State;

public class CheckersPuzzleNode extends Node {

	public CheckersPuzzleNode(Double g, Double h, State state) {
		super(g, h, state);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean equals(Object obj) {
		CheckersPuzzleNode node=((CheckersPuzzleNode) obj);
		int[] objBoard=  ((ChechersPuzzleState)node.state).board;
		int[] thisBoard = ((ChechersPuzzleState) this.state).board;
		for (int i = 0; i < objBoard.length; i++) {
			if (!(objBoard[i] == thisBoard[i])){
				return false;
			}
		}
		return true;

	}


	@Override
	public ArrayList<Node> getChildren() {
		CheckersPuzzleNode father = this;
		int[] board = ((ChechersPuzzleState) father.state).board;
		ArrayList<Node> children = new ArrayList<Node>();

		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) {
				int[] iterateArray = { -2, -1, 1, 2 };
				for (int j : iterateArray) {
					int[] newBoard1 = board.clone();
					int indexToMove = j+i;
					if(indexToMove < board.length  && indexToMove >= 0){
						newBoard1[i] = newBoard1[indexToMove];
						newBoard1[indexToMove] = 0;
						ChechersPuzzleState newState = new ChechersPuzzleState(
								newBoard1);
						children.add(new CheckersPuzzleNode(.0, .0, newState));
						
					}
				}
			}
		}
		return children;

	}

}
