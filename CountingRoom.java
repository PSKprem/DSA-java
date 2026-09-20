
import java.io.*;
import java.util.*;

public class CountingRoom {

    public static void dfs(char[][] graph, int i, int j, int n, int m) {

        // Stack stores coordinates as int arrays
        Deque<int[]> stack = new ArrayDeque<>();

        stack.push(new int[]{i, j});

        while (!stack.isEmpty()) {

            int[] cell = stack.pop();

            int x = cell[0];
            int y = cell[1];

            // Check boundaries and wall
            if (x < 0 || y < 0 || x >= n || y >= m || graph[x][y] == '#') {
                continue;
            }

            // Mark visited
            graph[x][y] = '#';

            // Add neighbouring cells
            stack.push(new int[]{x + 1, y});
            stack.push(new int[]{x - 1, y});
            stack.push(new int[]{x, y + 1});
            stack.push(new int[]{x, y - 1});
        }
    }

    public static void main(String[] args) {

        // Your test input file
        String filePath = "E:\\webAppDev\\test_input.txt";

        try {
            Scanner sc = new Scanner(new File(filePath));

            // First line: 1000 1000
            int n = sc.nextInt();
            int m = sc.nextInt();

            char[][] graph = new char[n][m];

            // Read the 1000 x 1000 grid
            for (int i = 0; i < n; i++) {
                graph[i] = sc.next().toCharArray();
            }

            int noRooms = 0;

            // Find every unvisited floor cell
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (graph[i][j] == '.') {

                        // Found a new room
                        noRooms++;

                        // Visit the complete connected component
                        dfs(graph, i, j, n, m);
                    }
                }
            }

            System.out.println(noRooms);

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found:");
            System.out.println(filePath);
        }
    }
}
