package exercise2.GenericAstar;

import java.util.ArrayList;
import java.util.PriorityQueue;

public abstract class AbstractASearch {

	private ArrayList<Node> closedNodes;
	private PriorityQueue<Node> openNodes;

	public abstract Double hFun(Node n);

	// Denne skal finne avstanden mellom far og sønn
	public abstract Double getDistBetweenParentAndChild(Node parent, Node child);

	public abstract boolean isGoal(Node node);

	public AbstractASearch() {
		closedNodes = new ArrayList<Node>();
		openNodes = new PriorityQueue<Node>();
	}
	public ArrayList<Node> start(Node start) {
		start.setH(hFun(start));
		openNodes.add(start);
		Node current;
		Double tempG = 0.0;
		// Så lenge vi ikke har kommet mål
		while (!openNodes.isEmpty()) {
			// Få tak i noden med lavest f verdi
			current = openNodes.poll();
//			System.out.println("Current er : " + current.state);
			// Om vi har funnet goal, rekonstruerer vi veien og retunerer den
			if (isGoal(current)) {
				return reconstuctPath(current);
			}

			// Fjerner noden fra opnenNodes til ClosedNodes, siden vi nå er
			// ferdig med den;
			openNodes.remove(current);
			closedNodes.add(current);

			// Går igjennom alle barna til noden og kalkulerer f-verdien
			for (Node child : current.getChildren()) {

				if (closedNodes.contains(child)) {
					continue;
					// TODO Må jeg undersøke om dette er den korteste veien?
				}

				// kalkulerer en mulig g verdi
				tempG = current.getG()
						+ getDistBetweenParentAndChild(current, child);

				if (!openNodes.contains(child) || tempG < child.getF()) {
					if (!openNodes.contains(child)) {
						openNodes.add(child);
					}
					if (child.parent != null) {
						child.possParents.add(child.parent);
					}
					child.parent = current;
					child.setG(tempG);
					child.setH(hFun(child));
				}

			}
		}
		return new ArrayList<Node>();

	}

	public ArrayList<Node> reconstuctPath(Node current) {
		ArrayList<Node> path = new ArrayList<Node>();
		path.add(current);
		while (current.parent != null) {

			path.add(0,current.parent);
			current = current.parent;
		}
		path.add(0,current);
		return path;
	}

}
