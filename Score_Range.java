/*
    The scholarship committee is still studying the same test results.
     Committee members keep asking questions of the form “How many students scored between L and R?” 
     There are a lot of questions, and you must answer all of them.

What you write
You only write one function. The code that reads the input and prints your answers is already provided.

scores contains the n scores, in no particular order. Scores may repeat.
queries contains q queries. Each query is a pair [L, R]. In Java, queries[i][0] is L and queries[i][1] is R.
Return a list (Java: an array) of q integers. The i-th number is how many scores s satisfy L ≤ s ≤ R for the i-th query.
 Both ends are included.


Sample 1
Input

6 4
40 10 20 20 30 50
20 40
21 29
0 100
50 50
Output

4
0
6
1
Explanation.

Query [20, 40]: the scores 20, 20, 30 and 40 → 4. Both ends count.
Query [21, 29]: no score lies in this range → 0.
Query [0, 100]: all six scores → 6.
Query [50, 50]: only the score 50 → 1.
*/

import java.util.*;
public class Score_Range {


    public static int[] countInRange(int[] scores, int[][] queries) { 
        Arrays.sort(scores);
        int [ ]ans = new int[queries.length];
        for (int i=0;i<queries.length;i++){
        int L= queries[i][0];
        int R= queries[i][1];

        int left= lowerBound(scores,L);
        int right= upperBound(scores,R);

        ans[i]=right- left;
    }
    return  ans;


}

static int lowerBound(int[] scores, int target) {

        int left = 0;
        int right = scores.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static int upperBound(int[] scores, int target) {

        int left = 0;
        int right = scores.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

   public static void main(String[] args) {

        int[] scores = {40, 10, 20, 20, 30, 50};

        int[][] queries = {
            {20, 40},
            {21, 29},
            {0, 100},
            {50, 50}
        };

        int[] result = countInRange(scores, queries);

        for (int x : result) {
            System.out.println(x);
        }
    }
    
}
