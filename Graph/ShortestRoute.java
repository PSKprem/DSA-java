package Graph;
import java.util.*;
/*
There are n cities and m flight connections between them. 
Your task is to determine the length of the shortest route from Syrjälä to every city.
Input
The first input line has two integers n and m: the number of cities and flight connections.
 The cities are numbered 1,2,\dots,n, and city 1 is Syrjälä.
After that, there are m lines describing the flight connections.
 Each line has three integers a, b and c: a flight begins at city a, ends at city b,
  and its length is c. Each flight is a one-way flight.
You can assume that it is possible to travel from Syrjälä to all other cities.
Output
Print n integers: the shortest route lengths from Syrjälä to cities 1,2,...,n.

Example
Input:
3 4
1 2 6
1 3 2
3 2 3
1 3 4

Output:
0 5 2

*/


public class ShortestRoute {
    
    public static void main(String[] args) {
       StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
            adj.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u])
                 continue;
            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
    
}
