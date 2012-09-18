package exercise2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public abstract class AbstractASearch {

	private ArrayList<Node> closedNodes;
	private PriorityQueue<Node> openNodes;
	private HashMap<Node, Node> come_from;
	public abstract Double hFun(Node n); 
	public Node goal;
	
	
	
	public AbstractASearch(Node start){
		closedNodes = new ArrayList<Node>();
		openNodes = new PriorityQueue<Node>();
		openNodes.add(start);
		start.setH(hFun(start));
	}
	
	
	public ArrayList<Node> start(){
		Node current = null;
		Double tempF = 0.0;
		while (!openNodes.isEmpty()){
			
			// Om vi har funnet goal, rekonstruerer vi veien og retunerer den
			if (current==goal){
				return reconstuctPath(current);
			}
			openNodes.remove(current);
			closedNodes.add(current);
			
			for (Node child : current.children) {
				if (closedNodes.contains(child)){
					continue;
					//TODO Må jeg undersøke om dette er den korteste veien?
				}
				tempF = current.getG() + hFun(child);
				
				
				
			}
			
		}
		return new ArrayList<Node>();
			
	}
	
	public ArrayList<Node> reconstuctPath(Node goal){
		return new ArrayList<Node>();
	}
	
	
	
	
	
}
