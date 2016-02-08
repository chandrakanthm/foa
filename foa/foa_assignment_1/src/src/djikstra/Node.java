package djikstra;

import java.util.Comparator;

public class Node implements Comparable<Node>{
	
	int index;
	int priority;
	
	public Node(int index, int distance) {
		this.index = index;
		this.priority = distance;
	}


	@Override
	public int compareTo(Node o) {
		return  (this.priority < o.priority)? -1 : 1;
	}
	
}
