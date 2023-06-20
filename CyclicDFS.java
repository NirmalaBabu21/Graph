import java.util.*;
public class CyclicDFS {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void creation (ArrayList<Edge> graph[]){
        for(int i=0;i<6;i++)
        graph[i]=new ArrayList<Edge>();
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        //graph[1].add(new Edge(1,4));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,2));
        graph[4].add(new Edge(4,0));
        //graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));    
        graph[5].add(new Edge(5,4)); 


    }
    public static boolean dfs(ArrayList<Edge> graph[], boolean vis[], int curr, int parent){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(vis[e.dest]==true && parent!=e.dest)
            return true;
            else if (vis[e.dest]==false){
                if(dfs(graph, vis, e.dest, curr))
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<Edge> graph[]=new ArrayList[6];
        boolean vis[]=new boolean[6];
        creation(graph);
        System.out.println(dfs(graph, vis, 0, -1));
     
    }
}
