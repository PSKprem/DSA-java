/*You are given an array containing n integers. 
Your task is to determine the longest increasing subsequence in the array,
 i.e., the longest subsequence where every element is larger than the previous one.
A subsequence is a sequence that can be derived from the array by 
deleting some elements without changing the order of the remaining elements
*/
// now do with memorization
import java.util.*;
public class IncreasingSubsequence {
    public static int longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLength = 0;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = longestIncreasingSubsequence(arr);
        System.out.println(result);
        sc.close();
    }
    
}
