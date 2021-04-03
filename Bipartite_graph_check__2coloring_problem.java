//https://practice.geeksforgeeks.org/problems/bipartite-graph/1#
class Solution
{
    static int color[];
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        color=new int[V];
        for(int i=0;i<V;i++)
            if(color[i]==0 && !dfs(i,adj,1))
                return false;
        return true;
    }
    
    public static boolean dfs(int node,ArrayList<ArrayList<Integer>> graph,int clr)
    {
        color[node]=clr;
        for(int i=0;i<graph.get(node).size();i++)
        {
            int child=graph.get(node).get(i);
            if(color[child]==0)
            {
                if(!dfs(child,graph,3-clr))
                    return false;
            }
            else if(color[child]==color[node])
                return false;
        }
        return true;
    }
}