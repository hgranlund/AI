package exercise2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import exercise2.ChecherPuzzle.ChechersPuzzleAStar;
import exercise2.ChecherPuzzle.ChechersPuzzleState;
import exercise2.ChecherPuzzle.CheckersPuzzleNode;
import exercise2.FractionPuzzle.FractionPuzzleAStarSearch;
import exercise2.FractionPuzzle.FractionPuzzleNode;
import exercise2.FractionPuzzle.PuzzleState;
import exercise2.GenericAstar.Node;

public class Run {

	public static void startChechersPuzzle(int k) {
		ChechersPuzzleAStar aStar = new ChechersPuzzleAStar();
		int[] board = new int[(2 * k) + 1];
		for (int i = 0; i < (k * 2) + 1; i++) {
			if (i < k) {
				board[i] = -1;
			} else if (i > k) {
				board[i] = 1;
			} else {
				board[i] = 0;
			}
		}
		ChechersPuzzleState initState = new ChechersPuzzleState(board);
		Node start = new CheckersPuzzleNode(.0, .0, initState);
		long time = new Date().getTime();
		System.out
				.println("======================================================");
		System.out.println("Staret FractionPuzzleA*Search med start brett "
				+ initState);
		System.out.println("Starter søk.......");
		ArrayList<Node> path = aStar.start(start);
		for (Node n : path) {
			System.out.println(n.state);
		}
		long sec = (new Date().getTime() - time);
		System.out
				.println("Antall noder på stien.............: " + path.size());
		System.out.println("Dette tok " + sec + " ms");
		System.out
				.println("====================================================== \n");
	}

	public static void startFractionPuzzle(double goal) {
		FractionPuzzleAStarSearch aStar = new FractionPuzzleAStarSearch(goal);
		int[] t = { 1, 2, 3, 4 };
		int[] n = { 5, 6, 7, 8, 9 };
		PuzzleState initState = new PuzzleState(t, n);
		Node start = new FractionPuzzleNode(.0, .0, initState);
		long time = new Date().getTime();
		System.out
				.println("======================================================");
		System.out.println("Staret FractionPuzzleA*Search med mål " + goal);
		System.out.println("Starter søk.......");
		ArrayList<Node> path = aStar.start(start);

		System.out.println(path.get(path.size() - 1).state);
		long sec = (new Date().getTime() - time);
		System.out
				.println("Antall noder på stien.............: " + path.size());
		System.out.println("Dette tok " + sec + " ms");
		System.out
				.println("====================================================== \n");

	}

	public static void main(String[] args)  {
		while (true) {
			System.out
					.println(" Hvilken Algoritme vil du kjøre?  \n 1. FractionPuzzle \n 2.Checkers \n");
			try {
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				System.out
						.println("Velg et nummer og mål, separert med ':' ( eks 1 : 1 : 8 --> FractionPuzzle med målet 1/8 , 2:4 --> Checkers med k=4) ");
				String[] g = br.readLine().split(":");

				switch (g[0].trim()) {
				case "1":
					DecimalFormat df = new DecimalFormat();
					Number tString = df.parse(g[1].trim());
					Number nString = df.parse(g[2].trim());
					double n = nString.doubleValue();
					double t = tString.doubleValue();
					startFractionPuzzle(t / n);

					break;
				case "2":
					int k = Integer.parseInt(g[1]);
					System.out.println("K er...: " + k);
					startChechersPuzzle(k);

				default:
					break;
				}
			} catch (IOException | java.text.ParseException e) {
				System.out.println("Prøv igjen!");
			}


		}
	}
}
