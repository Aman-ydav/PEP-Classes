class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        int[] color = new int[n];
        Arrays.fill(color,-1);
        return dfs(graph,vis,color);
    }
    boolean dfs(int[][] graph,boolean[] vis,int[] color){
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(!dfsUtil(graph,vis,color,i,true)) return false;
            }
        }
        return true;
    }
    boolean dfsUtil(int[][] graph,boolean[] vis,int[] color,int src,boolean toggle){
        
        vis[src] = true;
        color[src] = toggle?0:1;
        for(int i=0;i<graph[src].length;i++){
            int dest = graph[src][i];
            if(color[dest]==color[src]) return false;
            if(!vis[dest]){
                vis[dest] = true;
                color[dest] = toggle?0:1;
                if(!dfsUtil(graph,vis,color,dest,!toggle)) return false;
            }

        }
        return true;
    }
}