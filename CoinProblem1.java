import java.util.*;

public class CoinProblem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();

        Arrays.sort(coins);

        final int MOD = 1_000_000_007;
        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= x; sum++) {
            int ways = 0;

            for (int coin : coins) {
                if (coin > sum)
                    break;

                ways += dp[sum - coin];

                if (ways >= MOD)
                    ways -= MOD;
            }

            dp[sum] = ways;
        }

        System.out.println(dp[x]);
        sc.close();
    }
}