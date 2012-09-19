package exercise2.FractionPuzzle;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import exercise2.GenericAstar.State;



public class PuzzleState extends State{

	public int[] t;
	public int[] n;

	public PuzzleState(int[] t, int[] n) {
		this.t = t;
		this.n = n;
	}
	
	public String getTellerString(){
		String tellerStreng = "";
		for (Integer tall : t) {
			tellerStreng += tall.toString();
		}
		return tellerStreng;
	}
	
	public String getNevnerString() {
		String nevnerStreng = "";
		for (Integer tall : n) {
			nevnerStreng += tall.toString();
		}
		return nevnerStreng;
	}

	public double getSate() {
		double teller = Double.parseDouble(getTellerString());
		double nevner = Double.parseDouble(getNevnerString());
		return teller / nevner;

	}

	@Override
	public String toString() {
		
		return getTellerString() + "/" + getNevnerString() +" = " + getSate();
		
	}



}
