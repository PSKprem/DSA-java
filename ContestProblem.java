import java.util.*;

// import java.lang.reflect.Array;

/**
 * ContestProblem
 */
public class ContestProblem {

    public boolean isAnagram(String s,String t){

        if(s.length()!=t.length()) return false;

        int []count= new int[26];
        for (int i=0; i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;

        }
        for(int c:count)
            if(c!=0) return  false;
        return true;
    }

    


    public int floorIndex(int []arr, int key){
        int left=0; int right= arr.length-1;
        int ans=-1;
        while (left <= right){
            int mid= left+(right-left)/2;

            if (arr[mid]<= key){
                ans= mid;
                left= mid+1;
            }else{
                right= mid-1;
            }

        }return ans;
    }

    /*Problem: A secret number X is in [1, N]. Arjun always guesses the middle.
     If the guess is too low, lo = guess + 1. If too high, hi = guess - 1. Count how many guesses it takes,
      including the correct one. */

    public static int[] solveGuesses(int q, long[] N, long[] X) {
        int []res= new int[q];

        for(int j=0; j<q;j++){
            long lo=1;
            long hi=N[j];
            long target= X[j];
            int guesses=0;

            while(true){
                long guess= lo+(hi-lo)/2;
                guesses++;

                if(guess==X[j]) break;
                if(guess<X[j]) lo=guess+1;
                else hi=guess-1;
            }

            res[j]=guesses;
        }
        return  res;



    }

    /*You are given n non-negative integers. 
    The h-value of the list is the largest
     integer h such that at least h of the numbers are >= h.
        Find and return the h-value. */

    
    public static int solve_H_Value(int n, int[]a){

        Arrays.sort(a);
        int h=0;
        
// Step 3: Check whether next h-value is possible

// (h + 1)-th largest element index (n - 1 - h) par hai.
// Agar wo >= h + 1 hai, toh kam se kam (h + 1) numbers >= (h + 1) hain!
        while(h<n && a[n-1-h]>=h+1){
            h++;
        }
        return  h;

    }

/*You are given n time intervals [s_i, e_i] in arbitrary order.
 Overlapping or touching intervals (where one ends at t and another starts at t) 
 merge into one busy block.
Return two values: (number_of_blocks, longest_block_length). */


public static int[] solve_Busy_Block(int n, int[][] intervals){
    Arrays.sort(intervals,(a,b)->a[0]!=b[0]
    ? Integer.compare(a[0], b[0]) 
    : Integer.compare(a[1], b[1]));

    int blocks= 0;
    int longest=0;

    int curS= intervals[0][0];
    int curE= intervals[0][1];

    for (int i=0; i<n; i++){
        int s=intervals[i][0];
        int e=intervals[i][1];

        if(s<= curE){// Overlapping ya touching -> same block; max() nested interval handle karta hai
            curE=Math.max(curE,e);
        }else{   // purana block close kro
            blocks++;
            longest=Math.max(longest,curE-curS);
            curS=s;
            curE=e;
        }
    }
  // Aakhri block ko close karna mat bhoolna!
  blocks++;
  longest=Math.max(longest,curE-curS);
  
  return  new int []{blocks,longest};


}

/*There are n printers. Printer i is switched on at time s_i. 
After that, it prints one page every p_i seconds,
without stopping. Before time s_i, it prints nothing.
 All printers work at the same time.
Find the minimum time T by which at least m pages have been printed in total */

public static long Slove_Printer(int n, int m, int[] s, int[] p){
    long lo =0;
    long hi= Long.MAX_VALUE;

    while (lo<hi){
        long mid= lo+(hi-lo)/2;
        long pages=0;
        for (int i=0;i<n && pages<m;i++){
            if(mid> s[i]){
                pages= pages+ (mid-s[i])/p[i];
            }
        }
        if (pages>=m){
            hi=mid;
        }else{
            lo=mid+1;
        }
    }
    return  lo;
}


/* 
Problem Statement
There are N stones, numbered 1, 2, …, N. For each i 1  i  N
, the height of Stone i is h_i.
There is a frog who is initially on Stone 1.
 He will repeat the following action some number of times to reach
Stone N
If the frog is currently on Stone i,
 jump to Stone i+1 or Stone i+2. Here, a cost of |h_i − h_j| is incurred,
where j is the stone to land on.
Find the minimum possible total
 cost incurred before the frog reaches Stone N.*/



 public static  int frogJump(int[] heights) {
    int n = heights.length;
    int [] dp = new int[n];

    dp[0]= 0;

    for( int i =1; i<n;i++){
        int onejump = dp[i-1]+Math.abs(heights[i]-heights[i-1]);
        int twojump = Integer.MAX_VALUE;

        if(i>1){
            twojump= dp[i-2]+Math.abs(heights[i]-heights[i-2]);
        }
        dp[i]=Math.min(onejump,twojump);
    }
    return dp[n-1];

 }

 /*
 Given two strings s and t, return true if s is a subsequence of t,
  or false otherwise.
A subsequence of a string is a new string formed from the original
 string by deleting some (can be none) of the characters without disturbing
  the relative positions of the remaining characters. 
  */
public boolean isSubsequences(String s, String t){
        int i=0; int j =0;

        while( i<s.length() &&  j<t.length()){
            if(s.charAt(i)==t.charAt(j)) i++;
            j++;
        }
        return i==s.length();
    }

    /*
    Given an m x n grid filled with non-negative numbers, 
    find a path from top left to bottom right, which minimizes
     the sum of all numbers along its path.
    Note: You can only move either down or right at any point in time.
    */
public int minPathSum(int[][]grid){
    int m= grid.length;
    int n=grid[0].length;

    int []dp = new int [n];

    dp[0]=grid[0][0];
    for ( int c=1;c<n;c++){
        dp[c]=dp[c-1]+ grid[0][c];

    }
    for (int r=1; r<m;r++){
        dp[0]=dp[0]+grid[r][0];
        for(int c=1;c<n;c++){
            dp[c]= grid[r][c]+ Math.min(dp[c],dp[c-1]);
        }
    }
    return dp[n-1];

}



/*
Over N days, Taro can choose one of three activities each day
 — A (swim), B (catch bugs), or C (do homework) — gaining a[i], b[i],
  or c[i] points of happiness on day i.
He cannot perform the same activity on two consecutive days.
 Find the maximum total happiness points he can gain.
*/

public int maximum_Happiness(int [][] points){
    int n= points.length;
    int [][]dp = new int[n][3];
    // first day choose any one of the activity
    dp[0][0]= points[0][0];
    dp[0][1]= points[0][1];
    dp[0][2]= points[0][2];

    for(int i=1;i<n;i++){

        //Activity A today : yesterday B or C

        dp[i][0]= points[i][0]+Math.max(dp[i-1][1],dp[i-2][2]);
        //Activity B Today

        dp[i][1]= points[i][1]+Math.max(dp[i-1][0],dp[i-1][2]);
        //Activity C Today

        dp[i][2]= points[i][2]+Math.max(dp[i-1][0],dp[i-1][1]);
    }
    return Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2]));

}

    public static void main(String[] args) {
        
    }
}