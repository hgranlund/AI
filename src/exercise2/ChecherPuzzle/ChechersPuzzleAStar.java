package exercise2.ChecherPuzzle;

import exercise2.GenericAstar.AbstractASearch;
import exercise2.GenericAstar.Node;

public class ChechersPuzzleAStar extends AbstractASearch {

	@Override
	public Double hFun(Node node) {
		int[] board = getBoad(node);
		int count = 0;
		int k= getK(node);
		for (int i = 0; i <= k; i++) {
			count += board[i] *(k-i) ;
		}
		return (double) (- count + k*k);
	}

	@Override
	public Double getDistBetweenParentAndChild(Node parent, Node child) {
		return .5;
	}

	@Override
	public boolean isGoal(Node node) {
		int[] board = getBoad(node);
		int count = 0;
		
		for (int i = 0; i <= getK(node); i++) {
			count += board[i];
		}
		if (board[getK(node)] != 0){
			return false;
		}
		return (getK(node)) == count;
	}

	public int getHalfBoardSum(int[] board) {

		int halfBoardLength = (board.length / 2);
		int count = 0;
		for (int i = 0; i < halfBoardLength; i++) {
			count += board[i];
		}
		return count;
	}

	public int[] getBoad(Node node) {
		return ((ChechersPuzzleState) node.state).getState();
	}

	public int getK(Node n) {
		return (getBoad(n).length / 2);
	}
}