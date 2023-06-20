import java.util.*;
public class DisconnectedBFS {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    public static void creation(ArrayList<Edge> graph[]){
        for(int i=0;i<5;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));
    }

    public static void bfs(ArrayList<Edge> graph[], boolean vis[], int start ){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(vis[curr]==false){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void main(String args[]){
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        creation(graph);
        boolean vis[]=new boolean[v];
        for(int i=0;i<vis.length;i++){
            if(vis[i]==false){
                bfs(graph, vis, i);
            }
        }
        // for(int i=0;i<v;i++){
        //     for(int j=0;j<graph[i].size();j++){
        //         Edge e=graph[i].get(j);
        //         System.out.println(e.src+" "+e.dest);
        //     }
        // }
    }
}
