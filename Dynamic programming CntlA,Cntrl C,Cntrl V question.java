import java.util.*;

public class GFG 
{
	public static void main (String[] args)
	{
	    int n;
	    Scanner scan=new Scanner(System.in);
	    n=scan.nextInt();
	    int answer[][]=new int[n+1][2];
	    findanswer(n,answer);
	    for(int i=0;i<=n;i++)
	    {
	        System.out.println(answer[i][0]+" "+answer[i][1]);
	    }
	}
	
	public static void findanswer(int n,int answer[][])
	{
	    if(answer[n][0]!=0)
	    {
	        return;
	    }
	    if(n==0)
	    {
	        answer[0][0]=0;
	        answer[0][1]=0;
	    }
	    else if(n==1)
	    {
	        answer[1][0]=1;
	        answer[1][1]=0;
	    }
	    else if(n==2)
	    {
	        answer[2][0]=2;
	        answer[2][1]=0;
	    }
	    else 
	    {
	        int max=0;
	        int cntrlv=0;
	        // case1 when directly printing A...........
	        findanswer(n-1,answer);
	        if(max<answer[n-1][0]+1)
	        {
	            max=answer[n-1][0]+1;
	            cntrlv=answer[n-1][1];
	        }
	        // case 2 when doing cntrl v.......
	        if(max<answer[n-1][0]+answer[n-1][1])
	        {
	            max=answer[n-1][0]+answer[n-1][1];
	            cntrlv=answer[n-1][1];
	        }
	        // case 3 doing both cntrl v and cntrl a ,,,here it is always possible..
	        findanswer(n-2,answer);
	        if(max<2*answer[n-3][0])
	        {
	            max=2*answer[n-3][0];
	            cntrlv=answer[n-3][0];
	        }
	        if(max==2*answer[n-3][0])
	        {
	        	if(cntrlv<answer[n-3][0])
	        	{
	        		max=2*answer[n-3][0];
	                cntrlv=answer[n-3][0];
	        	}
	        }
	        answer[n][0]=max;
	        answer[n][1]=cntrlv;
	        return ;
	    }
	    
	}
}