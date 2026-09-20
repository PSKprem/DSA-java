/*
 Consider an n \times n grid whose squares may have traps. It is not allowed to move to a square with a trap.
Your task is to calculate the number of paths from the upper-left square to the lower-right square. You can only move right or down. */

// import java.io.*;
import java.util.*;

public class GridPath {
    public static int countPaths(char[][] grid, int i, int j, int n, int[][] dp) {
        if (i >= n || j >= n || grid[i][j] == '*') {
            return 0;
        }
        if (i == n - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int rightPaths = countPaths(grid, i, j + 1, n, dp);
        int downPaths = countPaths(grid, i + 1, j, n, dp);
        dp[i][j] = (rightPaths + downPaths) % 1000000000;   // why we do modulo 1000000000? Because the number of paths can be very large, and we want to avoid integer overflow. The problem statement may also specify that the answer should be given modulo 1000000007.
        return dp[i][j];
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int result = countPaths(grid, 0, 0, n, dp);
        System.out.println(result);
        sc.close();
    }
}
    



