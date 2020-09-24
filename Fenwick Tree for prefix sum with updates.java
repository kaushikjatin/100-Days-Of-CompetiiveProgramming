import java.util.Scanner;
class Main
{
    static int n;
    static long arr[];
    static long BIT[];
	public static void main (String[] args) 
	{
	    Scanner scan=new Scanner(System.in);
	     n=scan.nextInt();
	    arr=new long[n+1];
	    BIT=new long[n+1];
	    for(int i=1;i<=n;i++)
	    {
	       arr[i]=scan.nextLong();
	       update(i,arr[i]);
	    }
	    // 1 stands for the update and 2 stands for the query.
	    int q=scan.nextInt();
	    while(q--!=0)
	    {
	        if(scan.nextInt()==1)
	          update(scan.nextInt(),scan.nextLong());
	        else 
	          System.out.println(query(scan.nextInt(),scan.nextInt()));
	    }
	}
	
	public static void update(int i,long inc)
	{
	  while(i<=n)
	  {
	      BIT[i]+=inc;
	      i+=(i&(-i));
	  }
	  return;
	}
	
	public static long query(int i,int j)
	{
	    if(i!=1)
	       return query(1,j)-query(1,i-1);
	    long ans=0;
	    while(j>0)
	    {
	        ans+=BIT[j];
	        j-=(j&(-j));
	    }
	    return ans;
	}
	
	
}