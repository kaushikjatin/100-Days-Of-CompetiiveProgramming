//https://practice.geeksforgeeks.org/problems/topological-sort/1#
class Solution 
{
    static int index;
    static boolean visited[];
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int ans[]=new int[V];
        visited=new boolean[V];
        for(int i=0;i<V;i++)
            visited[i]=false;
        index=V-1;
        
        
        for(int i=0;i<V;i++)
            if(!visited[i])
                dfs(i,ans,adj);
        return ans;
    }
    
    public static void dfs(int node,int ans[],ArrayList<ArrayList<Integer>> graph)
    {
        visited[node]=true;
        for(int i=0;i<graph.get(node).size();i++)
        {
            int child=graph.get(node).get(i);
            if(!visited[child])
                dfs(child,ans,graph);
        }
        ans[index]=node;
        index--;
    }
}