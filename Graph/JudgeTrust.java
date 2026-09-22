package Graph;
import java.util.*;
//  judge trust no one 
// everyone trust judge but judge trust no one
class JudgeTrust{
    public int findjudge(int n, int[][] trust){
        
        // int[] indegree= new int[n+1];
        // int[] outdegree= new int[n+1];

        // for (int i=0;i<trust.length;i++){
        //     outdegree[trust[i][0]]++;
        //     indegree[trust[i][1]]++;
        // }

        // for (int i=1;i<=n;i++){
        //     if (indegree[i]==n-1 && outdegree[i]==0){
        //         return i;
        //     }
        // }
        // return -1;
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for (int i=0;i<=n;i++){
            map.putIfAbsent(i, new ArrayList<>());

        }
        int INdegree[]= new int[n];
        int OUTdegree[]= new int[n];
        for(int pair[]: trust){
            int u=pair[0];
            int v=pair[1];
            INdegree[v-1]+=1;
            OUTdegree[u-1]+=1;

            map.get(u).add(v);
        }
        int judge=-1;
        for(int i=1;i<=n;i++){
            if(INdegree[i-1]==n-1 && OUTdegree[i-1]==0){
                judge=i;
                return judge;
            }
        }
        return judge;
        }

    public static void main(String[] args) {
        int n=4;
        int[][] trust=(new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}});
        JudgeTrust obj= new JudgeTrust();
        int ans=obj.findjudge(n,trust);
        System.out.println(ans);
        
    }


    }


