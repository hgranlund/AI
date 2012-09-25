package exercise2.FractionPuzzle;

import exercise2.GenericAstar.AbstractASearch;
import exercise2.GenericAstar.Node;

public class FractionPuzzleAStarSearch extends AbstractASearch {

	public double goalState;

	public FractionPuzzleAStarSearch(double goalState) {
		super();
		this.goalState = goalState;
	}

	@Override
	public Double hFun(Node n) {
		return Math.abs(((PuzzleState) n.state).getSate() - goalState);
	}

	@Override
	public boolean isGoal(Node node) {
		return ((PuzzleState) node.state).getSate() == goalState;
	}

	@Override
	public Double getDistBetweenParentAndChild(Node parent, Node child) {
		return .0;
	}

}
