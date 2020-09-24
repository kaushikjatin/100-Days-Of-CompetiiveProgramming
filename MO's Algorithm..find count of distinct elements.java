import java.util.*; 
import java.lang.*; 
import java.io.*; 
class query
{
    int l,r;
    query(int a,int b)
    {
        l=a;
        r=b;
    }
}

class sortqueries implements Comparator<query>
{
    final int rn;
    sortqueries(int rn)
    {
        this.rn=rn;
    }
    public int compare(query a, query b) 
    { 
        if(a.l/rn==b.l/rn)
        {
            return a.r-b.r;
        }
        else 
        {
            return a.l-b.l;
        }
    } 
}
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
	    
	    
	    int q=scan.nextInt();
        query a[]=new query[q];
        for(int i=0;i<q;i++)
        {
            int l,r;
            l=scan.nextInt();
            r=scan.nextInt();
            a[i]=new query(l,r);
        }
        
        
        
        Arrays.sort(a,new sortqueries((int)Math.pow(n,0.5)));
        // now we need to sort the queries.....
        for(int i=0;i<q;i++)
        {
            System.out.println(a[i].l+" "+a[i].r);
        }
        
        // till now we have sorted our queries.....
        
        
        // let's do the compression of the range of values in the array...
        HashMap<Integer,Integer> map=new HashMap<>();
        int val=0;
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(arr[i]))
            {
                arr[i]=map.get(arr[i]);
            }
            else 
            {
                map.put(arr[i],val);
                arr[i]=val;
                val++;
            }
        }
        
        
        
        findanswer(arr,a);
        
        
	}
	
	public static void findanswer(int arr[], query a[])
	{
	    /*for(int i=0;i<arr.length;i++)
	    {
	        System.out.print(arr[i]+" ");
	    }
	    System.out.println();*/
	    int fre[]=new int[arr.length];
	    int count=0;
	    int l1,r1;
	    l1=a[0].l;
	    r1=a[0].l-1;
	    for(int i=0;i<a.length;i++)
	    {
	        int l2,r2;
	        l2=a[i].l;
	        r2=a[i].r;
	        if(l1<l2)
	        {
	           for(int j=l1;j<l2;j++)
	           {
	               if(fre[arr[j]]==1)
	               {
	                   count--;
	               }
	               fre[arr[j]]--;
	           }
	        }
	        else if(l1>l2)
	        {
	         for(int j=l2;j<l1;j++)
	           {
	               if(fre[arr[j]]==0)
	               {
	                   count++;
	               }
	               fre[arr[j]]++;
	           }   
	        }
	        if(r1<r2)
	        {
	            for(int j=r1+1;j<=r2;j++)
	           {
	               //System.out.print(arr[j]+" ");
	               if(fre[arr[j]]==0)
	               {
	                   count++;
	               }
	               fre[arr[j]]++;
	           }   
	        }
	        else if(r1>r2)
	        {
	            for(int j=r2+1;j<=r1;j++)
	           {
	               if(fre[arr[j]]==1)
	               {
	                   count--;
	               }
	               fre[arr[j]]--;
	           }
	        }
	        l1=l2;
	        r1=r2;
	        System.out.println(l2+" "+r2+"->"+count);
	    }
	}
}