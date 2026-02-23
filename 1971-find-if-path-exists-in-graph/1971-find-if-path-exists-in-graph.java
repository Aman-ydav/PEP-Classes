class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];
        int r = edges.length;
        ArrayList<Integer>[] arr = new ArrayList[n];
        for (int i=0;i<n;i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < r; i++) {
            arr[edges[i][0]].add(edges[i][1]);
            arr[edges[i][1]].add(edges[i][0]);
        }
        return dfs(arr, source, destination, r, vis);
    }

    boolean dfs(ArrayList<Integer>[] arr, int curr, int dest, int r, boolean[] vis) {
        if (curr == dest)
            return true;

        if (vis[curr])
            return false;
        vis[curr] = true;

        for (int i = 0; i < arr[curr].size(); i++) {

            if (dfs(arr, arr[curr].get(i), dest, r, vis))
                return true;
        }

        return false;
    }
}