import java.util.*;
public class Main
 {
    public static void main(String args[]) 
	{
		int t1;
		Scanner scan=new Scanner(System.in);
		t1=scan.nextInt();
		while(t1--!=0)
		{
			int k=scan.nextInt();
			long c[]=new long[k];
			long a[]=new long[k];
			for(int i=0;i<k;i++)
			{
				a[i]=scan.nextLong();
			}
			for(int i=0;i<k;i++)
			{
				c[i]=scan.nextLong();
			}
			long n,m,p;
			m=scan.nextLong();
			n=scan.nextLong();
			p=scan.nextLong();
		    // upto here our scannig process is completed......
			// don't forget to handle the cases
			// 1. m<=k and n<=k // this is the case which someone forgets mainly........
			//2.  m<=k
			//3.  m>k ..this case will be obviously handled.....
			long ans=0;
			if(n<=k)
			{
				for(int i=(int)m-1;i<n;i++)
				{
					ans+=a[i]%p;
					ans=ans%p;
				}
				System.out.println(ans);
				continue;
			}
			long s_k_or_m_1=0;
			if(m<=k)
			{
				for(int i=(int)m-1;i<k;i++)
				{
					s_k_or_m_1+=a[i]%p;
					s_k_or_m_1=s_k_or_m_1%p;
				}
			}
			long t[][]=new long[k+1][k+1];
			long f[]=new long[k+1];
			for(int i=0;i<=k;i++)
			{
				for(int j=0;j<=k;j++)
				{
					if(i==0&&j==0)
					{
						t[i][j]=1;
					}
					else if(i==k &&j==0)
					{
						continue;
					}
					else if(i==0 || i==k) 
					{
						t[i][j]=c[k-j];
					}
					else 
					{
						if(j==i+1)
						{
							t[i][j]=1;
						}
					}
				}
				if(i==0)
				{
					f[i]=s_k_or_m_1;
				}
				else 
				{
					f[i]=a[i-1];
				}
			}
			
			// in this way we just initialized the transnform matrix and the f matrix.......and now we
			// r good to go and multiply the 2 matrices and calculate the power...
			// calculate the n-kth power......
			long t2[][]=power(t,n-k,p);
			// now we will do some computations.........
			for(int i=0;i<=k;i++)
			{
				ans+=((t2[0][i]%p)*(f[i]%p))%p;
				ans=ans%p;
			}
			long ans2=0;
			if(m>k+1)
			{
			    long t3[][]=power(t,m-k-1,p);
		      	// now we will do some computations.........
		     	for(int i=0;i<=k;i++)
			   {
		    		ans2+=((t3[0][i]%p)*(f[i]%p))%p;
		    		ans2=ans2%p;
		    	}
			}
			if(ans-ans2<0)
			{
			    System.out.println(ans-ans2+p);
			    continue;
			}
			System.out.println(ans-ans2);

		}
    }

	public static long[][] power(long t[][],long pow,long p)
	{
		if(pow==1)
		{
			for(int i=0;i<t.length;i++)
			{
				for(int j=0;j<t.length;j++)
				{
					t[i][j]=t[i][j]%p;
				}
			}
			return t;
		}
		long temp[][]=power(t,pow/2,p);
		if(pow%2==0)
		{
			return multiply(temp,temp,p);
		}
		else 
		{
			return multiply(t,multiply(temp,temp,p),p);
		}
	}


	public static long[][] multiply(long a[][],long b[][],long p)
	{
		long ans[][]=new long[a.length][a.length];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
			    for(int k=0;k<b.length;k++)
			    {
				ans[i][j]=ans[i][j]+((a[i][k]%p)*(b[k][j])%p)%p;
				ans[i][j]=ans[i][j]%p;
			    }
			}
		}
		return ans;
	}
}