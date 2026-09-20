import java.io.*;
import java.util.*;

public class MinimizeCoin {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] c = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            c[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[x + 1];
        Arrays.fill(dp, x + 1);
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
            for (int coin : c) {
                if (coin > i) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        System.out.println(dp[x] > x ? -1 : dp[x]);
    }
}