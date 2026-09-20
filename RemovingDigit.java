import java.util.Scanner;

public class RemovingDigit {
    public int findMinStep(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            int temp = i;

            while (temp > 0) {
                int digit = temp % 10;

                if (digit > 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - digit]);
                }

                temp /= 10;
            }
        }

        return dp[n];
    }

    public static void main(String[ ]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        RemovingDigit obj = new RemovingDigit();
        int result = obj.findMinStep(n);
        System.out.println(result);
        sc.close();
    }
}
