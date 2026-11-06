import java.util.*;

public class MaxslideWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // Deque me INDICES store honge, aur unki values decreasing order me rahengi
        Deque<Integer> dq = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            // 1) Front se expired index hatao (jo window [r - k + 1 .. r] se bahar hai)
            if (!dq.isEmpty() && dq.peekFirst() < r - k + 1) {
                dq.pollFirst();
            }

            // 2) Back se saare chhote/barabar elements hatao (nums[r] unse behtar hai)
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[r]) {
                dq.pollLast();
            }

            // 3) Current index back me jodo
            dq.offerLast(r);

            // 4) Jab window size k poora ho jaye, front par sabse bada element milega!
            if (r >= k - 1) {
                ans[r - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 6;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println("Output: " + Arrays.toString(result));
    }
}
