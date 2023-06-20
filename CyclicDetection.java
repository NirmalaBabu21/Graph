import java.util.*;
public class CyclicDetection {

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
        
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
    
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }
    public static boolean cyclic (ArrayList<Edge> graph[], int curr, boolean vis[], boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(rec[e.dest]==true)
            return true;
            if(vis[e.dest]==false)
                if(cyclic(graph, e.dest, vis,rec))
                return true;
        }
        rec[curr]=false;
        return false;
    }
    
    public static void main(String args[]){
        int v=7;
        ArrayList<Edge> graph[]=new ArrayList[v];
        creation(graph);
        boolean vis[]=new boolean[v];
        System.out.println(cyclic(graph, 0, vis, new boolean[v]));
    }
}


