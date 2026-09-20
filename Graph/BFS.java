package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFS {
    int V;
    ArrayList<ArrayList<Integer>>adj;

    //Constrauctor 

    BFS(int V){
        this.V=V;

        adj=new  ArrayList<>();

        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }

    //Add UNdirected edges

    void addEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    //BFS COdde

    void bfs(int start){
        int v= adj.size();
        boolean [] Visited= new boolean[v];

        Queue<Integer> queue= new ArrayDeque<>();
        queue.add(start);
        Visited[start]= true;

        while (!queue.isEmpty()) {
            int node= queue.poll();
            System.out.print(node + " ");

            for ( int neighbour : adj.get(node)){
                if(!Visited[neighbour]){
                    Visited[neighbour]= true;
                    queue.add(neighbour);
                }
         }
            
        }
    }
    
    public static void main(String[] args) {
        BFS graph= new BFS(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        // graph.addEdge(0, 1);
        // graph.addEdge(0, 1);

        System.out.println("BFS");

        graph.bfs(0);

    }

    // agr tujhe chahu to tum kuchh bhi kr lo jahan tk tum pahuch ja sakta hai
    
}
