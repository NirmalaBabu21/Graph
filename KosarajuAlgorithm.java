import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void creation(ArrayList<Edge> graph[]){
        for(int i=0;i<5;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
    }
    public static void topoSort(ArrayList<Edge> graph[], boolean vis[], int curr, Stack<Integer> s){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest])
            topoSort(graph, vis, e.dest, s);
        }
        s.push(curr);
    }
    public static void dfs(ArrayList<Edge> transpose[], boolean vis[], int curr){
        vis[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<transpose[curr].size();i++){
            Edge e=transpose[curr].get(i);
            if(!vis[e.dest])
            dfs(transpose, vis, e.dest);
        }
    }
    public static void kosarajuAlgo(ArrayList<Edge> graph[],int v){
        boolean vis[]=new boolean[v];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<v;i++){
            if(!vis[i])
            topoSort(graph,vis,i,s);
        }
        ArrayList<Edge> transpose[]=new ArrayList[v];
        for(int i=0;i<v;i++){
            vis[i]=false;
            transpose[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        while(!s.isEmpty()){
            int curr=s.pop();
            if(!vis[curr]){
                System.out.print("SCC: ");
                dfs(transpose, vis, curr);
                System.out.println();
            }
        }
    }

    public static void main(String args[]){
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[7];
        creation(graph);
        kosarajuAlgo(graph, v);
    }
}
