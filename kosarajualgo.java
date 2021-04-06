// this algo is used for finding all the stringly connected components in a Directed graph/
import java.util.*;
import java.io.*;
import java.lang.*;

class kosaraju
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            
            int vertices = Integer.parseInt(sc.next());
            int edges = Integer.parseInt(sc.next());
            
            for(int i =0; i < vertices; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edges; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 list.get(u).add(v);
            }
            
            Solution T = new Solution();
            System.out.println(T.kosaraju(list, vertices));
		}
    }
}

class Solution
{
    static ArrayList<Integer> order,revorder;
    static ArrayList<ArrayList<Integer>> revadj;
    static boolean visited[];
    static int ans;
    public int kosaraju(ArrayList<ArrayList<Integer>> adj, int N)
    {
        ans=0;
        order=new ArrayList<>();
        revorder=new ArrayList<>(); // this will be of no use...just used so that we can reuse the dfs() function...
        visited=new boolean[N];
        memset(false);
        for(int i=0;i<N;i++)
          if(!visited[i])
             dfs(adj,order,i);
        memset(true);
        makereversegraph(adj);
        memset(false);
        ans=0;
        for(int i=order.size()-1;i>=0;i--)
        {
            int node=order.get(i);
            if(!visited[node])
            {
                dfs(revadj,revorder,node);
                ans++;
            }
        }
        return ans;
        
    }
    
    public static void makereversegraph(ArrayList<ArrayList<Integer>> adj)
    {
        revadj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<adj.size();i++)
          revadj.add(new ArrayList<Integer>());
        
        for(int i=0;i<adj.size();i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                int temp=adj.get(i).get(j);
                revadj.get(temp).add(i);
            }
        }
    }
    
    
    public static void memset(boolean value)
    {
        for(int i=0;i<visited.length;i++)
           visited[i]=value;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> graph,ArrayList<Integer> order,int node1)
    {
        visited[node1]=true;
        for(int i=0;i<graph.get(node1).size();i++)
        {
            int node2=graph.get(node1).get(i);
            if(!visited[node2])
                dfs(graph,order,node2);
        }
        order.add(node1);
    }
}
