import java.util.*;
public class DisconnectedDFS {

    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void creation(ArrayList<Edge> graph[]){
        for(int i=0;i<7;i++)
        graph[i]=new ArrayList<Edge>();
        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));
    }
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false)
                dfs(graph, e.dest, vis);
        }
    }
    
    public static void main(String args[]){
        int v=7;
        ArrayList<Edge> graph[]=new ArrayList[v];
        creation(graph);
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(vis[i]==false)
            dfs(graph,i,vis);
        }
    }
}


