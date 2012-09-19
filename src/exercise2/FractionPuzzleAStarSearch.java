package exercise2;

import java.util.ArrayList;

public class FractionPuzzleAStarSearch extends AbstractASearch {

	public double goal;

	public FractionPuzzleAStarSearch(Node start, double goal) {
		super(start);
		this.goal = goal;
	}

	@Override
	public Double hFun(Node n) {
		return Math.abs(((State) n.state).getSate() - goal);
	}

	@Override
	public boolean isGoal(Node node) {
		return ((State) node.state).getSate() == goal;
	}

	@Override
	public Double getDistBetweenParentAndChild(Node parent, Node child) {
		return .0;
	}

	public class State {

		public ArrayList<Integer> t = new ArrayList<Integer>();
		public ArrayList<Integer> n = new ArrayList<Integer>();

		public State(ArrayList<Integer> t, ArrayList<Integer> n) {
			this.t = t;
			this.n = n;
		}

		public double getSate() {
			String tellerStreng = "";
			for (Integer tall : t) {
				tellerStreng += tall.toString();
			}
			String nevnerStreng = "";
			for (Integer tall : n) {
				nevnerStreng += tall.toString();
			}
			double teller = Double.parseDouble(tellerStreng);
			double nevner = Double.parseDouble(nevnerStreng);
			return teller / nevner;

		}

	}

	public static void main(String[] args) {
		// Node start = new Node(0.0, 0.0);
		// Node goal = new Node(.0, .0);
		FractionPuzzleAStarSearch aStar = new FractionPuzzleAStarSearch(start,
				goal);

	}

}
