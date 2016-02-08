package djikstra;

import java.io.File;
import java.util.*;

public class Djikstra {	
	     
    public void start () throws Exception
	{
	    int n, m;
	    List<String> newEdges = new ArrayList<String>();
	    List<Integer> nodes = new ArrayList<Integer>();
	    
	    Scanner scanIn = new Scanner(new File("/root/foa/foa_assignment_1/src/djikstra/input.txt"));
        String numberOfVertices = scanIn.nextLine();
        n = Integer.parseInt(numberOfVertices);
        
        int [][] a = new int[n][n];
        int [] distances = new int[n];
        int [] previous = new int[n];
        int [] visited = new int[n];
        DjikstraPQ pq = new DjikstraPQ();
        
        for(int i = 0 ; i < n; i++){
        	Arrays.fill(a[i], Integer.MAX_VALUE);
        	distances[i] = Integer.MAX_VALUE;
        }
        
        String numberOfEdges = scanIn.nextLine();
        m = Integer.parseInt(numberOfEdges);
        
        String edge;
        String [] edgeParts;
        
        for(int index = 0; index < m; index++){
            
            edge = scanIn.nextLine();
            edgeParts = edge.split(":");
            
            int i = Integer.parseInt(edgeParts[0]);
            int j = Integer.parseInt(edgeParts[1]);
            int value = Integer.parseInt(edgeParts[2]);
            
            a[i][j] = value;
        }
        
        String temp = scanIn.nextLine();
        int newEdgeCount = Integer.parseInt(temp);
        
        for(int index = 0; index < newEdgeCount; index++){
            
            edge = scanIn.nextLine();
            newEdges.add(edge);
        }
        
        temp = scanIn.nextLine();
        int s = Integer.parseInt(temp);
        
        temp = scanIn.nextLine();
        int d = Integer.parseInt(temp);
        
        distances[s] = 0;
        
        for(int i = 0; i < n; i++){
        	pq.insert(i, distances[i]);
        }
        
        int min;
        
        while(!pq.isEmpty()){
            
        	
        	
            int u = pq.getMinElement().index;
            
            if(visited[u] != 1){
            	
            	min = distances[u];
            	for(int i = 0; i < n; i++){
                    
                	if(i == u) continue;
                	
                	
                	
                    if(a[u][i]!= Integer.MAX_VALUE && min + a[u][i] < distances[i])
                    {
                        distances[i] = min + a[u][i];
                        previous[i] = u; 
                        pq.insert(i, distances[i]);
                    }
                    
                }
                visited[u] = 1;
            }
            
            
            
        }
        
        System.out.println("Shortest Distance: " + distances[d]);
        
        System.out.print("Shortest Path: ");
        int pre = previous[d];
        System.out.print(d + " - ");
        nodes.add(d);
        while(pre != s){
        	nodes.add(pre);
        	System.out.print(pre + " - ");
        	pre = previous[pre];
        }
        nodes.add(s);
        System.out.println( s);
        
        int [] newShortestDistances = new int[newEdgeCount];
        int [] reduction = new int[newEdgeCount];
        int maxReduction = -1;
        int maxIndex = -1;
        
        for(int i = 0; i < newEdgeCount; i++){
        	
        	edge = newEdges.get(i);
        	edgeParts = edge.split(":");
            
            int p = Integer.parseInt(edgeParts[0]);
            int q = Integer.parseInt(edgeParts[1]);
            int value = Integer.parseInt(edgeParts[2]);
            
            if(distances[p] + value > distances[q]){
            	System.out.println( i + "- No reduction possible.");
            	newShortestDistances[i] = -1;
            	reduction[i] = 0;
            } else {

            	reduction[i] = distances[q] - value - distances[p];
            	newShortestDistances[i] = distances[d] - reduction[i];
            	System.out.println(i +  "- Reduction = " + reduction[i]);
             	
            }
            
            if(reduction[i] > maxReduction){
            	maxReduction = reduction[i];
            	maxIndex = i;
            }
            
        }
        
        System.out.println("Max-Reduction: " + maxIndex + "- " + reduction[maxIndex]);
        scanIn.close();
	}
}

