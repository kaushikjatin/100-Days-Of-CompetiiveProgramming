import java.util.*;
class GFG 
{
    static int max_node=100000;
    static int level=19;
    static ArrayList<ArrayList<Integer>> tree=new ArrayList<>();
    static int depth[]=new int[max_node+1];
    static int parent[][]=new int[max_node+1][level];
    
    
    public static void add(int a,int b)
    {
        tree.get(a).add(b);
        tree.get(b).add(a);
    }
    
    public static void dfs(int node,int prev)
    {
        depth[node]=depth[prev]+1;
        parent[node][0]=prev;
        for(int i=0;i<tree.get(node).size();i++)
        {
            if(tree.get(node).get(i)!=prev)
            {
                dfs(tree.get(node).get(i),node);
            }
        }
    }
    
    public static void memset(int value)
    {
        for(int i=0;i<max_node;i++)
        {
            for(int j=0;j<level;j++)
            {
                parent[i][j]=-1;
            }
        }
    }
    public static void precomputations(int n)
    {
        for(int i=1;i<level;i++)
        {
            for(int j=1;j<=n;j++)
            {
                 if(parent[j][i-1]!=-1)
                 {
                  parent[j][i]=parent[parent[j][i-1]][i-1];   
                 }
            }
        }
    }
    
    public static int lca(int u,int v)
    {
        if(depth[u]>depth[v])
        {
            int temp=u;
            u=v;
            v=temp;
        }
        int diff=depth[v]-depth[u];
       // System.out.println(diff+" "+parent[v][1]);
        for(int i=0;i<level;i++)
        {
            if(((diff>>i)&1)==1)
            {
                v=parent[v][i];
            }
        }
        
        if(v==u)
        {
            return v;
        }
       // System.out.println(u+" "+v);
        for(int i=level-1;i>=0;i--)
        {
            if(parent[v][i]!=parent[u][i])
            {
                v=parent[v][i];
                u=parent[u][i];
            }
        }
        return parent[v][0];
        
    }
    
	public static void main (String[] args) 
	{
	    
	    for(int i=0;i<max_node;i++)
	    {
	        tree.add(new ArrayList<Integer>());
	    }
		add(1,2);
		add(1,3);
		add(2,4);
		add(2,5);
		add(3,6);
		add(3,7);
		add(4,8);
		add(6,10);
		add(7,11);
		add(4,9);
		add(9,12);
		add(9,13);
		add(11,16);
		add(11,17);
		add(12,14);
		add(12,15);
		add(17,18);
		add(17,19);
		add(18,20);
		add(18,21);
		
		memset(-1);
		dfs(1,0);
		precomputations(11);
		System.out.println(lca(14,13));
		
	}
}