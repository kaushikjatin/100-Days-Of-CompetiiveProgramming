// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#


// ALGO -> To detect cycle in directed graph you need to keep the path also.....and whenever you encounter a backedge...you need
// to check that the node which makes backedge was in the path already.......and if it was present then there is cycle present...
// here visited[] arr is used as a path array...you can see it have 3 different values...instead of being a boolean array.
class Solution
{
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // 0 not visited
        // 1 visited 
        // 2 in the path
        int visited[]=new int[V];
        for(int i=0;i<V;i++)
            if(visited[i]==0 && dfs(i,visited,adj))
                return true;
        return false;
    }
    
    public static boolean dfs(int node,int visited[],ArrayList<ArrayList<Integer>> graph)
    {
        visited[node]=2;
        for(int i=0;i<graph.get(node).size();i++)
        {
            int child=graph.get(node).get(i);
            if(visited[child]==2)
                return true;
            if(visited[child]==0 && dfs(child,visited,graph))
                return true;
        }
        visited[node]=1;
        return false;
    }
}