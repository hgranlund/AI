package exercise2.FractionPuzzle;

import java.util.ArrayList;

import exercise2.GenericAstar.Node;
import exercise2.GenericAstar.State;

public class FractionPuzzleNode extends Node {
	
	

	public FractionPuzzleNode(Double g, Double h, State state) {
		super(g, h, state);
		// TODO Auto-generated constructor stub
	}
	
	public int[] generateNextPermutation(int[] numbers){
		
	return null;	
	}
	

	// endrer medoden i node til å generere barn med forkjellige states.
	// Staten blir endret vet at to tilfeldige tall bytter plass
	@Override
	public ArrayList<Node> getChildren() {
		PuzzleState state = (PuzzleState) this.state;
		ArrayList<Node> children = new ArrayList<Node>();
		int temp = 0;
		for (int i = 0; i < 1; i++) {
			int tA[] = state.t;
			int nA[] = state.n;
			int t = (int) (Math.random() * 4);
			int n = (int) (Math.random() * 5);
			temp = tA[t];
			tA[t] = nA[n];
			nA[n] = temp;
			PuzzleState newState = new PuzzleState(tA, nA);
			Node node = new FractionPuzzleNode(.0, .0, newState);
			node.parent = this;
			children.add(node);
		}
		return children;
	}

}
