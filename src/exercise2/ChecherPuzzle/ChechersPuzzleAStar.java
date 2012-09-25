package exercise2.ChecherPuzzle;

import exercise2.GenericAstar.AbstractASearch;
import exercise2.GenericAstar.Node;

public class ChechersPuzzleAStar extends AbstractASearch {

	@Override
	public Double hFun(Node node) {
		int[] board = getBoad(node);
		int count = 0;
		int k = getK(node);
		for (int i = 0; i <= k; i++) {
			count += board[i] * (k - i) * (k - i) * (k - i);
		}
		return (double) (-count + 0.25*k*k*(k+1)*(k+1));
	}

	@Override
	public Double getDistBetweenParentAndChild(Node parent, Node child) {
		int k = getK(parent);
		return (double) (k*k);
	}

	@Override
	public boolean isGoal(Node node) {
		int[] board = getBoad(node);
		int count = 0;

		for (int i = 0; i <= getK(node); i++) {
			count += board[i];
		}
		if (board[getK(node)] != 0) {
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