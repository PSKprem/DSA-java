package Graph;
import java.util.*;

class DFS{

static int V;
static ArrayList<ArrayList<Integer>>adj;
//DFS function

static void dfs(int node ,boolean[] visited){
    //mark the current node as viusited'

    visited[node]= true;
    System.out.print(node + " ");

    for (int neig : adj.get(node)){
        if (!visited[neig]){
            dfs(neig,    visited);
        }
    }
}

public static void main(String[] args) {
    V=5;
    adj= new ArrayList<>();
    for (int i=0;i<V;i++){
        adj.add(new ArrayList<>());
    }
    // add edges

    adj.get(0).add(1);
    adj.get(0).add(2);
    adj.get(1).add(0);
    adj.get(1).add(3);
    adj.get(1).add(4);
    adj.get(2).add(0);
    adj.get(3).add(1);
    adj.get(4).add(1);
//     adj.get(0).add(1);
//     adj.get(0).add(1);
//     adj.get(0).add(1);

//visited array
boolean[] visited=  new boolean[V];
dfs(0, visited);
}



}


