package Graph;

import java.util.ArrayList;

public class GraphAdjList {

    private int vertices;
    private ArrayList<ArrayList<Integer>>adj;

    GraphAdjList(int vertices){
        this.vertices=vertices;
        adj= new ArrayList<>();
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<>());

        }
    }
    void AddEdge(int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
        

    }
    void PrintGraph(){
        for (int i=0;i<vertices;i++){
            System.out.print(i+ "-->");

            for (int neighbour : adj.get(i)){
                System.out.print(neighbour + " ");

            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        GraphAdjList graph=new GraphAdjList(4);

        graph.AddEdge(0,1);
        graph.AddEdge(0,3);
        graph.AddEdge(3,2);
        graph.AddEdge(1,3);
        graph.AddEdge(1,2);

        graph.PrintGraph();
    }
    /* 
    Adjacency Matrix:
    int[][] graph = new int[V][V];

    graph[u][v] = 1;
    graph[v][u] = 1;   // undirected
    
    
Adjacency List:

ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

for (int i = 0; i < V; i++) {
    adj.add(new ArrayList<>());
}

adj.get(u).add(v);
adj.get(v).add(u);   // undirected
    */
}
