
import java.util.ArrayList;
import java.util.List;

public class FriendsGroups {
    public int largestGroup(int n, int[][] friendships) {
        List<List<Integer>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Friendships add karo
        // Friendship two-way hai, isliye dono directions add hongi
        for (int i = 0; i < friendships.length; i++) {
            int a = friendships[i][0];
            int b = friendships[i][1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // Step 3: Visited array banao
        boolean[] visited = new boolean[n];
        
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(i, graph, visited);
                maxSize = Math.max(maxSize, size);
            }
        }

        return maxSize;
    }

        private int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;

        for (int friend : graph.get(node)) {
            if (!visited[friend]) {
                count += dfs(friend, graph, visited);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FriendsGroups sol = new FriendsGroups();

        int n = 7;

        int[][] friendships = {
            {0, 1},
            {1, 2},
            {3, 4},
            {2, 0},
            {1, 0}
        };

        int result = sol.largestGroup(n, friendships);

        System.out.println(result);
    }
}
    

