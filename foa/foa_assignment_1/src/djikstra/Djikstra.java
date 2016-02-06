package djikstra;

import java.io.File;
import java.util.*;

public class Djikstra {	
	     
    public void start () throws Exception
	{
	    int n, m;
	    
	    Scanner scanIn = new Scanner(new File("/root/foa/foa_assignment_1/src/djikstra/input.txt"));
        String numberOfVertices = scanIn.nextLine();
        n = Integer.parseInt(numberOfVertices);
        
        int [][] a = new int[n][n];
        int [][] b = new int[n][n];
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
        int k = Integer.parseInt(temp);
        
        for(int index = 0; index < k; index++){
            
            edge = scanIn.nextLine();
            edgeParts = edge.split(":");
            
            int i = Integer.parseInt(edgeParts[0]);
            int j = Integer.parseInt(edgeParts[1]);
            int value = Integer.parseInt(edgeParts[2]);
            
            b[i][j] = value;
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
        
        if(visited [d] == 0 ){
            System.out.println("No path");
        } else {
            
            System.out.println("Shortest distance: " + distances[d]);
            
        }
        scanIn.close();
	}
}

