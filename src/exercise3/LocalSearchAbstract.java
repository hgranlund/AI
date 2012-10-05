package exercise3;

import java.util.ArrayList;

public abstract class LocalSearchAbstract {

	public Object board, bestBoard;
	int bestEnergi;
	int tempLimit, n, m, k;

	abstract ArrayList<Object> getNeighbours(Object b);

	abstract int getEnergi(Object board2);

	abstract Object getNewInitialBoard();

	abstract boolean takeBoard(int tempEnergy, int currentBestEnergy);

	public Object startLocalSearch() {
		if (k == 0)
			return getEnergi(board);
		int currentBestEnergy = 0;
		int tempEnergy = 0;

		for (int i = 0; i < tempLimit; i++) {
			for (Object neighbour : getNeighbours(board)) {
				tempEnergy = getEnergi(neighbour);
				if (tempEnergy > currentBestEnergy) {
					currentBestEnergy = tempEnergy;
					board = neighbour;
				}

				if (takeBoard(currentBestEnergy, bestEnergi)) {
					bestEnergi = currentBestEnergy;
					bestBoard = board;
				}

			}
		}
		return getEnergi(bestBoard);
	}

}
