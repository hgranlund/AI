package exercise2.FractionPuzzle;

import exercise2.GenericAstar.AbstractASearch;
import exercise2.GenericAstar.Node;

public class FractionPuzzleAStarSearch extends AbstractASearch {

	public float goalState;

	public FractionPuzzleAStarSearch(float goalState) {
		super();
		this.goalState = goalState;
	}

	@Override
	public float hFun(Node n) {
		return (float) Math.abs(((PuzzleState) n.state).getSate() - goalState);
	}

	@Override
	public boolean isGoal(Node node) {
		return ((PuzzleState) node.state).getSate() == goalState;
	}

	@Override
	public float getDistBetweenParentAndChild(Node parent, Node child) {
		return 0;
	}

}
