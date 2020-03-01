import java.util.*;
class Main 
{
	public static void main (String[] jatin) 
	{
	    Scanner scan=new Scanner(System.in);
	    int n=scan.nextInt();
	    int arr[]=new int[n];
	    int p=0;
	    while(p<n)
	    {
	        arr[p]=scan.nextInt();
	        p++;
	    }
	    int tree[][]=new int[4*n+1][];
	    build_tree(tree,arr,0,n-1,0);
	   // print_array(tree[0]);
	    int q=scan.nextInt();
	    while(q--!=0)
	    {
	        int l,r,k;
	        l=scan.nextInt();
	        r=scan.nextInt();
	        k=scan.nextInt();
	        int no=query_tree(tree,0,n-1,0,l-1,r-1,k-1);
	        System.out.println(no);
	        
	    }
	}
	
	public static int binary_search(int arr[],int n,int k)
	{
	   int l = 0; 
    int r = n - 1; 
  
    int leftGreater = n; 
  
    while (l <= r) { 
        int m = l + (r - l) / 2; 
  
        if (arr[m] > k) { 
            leftGreater = m; 
            r = m - 1; 
        } 
  
        else
            l = m + 1; 
    } 
  
    return (n - leftGreater);  
	   
	}
	
	public static int query_tree(int tree[][],int se,int ee,int root,int l,int r,int k)
	{
	    if(r<se || l>ee)
	    {
	       // System.out.println(se+" "+ee+" "+0);
	        return 0;
	    }
	    
	    // if it is leaf node and then complete overlap....
	    if(se==ee)
	    {
	        int ans=binary_search(tree[root],tree[root].length,k);
	        //System.out.println(se+" "+ee+" "+ans);
	        return ans;
	    }
	    
	    
	    // complete overlap
	    if(l<=se && r>=ee)
	    {
	        int ans=binary_search(tree[root],tree[root].length,k);
	       // System.out.println(se+" "+ee+" "+ans);
	        return ans;
	    }
	    
	    // if it is a partial-overlap...
	    int x=query_tree(tree,se,(se+ee)/2,2*root+1,l,r,k);
	    int y=query_tree(tree,(se+ee)/2 +1,ee,2*root+2,l,r,k);
	    //System.out.println(se+" "+ee+" "+ x+y);
	    return x+y;
	}
	
	
	
	public static void print_array(int final_ans[])
	{
	    for(int i=0;i<final_ans.length;i++)
	    {
	        System.out.print(final_ans[i]+" ");
	    }
	   System.out.println();
	}
	
	
	public static void build_tree(int tree[][],int arr[],int se,int ee,int root)
	{
	    // if it is a leaf node.....
	    if(se==ee)
	    {
	        tree[root]=new int[1];
	        tree[root][0]=arr[se];
	        return;
	    }
	    
	    
	    // else...
	    build_tree(tree,arr,se,(se+ee)/2,2*root+1);
	    build_tree(tree,arr,(se+ee)/2 +1,ee,2*root+2);
	    int arr1[]=tree[2*root+1];
	    int arr2[]=tree[2*root +2];
	    int final_ans[]=megre_arrays(arr1,arr2);
	    tree[root]=final_ans;
	    return;
	}
	
	public static int[] megre_arrays(int arr1[],int arr2[])
	{
	    int final_ans[]=new int[arr1.length + arr2.length];
	    int i=0,j=0,k=0;
	    while(i<arr1.length && j<arr2.length)
	    {
	        if(arr1[i]<arr2[j])
	        {
	            final_ans[k]=arr1[i];
	            i++;
	        }
	        else 
	        {
	            final_ans[k]=arr2[j];
	            j++;
	        }
	        k++;
	    }
	    
	    if(i==arr1.length)
	    {
	        while(j<arr2.length)
	        {
	            final_ans[k]=arr2[j];
	            j++;
	            k++;
	        }
	    }
	    else 
	    {
	        while(i<arr1.length)
	        {
	            final_ans[k]=arr1[i];
	            k++;
	            i++;
	        }
	        
	    }
	    return final_ans;
	}
}