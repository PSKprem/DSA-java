package Graph;
// import java.util.*;
public class Degree {
    int n=5;
    public static void count( int n,int[][] edges){
        
        int[]  indegree= new int[n+1];
        int []outdegree= new int[n+1];

        for (int[] pair: edges){

            int u= pair[0];
            int v= pair[1];

            indegree[v]+=1;
            outdegree[u]+=1;
        }
        for(int i=0;i<n;i++){
            System.out.println("node ->"+ i+ " "+

            "indegree ->"+indegree[i]+" "+
            " & outdegree ->"+outdegree[i]);


        }
        // return ans;

        
        
    } 
    public static void main(String[] args) {
    
        int n=5;
        int[][] edges= new int[][]{{0,1},{0,2},{1,3},{1,4}};
        count(n,edges);
    }   
    
}
