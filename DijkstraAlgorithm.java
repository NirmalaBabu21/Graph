import java.util.*;
public class DijkstraAlgorithm {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    public static void creation(ArrayList<Edge> graph[]){
        for (int i=0;i<6;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));
        graph[2].add(new Edge(2,4,3));
        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,3));
    }
    public static class Pair implements Comparable<Pair>{
        int node;
        int dest;
        public Pair(int n, int d){
            this.node=n;
            this.dest=d;
        }
        
        @Override
        public int compareTo(Pair P2){
            return this.dest- P2.dest;
        }
        
    }
    public static void dijkstraAlgo(ArrayList<Edge>graph[], int v, int src){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        boolean vis[]=new boolean[v];
        int D[]=new int[v];
        for(int i=0;i<v;i++){
            if(i!=src)
            D[i]=Integer.MAX_VALUE;
        }
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(vis[curr.node]==false){
                vis[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e= graph[curr.node].get(i);
                    int u=e.src;
                    int w=e.dest;
                    if(D[u]+e.wt<D[w])
                    D[w]=D[u]+e.wt;
                    pq.add(new Pair(w,D[w]));
                }
            }
        }
        for(int i=0;i<v;i++)
        System.out.print(D[i]+" ");

    }
    public static void main(String args[]){
        ArrayList<Edge> graph[]=new ArrayList[6];
        creation(graph);
        dijkstraAlgo(graph, 6, 0);
    }
}
