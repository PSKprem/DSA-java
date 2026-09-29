package Graph;
import  java.util.*;


public class CycleDetection {

    static boolean dfs(int node,int parent, ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[node] = true;
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour,node,adj,visited)){
                    return true;
                }
            }else if(neighbour != parent){
                return true;
            }

        }
        return false;
    }
        
        static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
            boolean[] visited = new boolean[V];
            for(int i=0;i<V;i++){
                if(!visited[i]){
                    if(dfs(i,-1,adj,visited)){
                        return true;
                    }
                }
            }
            return false;
        }

        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            int V = sc.nextInt();
            int E = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<E;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            if(isCycle(V,adj)){
                System.out.println("Cycle Detected");
            }else{
                System.out.println("No Cycle Detected");
         
            }
        }

    }
