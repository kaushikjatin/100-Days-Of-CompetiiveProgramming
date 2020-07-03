import java.util.*;
class Main 
{
    static int n;
    static int a[],b[];
	public static void main (String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		a=new int[n];
		b=new int[n];
		for(int i=0;i<n;i++)
		  a[i]=scan.nextInt();
		for(int i=0;i<n;i++)
		  b[i]=scan.nextInt();
		  
	    if(!Case1.solve())
	       Case2.solve();
	}
	
	
	
	static class Case2
	{
	    public static void solve()
	    {
	        //System.out.println("came here");
	        int index_array[]=new int[n+1];
	        int se=0,ee=n,mid,ans=0;
	        mid=(se+ee)/2;
	        find_all_indexes(index_array);
	        while(se<=ee)
	        {
	            if(possible(mid,index_array))
	            {
	                ans=mid;
	                ee=mid-1;
	            }
	            else 
	            {
	                se=mid+1;
	            }
	            mid=(se+ee)/2;
	        }
	        System.out.println(ans+n);
	    }
	    
	    public static boolean possible(int shifting,int index_array[])
	    {
	        int requirenment=0;
	        for(int i=1;i<=n;i++)
	        {
	            if(index_array[i]-shifting>requirenment)
	               return false;
	            requirenment++;
	        }
	        return true;
	    }
	    
	    public static void find_all_indexes(int index_array[])
	    {
	        for(int i=0;i<n;i++)
	          index_array[a[i]]=0;
	        int index=1;
	        for(int i=0;i<n;i++)
	        {
	           index_array[b[i]]=index;
	           index++;
	        }
	    }
	}
	
	
	
	
	static class Case1 
	{
    	public static boolean solve()
    	{
    	    if(possible_in_less_moves())
    	    {
    	        //System.out.println("came here");
    	        System.out.println(n-b[n-1]);
    	        return true;
    	    }
    	    return false;
    	}
    	
    	public static boolean possible_in_less_moves()
    	{
    	    int index_array[]=new int[n+1];
    	    int index_of_1=0;
    	    index_of_1=find_index_of_from_last(1);
    	    if(index_of_1== -1*(n+1))
    	       return false;
    	    
    	    index_array[1]=index_of_1;
    	    find_index_of_all_elements(index_array);
    	    
    	    // now we will check that it is feasible or not to do in <n steps 
    	    int requirenment=index_of_1;
    	    for(int i=1;i<=n;i++)
    	    {
    	        if(index_array[i]>requirenment)
    	          return false;
    	        requirenment++;
    	    }
    	    return true;
    	}
    	
    	public static void find_index_of_all_elements(int index_array[])
    	{
    	    for(int i=0;i<n;i++)
    	     index_array[a[i]]=0;
    	    int i=0;
    	    int index=1;
    	    while(b[i]!=1)
    	    {
    	        index_array[b[i]]=index;
    	        index++;
    	        i++;
    	    }
    	    
    	    index=-1;
    	    i=n-1;
    	    while(b[i]!=1)
    	    {
    	       index_array[b[i]]=index;
    	       index--;
    	       i--;
    	    }
    	}
    	
    	public static int find_index_of_from_last(int no)
    	{
    	    int index=-1;
    	    for(int i=n-1;i>=0;i--)
    	    {
    	        if(b[i]==no)
    	          return index;
    	        index--;
    	    }
    	    return index;
    	}
    	
	}
}