import java.util.ArrayList;

public class ArticulationPoint {
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
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));
    }
    public static void dfs(ArrayList<Edge> graph[],int curr, int parent,int dt[], 
                                        int low[],int time, boolean vis[], boolean ap[]){
        dt[curr]=low[curr]=time++;
        vis[curr]=true;
        int children=0;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(e.dest==parent)
            continue;
              else if(!vis[e.dest]){
                dfs(graph, e.dest, curr, dt, low, time, vis, ap);
                low[curr]=Math.min(low[curr],low[e.dest]);
                if(dt[curr]<=low[e.dest]&& parent !=-1){
                    ap[curr]=true;
                }
                children++;
            }
            else if(vis[e.dest]){
                low[curr]=Math.min(dt[e.dest],low[curr]);
            }
        }
        if(parent ==-1 && children>1)
        ap[curr]=true;

    }
    public static void getAP(ArrayList<Edge> graph[], int v){
        boolean ap[]=new boolean[v];
        boolean vis[]=new boolean[v];
        int dt[]=new int[v];
        int low[]=new int[v];
        for(int i=0;i<v;i++){
            if(!vis[i])
            dfs(graph,i,-1,dt,low,0,vis,ap);
        }
        for(int i=0;i<v;i++){
            if(ap[i])
            System.out.println(i);
        }
    }
    public static void main(String args[]){
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        creation(graph);
        getAP(graph,v);
    }
}
