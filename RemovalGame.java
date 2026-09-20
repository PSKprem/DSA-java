import java.util.Arrays;
import java.util.Scanner;
public class RemovalGame {

    public static int optimal_score(int n, int[] arr){ 
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            dp[i][i] = arr[i];
        }
        for(int len=2; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j = i + len - 1;
                dp[i][j] = Math.max(arr[i] - dp[i+1][j], arr[j] - dp[i][j-1]);
            }
        }
        return (dp[0][n-1] + Arrays.stream(arr).sum()) / 2;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(optimal_score(n, arr));
        sc.close();
        
    }
    
}
