import java.util.*;
class Main 
{
    static int n,q;
    static int queries[][],parent[];
    static int color[];
	public static void main (String[] args)
	{
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();     q=scan.nextInt();
		n++;
		parent=new int[n+1];
		color=new int[n+1];
		queries=new int[q][3];
		memset_and_scan(scan);
		solve();
		for(int i=1;i<n;i++)
		    System.out.println(color[i]);
	}
	
	public static void solve()
	{
	    for(int i=q-1;i>=0;i--)
	    {
	        int l=queries[i][0];
	        int r=queries[i][1];
	        int c=queries[i][2];
	        
	        for(int j=find_parent(l);j<=r;j=find_parent(j))
	        {
	            color[j]=c;
	            parent[j]=find_parent(j+1);
	        }
	    }
	}
	
	public static int find_parent(int node)
	{
	    if(parent[node]==node)
	        return node;
	    return parent[node]=find_parent(parent[node]);
	}
	
	public static void memset_and_scan(Scanner scan)
	{
	     for(int i=0;i<q;i++)
	     {
	         queries[i][0]=scan.nextInt();
	         queries[i][1]=scan.nextInt();
	         queries[i][2]=scan.nextInt();
	     }
	     
	     for(int i=0;i<=n;i++)
	        parent[i]=i;
	}
}