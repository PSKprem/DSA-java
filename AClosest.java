
/*
  AClosest Scores
Time limit: 2 seconds for Java, 6 seconds for Python. Memory limit: 1024 MB.

The national scholarship test has just been graded. Scores are published on a very fine scale, 
from 0 to 1 000 000 000. Before printing the results, 
the committee wants to know how close the two closest students came:
 the smallest difference between the scores of any two different students.

Given the scores of all n students, find that smallest difference. 

scores contains the n scores, in no particular order.
Return the smallest value of |scores[i] − scores[j]| over all pairs of different students i ≠ j.
If two students have the same score, the answer is 0.


Sample 1
Input

5
50 12 31 48 5
Output

2
Explanation. The closest pair is 50 and 48, a difference of 2. They are not next to each other in the input.

*/

import java.util.*;
public class AClosest{

    public static  int closestGap(int[]score){
        // int n= score.length;
        // // int[] list = new int[n];

        // int temp_min=Integer.MAX_VALUE;
        // for (int i=0;i<n;i++){

        //     for (int j=i+1;j<n;j++){
        //         int min=0;

        //         if(score[i]>score[j]){
        //             min=score[i]-score[j];
        //         }
        //         else{
        //             min =score[j]-score[i];
        //         }
        //         temp_min= Math.min(temp_min, min);
            
        //     }
            
        // }
        // return  temp_min;

        //  Another approach;
        int n= score.length;
        Arrays.sort(score);
        int tempDiff= Integer.MAX_VALUE;
        for (int i=1;i<n;i++){
            tempDiff=Math.min(tempDiff, score[i]-score[i-1]);
        }return  tempDiff;

        
    }
    
    public static void main(String[] args) {
        int[] score = new int[]{50, 12, 31, 48, 5};
        System.out.println(closestGap(score));
        
        
    }

}
