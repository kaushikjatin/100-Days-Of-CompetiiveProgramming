import java.util.*;

class Solution 
{
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String args[])
	{

		// Scanning input and preparing the graph
		Scanner scan=new Scanner(System.in);
		int v,e;
		v=scan.nextInt();	e=scan.nextInt();
		graph=new ArrayList<>();
		for(int i=0;i<v;i++)
			graph.add(new ArrayList<Integer>());
	    for(int i=0;i<e;i++)
	    {
	    	int a,b;
	    	a=scan.nextInt();	b=scan.nextInt();
	    	graph.get(a).add(b);
	    	graph.get(b).add(a);
	    }

	    System.out.println(find_shortest_cycle(v));

	}

	public static int find_shortest_cycle(int v)
	{
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<v;i++)
		{
			int value[]=new int[v];
			Arrays.fill(value,-1);
			int parent[]=new int[v];
			Arrays.fill(parent,-1);
			parent[i]=i;
			value[i]=0;
			Queue<Integer> queue=new LinkedList<Integer>();
			queue.add(i);

			while(queue.size()!=0)
			{
				int x=queue.poll();
				for(int j=0;j<graph.get(x).size();j++)
				{
					int child=graph.get(x).get(j);
					if(value[child]==-1) // it is unvisited
					{
						parent[child]=x;
						value[child]=value[x]+1;
						queue.add(child);
					}
					else if(parent[x]!=child) //not visited
						ans=Math.min(ans,value[child]+value[x]+1);
				}
			}

		}

		return ans;
	}
}