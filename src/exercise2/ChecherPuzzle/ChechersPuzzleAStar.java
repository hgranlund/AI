package exercise2.ChecherPuzzle;

import exercise2.GenericAstar.AbstractASearch;
import exercise2.GenericAstar.Node;

public class ChechersPuzzleAStar extends AbstractASearch {

	@Override
	public Double hFun(Node n) {
		return (double) Math.abs(getHalfBoardSum(getBoad(n)) - getK(n));
	}

	@Override
	public Double getDistBetweenParentAndChild(Node parent, Node child) {
		return .1;
	}

	@Override
	public boolean isGoal(Node node) {
		int[] board = getBoad(node);
		int halfBoardLength = (board.length / 2);
		return (halfBoardLength) == getHalfBoardSum(board);
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
		return (getBoad(n).length / 2) - 1;
	}
}