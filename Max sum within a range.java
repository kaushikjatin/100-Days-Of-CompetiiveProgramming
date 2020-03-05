import java.util.Scanner;
import java.lang.Math;
class choukdi
{
    long max;
    long start_max;
    long end_max;
    long total;
    
    choukdi(long a,long b,long c,long d)
    {
        max=a;
        start_max=b;
        end_max=c;
        total=d;
    }
}

class Main 
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        long arr[]=new long[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=scan.nextLong();
        }
        
        choukdi tree[]=new choukdi[4*n-1];
        build_tree(arr,0,n-1,0,tree);
        int q=scan.nextInt();
        while(q--!=0)
        {
            int l=scan.nextInt();int r=scan.nextInt();
            System.out.println(query_tree(tree,0,n-1,0,l-1,r-1).max);
        }
        
    }
    
    public static choukdi query_tree(choukdi tree[],int se,int ee,int root,int l,int r)
    {
        // if it a conplete overlap....
        if(l<=se && r>=ee)
        {
            return tree[root];
        }
        
        // if it is out__of_bounds....
        if(r<se || l>ee)
        {
            return new choukdi(-99999999999999l,-99999999999999l,-99999999999999l,0l);
        }
        
        // if it is a partial overlap...
        choukdi left=query_tree(tree,se,(se+ee)/2,2*root+1,l,r);
        choukdi right=query_tree(tree,(se+ee)/2+1,ee,2*root+2,l,r);
        
        long max,start_max,end_max,total;
        
        max=Math.max(Math.max(left.max,right.max),left.end_max+right.start_max);
        start_max=Math.max(left.start_max,left.total+right.start_max);
        end_max=Math.max(right.end_max,right.total+left.end_max);
        total=left.total+right.total;
        return new choukdi(max,start_max,end_max,total);
        
    }
    
    
    public static void build_tree(long arr[],int se,int ee,int root,choukdi tree[])
    {
        // if it is a base case....
        if(se==ee)
        {
            tree[root]=new choukdi(arr[se],arr[se],arr[se],arr[se]);
            return;
        }
        
        
        // in case of partial overlap...
        
        build_tree(arr,se,(se+ee)/2,2*root+1,tree);
        build_tree(arr,(se+ee)/2+1,ee,2*root+2,tree);
        
        choukdi left=tree[2*root+1];
        choukdi right=tree[2*root+2];
        
        long max,start_max,end_max,total;
        
        max=Math.max(Math.max(left.max,right.max),left.end_max+right.start_max);
        start_max=Math.max(left.start_max,left.total+right.start_max);
        end_max=Math.max(right.end_max,right.total+left.end_max);
        total=left.total+right.total;
        tree[root]=new choukdi(max,start_max,end_max,total);
        return;
    }
}