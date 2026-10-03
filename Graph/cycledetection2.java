package Graph;

import java.util.ArrayList;

// import java.util.*;

public class cycledetection2 {

    // DFS function
    static boolean dfs(int node, int parent,
                       ArrayList<ArrayList<Integer>> graph,
                       boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            // If neighbor is not visited, visit it
            if (!visited[neighbor]) {

                if (dfs(neighbor, node, graph, visited)) {
                    return true;
                }

            }
            // If already visited and it is NOT the parent,
            // then a cycle exists
            else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    static boolean hasCycle(int n, int[][] edges) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // Important: graph can be disconnected
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                if (dfs(i, -1, graph, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 1},
            {3, 4}
        };

        if (hasCycle(n, edges)) {
            System.out.println("Cycle exists");
        } else {
            System.out.println("No cycle");
        }
    }
}
    
