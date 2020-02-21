import java.util.Scanner;

class Main
{
	public static void main (String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int value[]=new int[n];
		int tree[]=new int[4*n+1];
		int lazy[]=new int[4*n+1];
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
		update_lazy(tree,lazy,0,n-1,0,2,4,10);
		int min=query_lazy(tree,lazy,0,n-1,0,4,5);
		System.out.println(min);
		for(int i=0;i<4*n+1;i++)
		{
		    System.out.print(tree[i]+" ");
		}
		System.out.println();
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
	public static void update_lazy(int tree[],int lazy[],int se,int ee,int root,int l,int r,int increment)
	{
	    
	    // it means that we r out of bound............
	    if(r<se || ee<l)
	    {
	        return;
	    }
	    
	    
	    // it means that we found a lazy value and hence need to be resolved.....
	    if(lazy[root]!=0)
	    {
	        tree[root]+=lazy[root];
	        if(se!=ee)//it means it is not a leaf node ans we need to pass the lazy value to the childrens....
	        {
	            lazy[2*root+1]=lazy[root];
	            lazy[2*root+2]=lazy[root];
	        }
	        lazy[root]=0;
	    }
	    
	    
	    // now we will check for the complete overlap......
	    if(l<=se && r>=ee)
	    {
	        tree[root]+=increment;
	        if(se!=se)
	        {
	            lazy[2*root+1]+=increment;
	            lazy[2*root+2]+=increment;
	        }
	        return;
	    }
	    
	    
	    
	    // now only the case of partial-overlap is left
	    update_lazy(tree,lazy,se,(se+ee)/2,2*root+1,l,r,increment);
	    update_lazy(tree,lazy,(se+ee)/2 +1,ee,2*root+2,l,r,increment);
	    tree[root]=find_min(tree[2*root+1],tree[2*root+2]);
	    return;
	    
	    
	    
	}
	
	
	public static int query_lazy(int tree[],int lazy[],int se,int ee,int root,int l,int r)
	{
	     // it means that we r out of bound............
	    if(r<se || ee<l)
	    {
	        return 999999999;
	    }
	    
	    
	    // now if we found a lazy value
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
	    
	    
	    // now suppose complete overlap...
	    if(l<=se && r>=ee)
	    {
	        return tree[root];
	    }
	    
	    // now the case of partial-overlap...
	    int min_left=query_lazy(tree,lazy,se,(se+ee)/2,2*root+1,l,r);
	    int min_right=query_lazy(tree,lazy,(se+ee)/2 +1,ee,2*root+2,l,r);
	    return find_min(min_left,min_right);
	    
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
