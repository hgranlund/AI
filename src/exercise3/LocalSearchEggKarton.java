package exercise3;

import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class LocalSearchEggKarton {

	Boolean[][] board, bestBoard;
	int bestEnergi;
	int tempLimit, n, m, k;

	public LocalSearchEggKarton(int n, int m, int k, int tempLimit) {
		this.k = k;
		this.m = m;
		this.n = n;
		this.tempLimit=tempLimit;
		this.bestEnergi = 0;
		this.board = getNewInitialBoard();
		this.bestEnergi = getEnergi(this.board);

	}
	
	
	public Boolean[][] startLocalSearch(){
		float currentBestEnergy =0;
		float tempEnergy=0;
		
		
		for (int i = 0; i < tempLimit; i++) {
			for (Boolean[][] neighbour	 : getNeighbours(board)) {
				tempEnergy= getEnergi(neighbour);
				if (tempEnergy> currentBestEnergy ){
					currentBestEnergy=tempEnergy;
					board = neighbour;
				}
			}
			
			
			
		}
		
		return null;
	}

	private ArrayList<Boolean[][]> getNeighbours(Boolean[][] board2) {
		// TODO Auto-generated method stub
		ArrayList<Boolean[][]> neighbours = new ArrayList<Boolean[][]>();
		
		if (neighbours.isEmpty()){
			neighbours.add(getNewInitialBoard());
			return neighbours;
		}
		else return neighbours;
	}

	// siden jeg bare arbeider i romet av lovelige brett, kan jeg angi energien til antall brikker
	private int getEnergi(Boolean[][] board) {
		int energi=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j]){
					energi++;
				}
			}
		}
		return energi;
	}

	private Boolean[][] getNewInitialBoard(int temp) {
		// TODO Auto-generated method stub
		return null;
	}

}
