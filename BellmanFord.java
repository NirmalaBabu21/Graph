import java.util.ArrayList;

public class BellmanFord {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void creation (ArrayList<Edge> graph[]){
        for(int i=0;i<5;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,2,-4));
        graph[2].add(new Edge(2,3,2));
        graph[3].add(new Edge(3,4,4));
        graph[4].add(new Edge(4,1,-1));
    }
    public static void bellman(ArrayList<Edge> graph[], int v, int s){
        int D[]=new int[v];
        for(int i=0;i<v;i++){
            if(i!=s)
            D[i]=Integer.MAX_VALUE;
        }
        for(int k=0;k<v-1;k++){
            for(int i=0;i<v;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e=graph[i].get(j);
                    int u=e.src;
                    int w=e.dest;
                    if(D[u]!=Integer.MAX_VALUE && D[u]+e.wt<D[w] ){
                        D[w]=D[u]+e.wt;
                    }
                }
            }
        }
        for(int i=0;i<v;i++)
        System.out.print(D[i]+" ");
    }
    public static void main(String args[]){
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        creation(graph);
        bellman(graph, v, 0);
    }
}
