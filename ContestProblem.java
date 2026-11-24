// import java.util.*;
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

    


    public static void main(String[] args) {
        
    }
}