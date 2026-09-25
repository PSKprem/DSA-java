//Print all nodes using DFS


package Graph;
import java.util.*;

public class GraphTraversal {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;

    static void dfs(int node) {

        // 1. Mark current node visited
        visited[node] = true;

        // 2. Process node
        System.out.print(node + " ");

        // 3. Visit all neighbours
        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour);
            }
        }
    }

    public static void main(String[] args) {

        int V = 4;

        // Create adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        visited = new boolean[V];

        // Start DFS from node 0
        dfs(0);
    }
}