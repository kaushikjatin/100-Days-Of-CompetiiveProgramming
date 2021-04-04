class Solution
{
    static boolean visited[];
    static int order[];
    static int index=0;
    static int ans=0;
    static ArrayList<ArrayList<Integer>> reversed;
    static ArrayList<ArrayList<Integer>> components;
    public void kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        index=0;
        ans=0;
        visited=new boolean[V];
        order=new int[V];
        reversed=new ArrayList<>();
        components=new ArrayList<>();
        memset();
        for(int i=0;i<V;i++)
            if(!visited[i])
                dfs(i,adj);
        reverse_graph(adj);
        memset();
        for(int i=V-1;i>=0;i--)
            if(!visited[order[i]])
            {
                components.add(new ArrayList<Integer>());
                ans++;
                reverse_dfs(order[i]);
            }
        print_components();
    }
    
    public static void print_components()
    {
        for(int i=0;i<components.size();i++)
        {
            for(int j=0;j<components.get(i).size();j++)
            {
                System.out.print(components.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    
    public static void reverse_dfs(int node)
    {
        visited[node]=true;
        components.get(ans-1).add(node);
        for(int i=0;i<reversed.get(node).size();i++)
        {
            int child=reversed.get(node).get(i);
            if(!visited[child])
                reverse_dfs(child);
        }
    }
    
    
    public static void reverse_graph(ArrayList<ArrayList<Integer>> graph)
    {
        int V=graph.size();
        for(int i=0;i<V;i++)
            reversed.add(new ArrayList<Integer>());
        for(int i=0;i<V;i++)
        {
            int parent=i;
            for(int j=0;j<graph.get(i).size();j++)
            {
                int child=graph.get(i).get(j);
                reversed.get(child).add(parent);
            }
        }
    }
    
    public static void memset()
    {
        for(int i=0;i<visited.length;i++)
            visited[i]=false;
    }
    
    public static void dfs(int node,ArrayList<ArrayList<Integer>> graph)
    {
        visited[node]=true;
        for(int i=0;i<graph.get(node).size();i++)
        {
            int child=graph.get(node).get(i);
            if(!visited[child])
                dfs(child,graph);
        }
        order[index++]=node;
    }
}