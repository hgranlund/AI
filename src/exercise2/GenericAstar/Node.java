package exercise2.GenericAstar;

import java.util.ArrayList;

// Dette er en generell Node
public class Node implements Comparable<Node> {
	
	private float f = 0;
	private float h = 0;
	private float g = 0;

	public boolean closed = true;

	private ArrayList<Node> children;

	public ArrayList<Node> getChildren() {
		return children;
	}

	
	public void setChildren(ArrayList<Node> children) {
		this.children = children;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public ArrayList<Node> possParents;
	public Node parent = null;
	public State state;

	public Node(float g, float h, State state) {
		this.children = new ArrayList<Node>();
		this.possParents = new ArrayList<Node>();
		this.setG(g);
		this.setH(h);
		this.state = state;
	}

	@Override
	public int compareTo(Node o) {
		return Float.compare(this.f, o.getF());
	}

	public float getF() {
		return f;
	}

	public float getH() {
		return h;
	}

	// Når H- verdien blir endret opptateres F-verdien automatisk
	public void setH(float h) {
		this.h = h;
		f = g + h;
	}

	public float getG() {
		return g;
	}

	// Når G-verdien blir endret opptateres F-verdien automatisk
	public void setG(float g) {
		this.g = g;
		f = g + h;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

}
