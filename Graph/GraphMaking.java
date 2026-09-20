package Graph;

public class GraphMaking {
    private int V; // number of vertices

    private int [][] Matrix; // adjacency matrix

    // constructor
    public GraphMaking(int V){
        this.V=V;
        this.Matrix=new int[V][V];


    }
    void addedge(int u, int v){
        Matrix[u][v]=1;
        Matrix[v][u]=1;
    }

    void Printgraph(){
        for(int i=0;i<V;i++){
            for(int j =0;j<V;j++){
                System.out.print(Matrix[i][j]+ " ");

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        GraphMaking g = new GraphMaking(5);
        g.addedge(0, 1);
        g.addedge(0, 4);
        g.addedge(1, 2);
        g.addedge(1, 3);
        g.addedge(1, 4);
        g.addedge(2, 3);
        g.addedge(3, 4);
        g.Printgraph();
    }
    
}
