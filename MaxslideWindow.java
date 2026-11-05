/*
 * Question: Sliding Window Maximum (LeetCode #239)
 * 
 * You are given an array of integers nums, there is a sliding window of size k,
 * which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * Return the max sliding window.
 */

import java.util.*;

public class MaxslideWindow {

    // Monotonic Decreasing Deque Approach - O(N) Time, O(K) Auxiliary Space
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0 || k > nums.length) {
            return new int[0];
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // Deque stores INDICES in strictly decreasing order of their corresponding values
        Deque<Integer> dq = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            // 1. Remove indices that are out of the current sliding window [r - k + 1 .. r]
            if (!dq.isEmpty() && dq.peekFirst() < r - k + 1) {
                dq.pollFirst();
            }

            // 2. Remove all indices from the back whose values are <= nums[r]
            // because nums[r] is larger and newer, so those smaller elements can never be the maximum
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[r]) {
                dq.pollLast();
            }

            // 3. Add current index to the back
            dq.offerLast(r);

            // 4. Once the first window of size k is formed (r >= k - 1),
            // the front element (peekFirst) is guaranteed to be the maximum of the current window
            if (r >= k - 1) {
                ans[r - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard LeetCode Example
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println("Test Case 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output:   " + Arrays.toString(maxSlidingWindow(nums1, k1)));
        System.out.println("Expected: [3, 3, 5, 5, 6, 7]\n");

        // Test Case 2: Single Element Window
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Test Case 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output:   " + Arrays.toString(maxSlidingWindow(nums2, k2)));
        System.out.println("Expected: [1]\n");

        // Test Case 3: Strictly Decreasing Array
        int[] nums3 = {9, 8, 7, 6, 5};
        int k3 = 3;
        System.out.println("Test Case 3:");
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("Output:   " + Arrays.toString(maxSlidingWindow(nums3, k3)));
        System.out.println("Expected: [9, 8, 7]");
    }
}
