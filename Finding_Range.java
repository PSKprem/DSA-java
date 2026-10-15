import java.util.*;

//Problem: Given a sorted array that may contain duplicates, find the first and last index of the target.


public class Finding_Range {

    static int[] searchingRange(int[]arr,int target){
        int first=-1;
        int last=-1;

        int left=0;
        int right=arr.length-1;

        //finding first occerence

        while (left<=right){
            int mid= left+(right-left)/2;

            if(arr[mid]==target){
                first=mid;
                right=mid-1;  //continue searching left

            } else if (arr[mid]<target){
                left= mid +1;
            }else{
                right= mid-1;
            }
        }
        left=0;
        right = arr.length-1;

        // find last occurance

        while (left<=right) {
            int mid= left+(right - left)/2;

            if(arr[mid]== target){
                last=mid;
                left=mid+1;// continues searching right


            }else if (arr[mid]<target){
                left=mid+1;
            }else{
                right= mid-1;
            }
            
        }
        return  new int[]{first,last};
    }

    public static void main(String[] args) {
        int []arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        System.out.println(Arrays.toString(searchingRange(arr, target) ) );
        
    }
    
}
