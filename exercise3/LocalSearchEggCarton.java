package exercise3;

import java.util.ArrayList;
import java.util.Arrays;

public class LocalSearchEggCarton {

	public boolean[][] board, bestBoard;
	int bestEnergi;
	int tempLimit, n, m, k;

	public LocalSearchEggCarton(int n, int m, int k, int tempLimit) {
		this.k = k;
		this.m = m;
		this.n = n;
		this.tempLimit = tempLimit;
		this.bestEnergi = 0;
		this.board = getNewInitialBoard(0);
		this.bestEnergi = getEnergi(this.board);

	}

	public int startLocalSearch() {
		if (k==0) return getEnergi(board);
		int currentBestEnergy = 0;
		int tempEnergy = 0;
		
		for (int i = 0; i < tempLimit; i++) {
			for (boolean[][] neighbour : getNeighbours(board, i)) {
				tempEnergy = getEnergi(neighbour);
				if (tempEnergy > currentBestEnergy) {
					currentBestEnergy = tempEnergy;
					board = neighbour;
				}
			}
			if (currentBestEnergy > bestEnergi){
				bestEnergi = currentBestEnergy;
				bestBoard = board;
			}

		}
		
		printBoard(bestBoard);
		return getEnergi(bestBoard);
	}

	private ArrayList<boolean[][]> getNeighbours(boolean[][] b, int temp) {
		ArrayList<boolean[][]> neighbours = new ArrayList<boolean[][]>();
		boolean[][] newBoard = b.clone();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!b[i][j] && isPeiceLegal(newBoard, i, j, k-1)) {
					b[i][j] = true;
					neighbours.add(newBoard);
					newBoard=b.clone();
				}
			}
		}
		if (neighbours.isEmpty()) {
			neighbours.add(getNewInitialBoard(temp));
			return neighbours;
		} else
			return neighbours;
	}

	// siden jeg bare arbeider i rommet av lovelige brett, kan jeg angi energien
	// til antall brikker
	private int getEnergi(boolean[][] b) {
		int energi = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (b[i][j]) {
					energi++;
				}
			}
		}
		return energi;
	}

	private boolean[][] getNewInitialBoard(int temp) {
		boolean[][] newBoard = new boolean[n][m];
		for (int i = 0; i < 2 * n; i++) {
			newBoard[(int) (Math.random() * n)][(int) (Math.random()*m)] = true;
		}
		removeIllegalPieces(newBoard);
		return newBoard;
	}

	private void removeIllegalPieces(boolean[][] b) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (b[i][j]) {
					if (!isPeiceLegal(b, i, j,k )){
						b[i][j] = false;
											}
				}
			}

		}

	}

	private boolean isPeiceLegal(boolean[][] b, int x, int y, int k) {
		// sjekker vertikal
		
		int numberOfPieces = 0;
		for (int j = 0; j < n; j++) {
			if (b[j][y]) {
				numberOfPieces++;
			}
		}
		if (numberOfPieces > k) {
			return false;
		}
		numberOfPieces = 0;
		// sjekker horisontalt
		for (int i = 0; i < m; i++) {
			if (b[x][i]) {
				numberOfPieces++;
			}
		}
		if (numberOfPieces > k) {
			return false;
		}
		numberOfPieces = 0;

		 //sjekker diaginaler
		for (int j = -Math.min(y, x); j < Math.max(m, n); j++) {
			if (x + j >= n || y + j >= m || x + j < 0 || y + j < 0) {
				continue;
			}
			if (b[x + j][y + j]) {
				numberOfPieces++;
			}
		}
		if (numberOfPieces > k) {
			return false;
		}
		numberOfPieces = 0;
		
		for (int j = -Math.min(y, x); j < Math.max(m, n); j++) {
			if (x + j >= n || y - j >= m || x + j < 0 || y - j < 0) {
				continue;
			}
			if (b[x + j][y - j]) {
				numberOfPieces++;
			}
		}
		if (numberOfPieces > k) {
			return false;
		}
		numberOfPieces = 0;


		return true;
	}
	
	public void printBoard(boolean[][] b) {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (b[i][j]) {
					System.out.print(" 1 ");
				}
				else{
					System.out.print(" 0 ");
				}
			}
			System.out.println("");
		}
		System.out.println("=================================================================================");
		
	}

}
