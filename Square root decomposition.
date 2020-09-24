import java.util.Scanner;
import java.lang.Math;
class Main 
{
	public static void main (String[] args)
	{
	    Scanner scan=new Scanner(System.in);
	    int n=scan.nextInt();
	    int arr[]=new int[n];
	    for(int i=0;i<n;i++)
	    {
	        arr[i]=scan.nextInt();
	    }
	    // now we need to make the blocks array..
	    int rn=(int)Math.pow(n,0.5);
	    int block[]=new int[rn+1];
	    int i=0;
	    int block_id=-1;
	    while(i<n)
	    {
	        if(i%rn==0)
	        {
	            block_id++;
	        }
	        block[block_id]+=arr[i];
	        i++;
	    }
	    
	    
	    // till here prepared the blocks-array...and now we must proceed....
	    
	    int l,r;
	    l=scan.nextInt();
	    r=scan.nextInt();
	    query(arr,block,l,r,rn);
	    
	    
	    int index,val;
	    index=scan.nextInt();
	    val=scan.nextInt();
	    update(arr,block,index,val,rn);
	    
	    
	    l=scan.nextInt();
	    r=scan.nextInt();
	    query(arr,block,l,r,rn);
	    
	}
	
	
	public static void update(int arr[],int blocks[],int i,int val,int rn)
	{
	    blocks[i/rn]+=val-arr[i];
	    arr[i]=val;
	}
	
	
	
	public static void query(int arr[],int blocks[],int l,int r,int rn)
	{
	    int ans=0;
	    // if left-part exists then we need to compute answer for that part....
	    while(l<r&& l%rn!=0)
	    {
	        ans+=arr[l];
	        l++;
	    }
	    
	    // now we need to come to the middle part...
	    while(l+rn<=r)
	    {
	        ans+=blocks[l/rn];
	        l=l+rn;
	    }
	    
	    // now we need to go for the right part..
	    while(l<=r)
	    {
	        ans+=arr[l];
	        l++;
	    }
	    System.out.println(ans);
	}
}
