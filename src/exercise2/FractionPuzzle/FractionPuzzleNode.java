package exercise2.FractionPuzzle;

import java.util.ArrayList;

import exercise2.ChecherPuzzle.ChechersPuzzleState;
import exercise2.ChecherPuzzle.CheckersPuzzleNode;
import exercise2.GenericAstar.Node;
import exercise2.GenericAstar.State;

public class FractionPuzzleNode extends Node {
	
	

	public FractionPuzzleNode(Double g, Double h, State state) {
		super(g, h, state);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return (this.getState()== ((FractionPuzzleNode) obj).getState() ); 
	}


	// endrer medoden i node til å generere barn med forkjellige states.
	// Staten blir endret vet at to tilfeldige tall bytter plass
	@Override
	public ArrayList<Node> getChildren() {
		FractionPuzzleNode father = this;
		PuzzleState state = (PuzzleState) father.state;
		ArrayList<Node> children = new ArrayList<Node>();
		int tA[] = state.t.clone();
		int nA[] = state.n.clone();
		int temp = 0;
		for (int i = 0; i < 4; i++) {
			int t = (int) (Math.random() * 4);
			int n = (int) (Math.random() * 5);
			temp = tA[t];
			tA[t] = nA[n];
			nA[n] = temp;
			PuzzleState newState = new PuzzleState(tA, nA);
			Node node = new FractionPuzzleNode(.0, .0, newState);
			children.add(node);
		}
		return children;
	}

}


//7329/14658 = 0.5
//5823/17469 = 0.3333333333333333
//4392/17568 = 0.25
//2769/13845 = 0.2
//5697/34182 = 0.16666666666666666
//5274/36918 = 0.14285714285714285
//9416/75328 = 0.125
//8361/75249 = 0.1111111111111111