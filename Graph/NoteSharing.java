package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class NoteSharing {

    static List<Integer> solve(int n, int m, int[] a, int[] b) {

        // --------------------------------------------------
        // 1. CREATE ADJACENCY LIST
        // --------------------------------------------------

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Students are numbered from 1 to n.
        // Therefore we create n + 1 lists.
        // Index 0 will not be used.
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // --------------------------------------------------
        // 2. ADD FRIENDSHIP EDGES
        // --------------------------------------------------

        for (int i = 0; i < m; i++) {

            // a[i] and b[i] are friends.
            // Friendship is bidirectional.
            adj.get(a[i]).add(b[i]);
            adj.get(b[i]).add(a[i]);
        }

        // --------------------------------------------------
        // 3. BFS STARTING FROM STUDENT 1
        // --------------------------------------------------

        boolean[] visited = new boolean[n + 1];

        // Notes always start from student 1.
        int start = 1;

        bfs(start, adj, visited);

        // --------------------------------------------------
        // 4. FIND STUDENTS WHO DID NOT RECEIVE THE NOTE
        // --------------------------------------------------

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            // false means this student was not reachable
            // from student 1.
            if (!visited[i]) {
                list.add(i);
            }
        }

        return list;
    }


    // ------------------------------------------------------
    // BFS FUNCTION
    // ------------------------------------------------------

    static void bfs(int start,
                    ArrayList<ArrayList<Integer>> adj,
                    boolean[] visited) {

        Queue<Integer> q = new ArrayDeque<>();

        // Student 1 receives the note initially.
        visited[start] = true;

        // VERY IMPORTANT:
        // Put the starting student into the queue.
        q.offer(start);

        while (!q.isEmpty()) {

            // Remove one student from the queue.
            int node = q.poll();

            // Check all friends of this student.
            for (int neigh : adj.get(node)) {

                // If this friend has not received the note yet.
                if (!visited[neigh]) {

                    // Give the note to this friend.
                    visited[neigh] = true;

                    // This friend will also share the note
                    // with their friends.
                    q.offer(neigh);
                }
            }
        }
    }


    // ------------------------------------------------------
    // MAIN FUNCTION
    // ------------------------------------------------------

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input:
        // n = number of students
        // m = number of friendship pairs

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[m];
        int[] b = new int[m];

        // Read all friendship pairs.
        for (int i = 0; i < m; i++) {

            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        // Solve the problem.
        List<Integer> result = solve(n, m, a, b);

        // Number of students who did not receive the note.
        System.out.println(result.size());

        // If nobody missed the note, print only 0.
        if (result.size() > 0) {

            for (int student : result) {
                System.out.print(student + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}