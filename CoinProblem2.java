// import java.util.*;

// public class CoinProblem2 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int x = sc.nextInt();

//         int[] coins = new int[n];
//         for (int i = 0; i < n; i++)
//             coins[i] = sc.nextInt();

//         final long MOD = 1_000_000_007;
//         long[] dp = new long[x + 1];
//         dp[0] = 1;

//         for (int coin : coins) {
//             for (int sum = coin; sum <= x; sum++) {
//                 dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
//             }
//         }

//         System.out.println(dp[x]);
//         sc.close();
//     }
// }

import java.util.*;

public class CoinProblem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        long[] dp = new long[x + 1];
        dp[0] = 1;

        long MOD = 1000000007;

        for (int coin : coins) {
            for (int sum = coin; sum <= x; sum++) {
                dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
            }
        }

        System.out.println(dp[x]);

        sc.close();
    }
}