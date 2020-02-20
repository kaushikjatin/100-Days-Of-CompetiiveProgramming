import java.util.Scanner;

class Main
{
	public static void main (String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int value[]=new int[n];
		int tree[]=new int[4*n+1];
		int lazy[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    value[i]=scan.nextInt();
		}
		
		build_tree(tree,value,0,n-1,0);
		for(int i=0;i<4*n+1;i++)
		{
		    System.out.print(tree[i]+" ");
		}
		System.out.println();
		int lazy[]=new int[4*n+1];
		update_lazy(tree,0,n-1,0,2,4,10,lazy);
		
	}
	
	// this fucntion is working fine........
	public static int build_tree(int tree[],int value[],int se,int ee,int root)
	{
	    // we r having the base---case...ie. the leaf-node
	    if(se==ee)
	    {
	        // just put the value...
	        tree[root]=value[se];
	        return value[se];
	    }
	    
	    int left=build_tree(tree,value,se,(se+ee)/2,2*root+1);
	    int right=build_tree(tree,value,(se+ee)/2 +1,ee,2*root+2);
	    int min=find_min(left,right);
	    tree[root]=min;
	    return min;
	    
	}
	
	// this is an optimization of segment-trees ....
	public static void update_lazy(int tree[],int se,int ee,int root,int l,int r,int increment,int lazy[])
	{
	    // if it an out-of-bound.....
	    if(r<se || ee<l)
	    {
	        // here we will directly return because we need no change in this...it is just
	        // out of the bound....
	        return;
	    }
	    
	    
	    // firtly resolve the lazy value......
	    if(lazy[root]!=0)
	    {
	        tree[root]+=lazy[root];
	        if(se!=ee)
	        {
	            lazy[2*root+1]=lazy[root];
	            lazy[2*root+2]=lazy[root];
	        }
	        lazy[root]=0;
	    }
	    
	    // if it is a complete-overlap
	    if(se>=l && ee<=r)
	    {
	        // now we just need to update value an then pass the lazy value to the roots..
	        tree[root]+=increment;
	        if(se!=ee)
	        {
	        lazy[2*root+1]=increment;
	        lazy[2*root+2]=increment;
	        }
	        return;
	    }
	    
	    
	    // now if it is a partial-overlap...
	    
	}
	public static int find_min(int x,int y)
	{
	    if(x<y)
	    {
	        return x;
	    }
	    else 
	    {
	        return y;
	    }
	}
}