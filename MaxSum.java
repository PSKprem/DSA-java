/*
Question:-  Maximum Sum Subarray of Size K.

*/

class MaxSum{

    public  static int maxsum(int [] arr, int k){
        int sum=0;
        for (int i=0; i<k;i++){
            sum=sum+arr[i];
        }

        int maxsum= sum;
        for (int i=k;i<arr.length;i++){
            sum= sum-arr[i-k]+arr[i];
            maxsum= Math.max(maxsum,sum);

        }
        return  maxsum;



    }

    public static void main(String[] args) {
        int[]nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxsum(nums, k)  );
        
    }
}