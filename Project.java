
/*There are n projects you can attend. For each project, you know its starting and ending days and the amount of money you would get as reward. You can only attend one project during a day.
What is the maximum amount of money you can earn?
Input
The first input line contains an integer n: the number of projects.
After this, there are n lines. Each such line has three integers a_i, b_i, and p_i: the starting day, the ending day, and the reward.
Output
Print one integer: the maximum amount of money you can earn */
import java.util.*;
public class Project {
        
    public static int maxEarnings(int[][] projects) {
        Arrays.sort(projects, (a, b) -> a[1] - b[1]); // Sort by ending day
        int n = projects.length;
        int[] dp = new int[n];
        dp[0] = projects[0][2]; // Initialize with the reward of the first project

        for (int i = 1; i < n; i++) {
            int includeProfit = projects[i][2];
            int l = binarySearch(projects, i);
            if (l != -1) {
                includeProfit += dp[l];
            }
            dp[i] = Math.max(dp[i - 1], includeProfit);
        }
        return dp[n - 1];


        

    }
    private static int binarySearch(int[][] projects, int i) {
        int low = 0;
        int high = i - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (projects[mid][1] < projects[i][0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;    
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] projects = new int[n][3];
        for (int i = 0; i < n; i++) {
            projects[i][0] = sc.nextInt(); // starting day
            projects[i][1] = sc.nextInt(); // ending day
            projects[i][2] = sc.nextInt(); // reward
        }
        int result = maxEarnings(projects);
        System.out.println(result);
        sc.close();
    }

    
}
