public class Min_SizeSubArray {

    public static int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int sum=0;
        int minlength= Integer.MAX_VALUE;

        for (int right=0;right<nums.length;right++){
            sum= sum+nums[right];

            while (sum>=target) {
                int currentlength= right-left+1;

                minlength= Math.min(minlength, currentlength);

                sum= sum-nums[left];
                left++;

                
            }
        }
        if (minlength==Integer.MAX_VALUE){
            return 0;
        }
        return minlength;


    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3,7};
        int target = 7;

        // Find and print the minimum subarray length.
        System.out.println(minSubArrayLen(target, nums));
        
    }
    
}
