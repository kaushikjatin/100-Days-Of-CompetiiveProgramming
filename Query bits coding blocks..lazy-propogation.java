import java.util.*;
import java.lang.Math;
public class Main 
{
    public static void main(String args[]) 
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int lazy_tree[]=new int[4*n-1];
		for(int i=1;i<4*n-1;i++)
		{
		    lazy_tree[i]=-1;
		}
		int q=scan.nextInt();
		//print_tree(lazy_tree);
		while(q--!=0)
		{
		    int a,l,r;
		    a=scan.nextInt();
		    l=scan.nextInt();
		    r=scan.nextInt();
		    if(a==0 || a==1)
		    {
		        update_tree(lazy_tree,0,n-1,l,r,0,a);
		        //print_tree(lazy_tree);
		    }
		    else if(a==2)
		    {
		        System.out.println(query_tree(lazy_tree,0,n-1,l,r,0));
		    }
		}
    }
    
    public static void update_tree(int lazy_tree[],int se,int ee,int l,int r,int root,int value)
    {
        //if it is out of bounds...
        if(r<se || l > ee)
        {
            return;
        }
        
        
        // if it is a complete overlap...
        if(l<=se && r>=ee)
        {
             lazy_tree[root]=value;
             return;
        }
        
        // if it has lazy-value...
        if(lazy_tree[root]!=-1)
        {
            lazy_tree[2*root+1]=lazy_tree[root];
            lazy_tree[2*root +2]=lazy_tree[root];
            lazy_tree[root]=-1;
        }
        
        
        // it is a partial overlap.....
        update_tree(lazy_tree,se,(se+ee)/2,l,r,2*root+1,value);
        update_tree(lazy_tree,(se+ee)/2+1,ee,l,r,2*root+2,value);
        return;
        
    }
    
    public static void print_tree(int lazy_tree[])
    {
        for(int i=0;i<lazy_tree.length;i++)
        {
            System.out.print(lazy_tree[i]+" ");
        }
        System.out.println();
    }
    
    public static long query_tree(int lazy_tree[],int se,int ee,int l,int r,int root)
    {
        // if it is having out of bounds....
        if(r<se || l > ee)
        {
           // System.out.println(se+" "+ee+" 0");
            return 0l;
        }
        
        // the node on which we will come  will surely contain a lazy value......
         // it is a complete overlap....
        if(l<=se && r>=ee && lazy_tree[root]!=-1)
        {
            long temp=(lazy_tree[root]*(pow(2,(ee-se+1))-1)*(pow(2,(r-ee))))%1000000007l;
           // System.out.println(se+" "+ee+" "+temp);
            return temp;
        }
        
        // if lazy value then resolve it...
        if(lazy_tree[root]!=-1)
        {
            lazy_tree[2*root+1]=lazy_tree[root];
            lazy_tree[2*root +2]=lazy_tree[root];
            lazy_tree[root]=-1;
        }
        // if we come here then it means it is partial overlap only...
        long temp1=query_tree(lazy_tree,se,(se+ee)/2,l,r,2*root+1);
        long temp2=query_tree(lazy_tree,(se+ee)/2 +1,ee,l,r,2*root+2);
        //System.out.println(se+" "+ee+" "+(temp1+temp2)%1000000007l);
        return (temp1+temp2)%1000000007l;
        
        
    }
    
    public static long pow(int a,int b)
    {
        if(b==0)
        {
            return 1l;
        }
        else 
        {
            long temp=pow(a,b/2);
            if(b%2==0)
            {
                return (temp*temp)%1000000007l;
            }
            else 
            {
                return (temp*temp*a)%1000000007l;
            }
        }
    }
}