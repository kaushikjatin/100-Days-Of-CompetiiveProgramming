import java.util.*;
class Main
{
    static int arr[];
    static int n;
	public static void main (String[] args) 
	{
	    Scanner scan=new Scanner(System.in);
	    n=scan.nextInt();
	    arr=new int[n];
	    for(int i=0;i<n;i++)
	      arr[i]=scan.nextInt();
	    System.out.println(first_occurence(5));
	    System.out.println(last_occurence(5));
	}
	
	public static int first_occurence(int x)
	{
	    int se=0,ee=n-1,mid=(se+ee)/2,ans=-1;
	    while(se<=ee)
	    {
	        if(arr[mid]==x)
	          {ans=mid;ee=mid-1;}
	        if(arr[mid]<x)
	          se=mid+1;
	        if(arr[mid]>x)
	          ee=mid-1;
	        mid=(se+ee)/2;
	        
	    }
	    return ans;
	}
	public static int last_occurence(int x)
	{
	    int se=0,ee=n-1,mid=(se+ee)/2,ans=-1;
	    while(se<=ee)
	    {
	        if(arr[mid]==x)
	          {ans=mid;se=mid+1;}
	        if(arr[mid]<x)
	          se=mid+1;
	        if(arr[mid]>x)
	          ee=mid-1;
	        mid=(se+ee)/2;
	        
	    }
	    return ans;
	}
}