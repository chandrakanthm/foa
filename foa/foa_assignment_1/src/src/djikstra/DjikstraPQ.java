package djikstra;

import java.util.PriorityQueue;

public class DjikstraPQ {
	PriorityQueue<Node> pq = new PriorityQueue<Node>();
	
	public void insert(int index, int distance){
		Node n = new Node(index, distance);
		pq.add(n);
	}
	
	public Node getMinElement(){
		return pq.remove();
	}
	
	public boolean isEmpty(){
		return pq.isEmpty();
	}
}
