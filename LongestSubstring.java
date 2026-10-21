import  java.util.*;

// Question  Given a string s, find the length of the longest substring that contains no repeating characters.

        // Remember: a substring is a contiguous sequence of characters.

public class LongestSubstring {
    public static  int longestSubstring(String s) {
        Set <Character> set= new HashSet<>();    // Stores characters currently inside our window. A HashSet allows fast membership checks.

        int left=0;  // initialize left 

        int maxlen=0;
        for(int right=0; right< s.length();right++){   // expand all the element 
            char current = s.charAt(right);              // Get the character entering the window
            while (set.contains(current)) {         //If this character already exists in the window, the window has a duplicate and must be shrunk.
                set.remove(s.charAt(left));          //Remove the leftmost character from the set
                // because it is leaving the window.

                left++;     // Move the window's left boundary forward.
            }
            set.add(current);

            int currentLength= right-left+1;     // Calculate the length of the current valid window.
            maxlen= Math.max(maxlen, currentLength);
        }
        return  maxlen;



    }


    public static void main(String[] args) {
        String s = "111";  // Example input string

        // Find and print the longest substring length
        // without repeating characters.
        System.out.println(longestSubstring(s));  //output 3 abc

        
    }
    
}
