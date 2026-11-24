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

    public boolean isSubsequences(String s, String t){
        int i=0; int j =0;

        while( i<s.length() &&  j<t.length()){
            if(s.charAt(i)==t.charAt(j)) i++;
            j++;
        }
        return i==s.length();
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



    public static void main(String[] args) {
        
    }
}