import java.util.*;
public class PrimAlgorithm {
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
        for(int i=0;i<4;i++){
            graph[i]=new ArrayList<Edge>();
        }   
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));
        graph[1].add(new Edge(1,3,40));
        graph[1].add(new Edge(1,0,10));
        graph[2].add(new Edge(2,3,50));
        graph[2].add(new Edge(2,0,15));
        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }
    public static class Pair implements Comparable<Pair>{
        int src;
        int cost;
        public Pair(int s, int c){
            this.src=s;
            this.cost=c;
        }
        @Override
        public int compareTo(Pair P2){
            return this.cost-P2.cost;
        }
    }
    public static void primAlgo(ArrayList<Edge> graph[], int v){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        boolean vis[]=new boolean[v];
        pq.add(new Pair(0,0));
        int mstCost=0;
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(vis[curr.src]==false){
                vis[curr.src]=true;
                mstCost+=curr.cost;
                for(int i=0;i<graph[curr.src].size();i++){
                    Edge e=graph[curr.src].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }
        System.out.println(mstCost);

    }
    public static void main(String args[]){
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        creation(graph);
        primAlgo(graph, v);
    }
}
