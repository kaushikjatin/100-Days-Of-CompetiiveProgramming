import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Iterator;
class Main 
{
    static int n;
    static int arr[];
    static int BIT[];
    static long ans=0l;
	public static void main (String[] args)
	{
	    Scanner scan=new Scanner(System.in);
	    int t=scan.nextInt();
	    while(t--!=0)
	    {
	         scan.nextLine();
	         ans=0l;
	         n=scan.nextInt();
	         arr=new int[n];
	         BIT=new int[n+1];
	         for(int i=0;i<n;i++)
	            arr[i]=scan.nextInt();
	         compress();
	         for(int i=n-1;i>=0;i--)
	         {
	            update(arr[i],1);
	            query(arr[i]-1);
	         }
	         System.out.println(ans);
	    }
	}
	
	public static void compress()
	{
	    HashMap<Integer,Integer> map=new HashMap<>();
	    TreeSet<Integer> ts=new TreeSet<>();
	    for(int i=0;i<n;i++)
	       ts.add(arr[i]);
	    Iterator iterator = ts.iterator();
	    int i=1;
        for (Integer value : ts) 
        {
             map.put(value,i);
             i++;
        }
        for(i=0;i<n;i++)
          arr[i]=map.get(arr[i]);
	}
	
	public static void update(int i,int inc)
	{
	    while(i<n)
	    {
	        BIT[i]+=inc;
	        i+=(i&(-i));
	    }
	}
	
	public static void query(int i)
	{
	    while(i>0)
	    {
	        ans+=BIT[i];
	        i-=(i&(-i));
	    }
	}
} 