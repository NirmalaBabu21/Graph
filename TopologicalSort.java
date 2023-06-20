import java.util.*;
public class TopologicalSort {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void creation(ArrayList<Edge> graph[]){
        for(int i=0;i<6;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }
    public static void topSort(ArrayList<Edge> graph[], boolean vis[], Stack<Integer> stack, int curr){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false)
            topSort(graph, vis, stack, e.dest);
        }
        stack.push(curr);
    }
    public static void main(String args[]){
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        boolean vis[]=new boolean[v];
        Stack<Integer> stack=new Stack<>();
        creation(graph);
        for(int i=0;i<v;i++){
            if(vis[i]==false)
            topSort(graph, vis, stack, i);
        }
        while(!stack.isEmpty())
        System.out.print(stack.pop()+"  ");
    }
}
