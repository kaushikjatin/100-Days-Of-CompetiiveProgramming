import java.util.*;
// Graph would be stored in a HashMap..i.e and unordered-map type datastructure....
// We would need a hashMAp to store distance of every node from souce.
// We would also need a dataStructures which provides us these features:
	/*
    	1) Elements stored in Sorted order
        2) Able to access smallest element in O(1) and removes any node in o(logn) and insert in O(logn)
        WE WILL USE SortedSet FOR THAT.
    */
// in case if you need to print the path of shortest distance too...you would need a parent array too in this case..

public class Solution 
{
    static class Pair
    {
        int node,dist;
        public Pair(int a,int b)
        {
            node=a;	dist=b;
        }
    }
    static HashMap<Integer,ArrayList<Pair>> graph;
    static int distance[];
    static SortedSet<Pair> sorted_set;
    static int v,e;
    
    
	public static void main(String[] args) 
    {
		Scanner scan = new Scanner(System.in);
        memset_and_scan_values(scan);
        run_dijktras(0);
        for(int i=0;i<v;i++)
            System.out.println(i+" "+distance[i]);
	}
    
    
    public static void run_dijktras(int src)
    {
        distance[src]=0;
        sorted_set.add(new Pair(0,src));
        while(sorted_set.size()!=0)
        {
            Pair p=sorted_set.first();
            sorted_set.remove(p);
            int node=p.node,dist=p.dist;
            for(int i=0;i<graph.get(node).size();i++)
            {
                Pair child=graph.get(node).get(i);
                if(dist+child.dist<distance[child.node])
                {
                    sorted_set.remove(new Pair(child.node,distance[child.node]));
                    sorted_set.add(new Pair(child.node,dist+child.dist));
                    distance[child.node]=dist+child.dist;
				}	
            }
        }
    }
    
    
    public static void memset_and_scan_values(Scanner scan)
    {
        v=scan.nextInt();	e=scan.nextInt();
        graph=new HashMap<>();
        distance=new int[v];
        sorted_set=new TreeSet<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b)
            {
                if(a.node == b.node && a.dist==b.dist)
                    return 0;
            	return a.dist - b.dist;
            }
        });
        for(int i=0;i<v;i++)
        {
            graph.put(i,new ArrayList<>());
            distance[i]=Integer.MAX_VALUE;
        }  
        for(int i=0;i<e;i++)
        {
            int a,b,c;
            a=scan.nextInt();	b=scan.nextInt();	c=scan.nextInt();
            graph.get(a).add(new Pair(b,c));
            graph.get(b).add(new Pair(a,c));
        }
	}
}