package exercise2;

import java.util.ArrayList;
import java.util.Date;

import exercise2.FractionPuzzle.FractionPuzzleAStarSearch;
import exercise2.FractionPuzzle.FractionPuzzleNode;
import exercise2.FractionPuzzle.PuzzleState;
import exercise2.GenericAstar.Node;

public class Run {

	public static void main(String[] args) {
		double goal = .1 / .8;
		FractionPuzzleAStarSearch aStar = new FractionPuzzleAStarSearch(goal);
		int[] t = { 1, 2, 3, 4 };
		int[] n = { 5, 6, 7, 8, 9 };
		PuzzleState initState = new PuzzleState(t, n);
		Node start = new FractionPuzzleNode(.0, .0, initState);
		long time = new Date().getTime();
		System.out.println("======================================================");
		System.out.println("Starter søk.......");
		start.parent = start;
		ArrayList<Node> path = aStar.start(start);
		System.out.println("======================================================");

		for (Node node : path) {
			System.out.println(node.state);
		}
		long sec = (new Date().getTime()- time)/1000;
		System.out.println("Lenden på veien er..............: "  + path.size());
		System.out.println("Dette tok " +sec + " sekunder");

	}
}
