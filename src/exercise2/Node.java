package exercise2;

import java.util.ArrayList;

public class Node implements Comparable<Node>{

	
	
	private double f=0;
	private  double h=0;
	private double g=0;
	
//	public Object state;
	public boolean closed=true;
	public boolean solution=true;
	public ArrayList<Node> children;
	public ArrayList<Node> possParents;
	public Node parent;
	
	
	
	
	public Node() {
		this.children=new ArrayList<Node>();
		this.possParents = new ArrayList<Node>();
	}
	
		
	@Override
	public int compareTo(Node o) {
		return Double.compare(this.f, o.getF());
	}
	
	
	
	public double getF() {
		return f;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
		f=g+h;
	}
	public double getG() {
		return g;
	}
	public void setG(double g) {
		this.g = g;
		f=g+h;
	}
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	public boolean isSolution() {
		return solution;
	}
	public void setSolution(boolean solution) {
		this.solution = solution;
	}
	
	
	

	
	
}
