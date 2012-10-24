package exercise4;

import java.util.Currency;
import java.util.Random;

public class LocalSearchKQueen {
	// Using min-Conflict

	private Random random;
	// qs represents the queens position on the board. Eks.
	// qs[culomIndex]=RowIndex
	public int[] qs;

	// isQiFine[queenNumber]= True if the i'th Queen is not in any conflicts
	public boolean[] isQiFine;
	int k;

	public LocalSearchKQueen() {
		random = new Random();
	}

	public boolean[][] minConflict(int k, int steps) {
		this.k = k;
		if (k == 0) {
			return makeBoard();
		}
		qs = getNewInitialBoard();
		System.out.println("Inital");
		printBoard(makeBoard());
		isQiFine = new boolean[k];
		int currentColum;
		for (int i = 0; i < steps; i++) {
			if (isSolution())
				return makeBoard();
			currentColum = (int) (Math.random() * k);
			qs[currentColum] = rowWithMinConflicts(currentColum);
			System.out.print("\n"+isSolution()+"\n currentColum = " +currentColum+"\n rowselected  " +qs[currentColum]);
			printBoard(makeBoard());
		}
		return null;
	}

	private boolean isSolution() {
		for (boolean q : isQiFine) {
			if (!q)
				return q;
		}
		return true;
	}

	private int rowWithMinConflicts(int colum) {
		int row = 0;
		int conflicts = k;
		int currentConflicts;
		for (int currentRow = 0; currentRow < k; currentRow++) {
			currentConflicts = conflicts(colum, currentRow);
			if (currentConflicts < conflicts || currentConflicts == conflicts
					& random.nextBoolean()) {
				row = currentRow;
				conflicts = currentConflicts;
			}
		}
		if (conflicts == 0)
			isQiFine[colum] = true;
		else isQiFine[colum]=false;
		return row;
	}

	private int conflicts(int q, int currentRow) {
		int conflicts = 0;
		int ij;
		int qRow;
		for (int qi = 0; qi < k; qi++) {
			ij = Math.abs(q - qi);
			qRow = qs[qi];
			if (currentRow == qRow || currentRow == qRow - ij
					|| currentRow == qRow + ij)
				conflicts++;
		}
		return conflicts;
	}

	private boolean idQueenFine(int q) {
		int ij;
		int qRow;
		int currentRow = qs[q];
		for (int qi = 0; qi < k; qi++) {
			ij = Math.abs(q - qi);
			qRow = qs[qi];
			if (currentRow == qRow || currentRow == qRow - ij
					|| currentRow == qRow + ij)
				return false;
		}
		return true;
	}

	// makes å board from qs-array
	private boolean[][] makeBoard() {
		if (qs==null) return null;
		boolean[][] board = new boolean[k][k];
		for (int i = 0; i < k; i++) {
			board[qs[i]][i] = true;
		}
		return board;
	}

	public int[] getNewInitialBoard() {
		qs = new int[k];
		for (int i = 0; i < qs.length; i++) {
			qs[i] = random.nextInt() % k;
		}
		return qs;
	};

	public void printBoard(boolean[][] b) {

		System.out.println("\nBoard with k = " + k);
		if (b == null) {
			System.out.println("Fant ingen løsning");
			return;
		}
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				if (b[i][j]) {
					System.out.print(" 1 ");
				} else {
					System.out.print(" 0 ");
				}
			}
			System.out.println("");
		}
		System.out
				.println("=================================================================================");

	}

}