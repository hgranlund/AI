package exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import exercise2.FractionPuzzle.FractionPuzzleAStarSearch;
import exercise2.FractionPuzzle.FractionPuzzleNode;
import exercise2.FractionPuzzle.PuzzleState;
import exercise2.GenericAstar.Node;

public class Run {

	public static void startFractionPuzzle(double goal) {
		FractionPuzzleAStarSearch aStar = new FractionPuzzleAStarSearch(goal);
		int[] t = { 1, 2, 3, 4 };
		int[] n = { 5, 6, 7, 8, 9 };
		PuzzleState initState = new PuzzleState(t, n);
		Node start = new FractionPuzzleNode(.0, .0, initState);
		start.parent = null;
		long time = new Date().getTime();
		System.out
				.println("======================================================");
		System.out.println("Starter søk.......");
		ArrayList<Node> path = aStar.start(start);

		System.out.println(path.get(path.size()-1).state);
		long sec = (new Date().getTime() - time);
		System.out
				.println("Antall noder på stien.............: " + path.size());
		System.out.println("Dette tok " + sec + " ms");
		System.out
		.println("====================================================== \n");

	}

	public static void main(String[] args) {
		while (true) {
			System.out
					.println(" Hvilken Algoritme vil du kjøre?  \n 1. FractionPuzzle \n 2.Checkers \n");

			double goal;
			int program = 1;
			try {
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				System.out
						.println("Velg et nummer og mål, separert med ':' ( eks 1 : 1 : 8 --> FractionPuzzle med målet 1/8 ) ");
				String[] g = br.readLine().split(":");
				switch (g[0].trim()) {
				case "1":
					DecimalFormat df = new DecimalFormat();
					Number tString = df.parse(g[1].trim());
					Number nString = df.parse(g[2].trim());
					double n = nString.doubleValue();
					double t = tString.doubleValue();
					System.out.println("Målet er...: " + t / n);
					startFractionPuzzle(t / n);

					break;

				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Prøv igjen!");
			}

		}
	}
}
