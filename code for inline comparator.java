import java.util.*;
public class Main
{
	static class pair 
	{
		int se,ee;
		pair(int a,int b)
		{
			se=a;ee=b;
		}
	}

	static pair activities[];
	static int n;
    public static void main(String args[]) 
	{
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		while(t--!=0)
		{
			n=scan.nextInt();
			activities=new pair[n];
			for(int i=0;i<n;i++)
			{
				activities[i]=new pair(scan.nextInt(),scan.nextInt());
			}
			new Solver().solve();
		}
    }
    
    static class Solver
    {
        public static void solve()
        {
            int ans=0;
            Arrays.sort(activities,new Comparator<pair>()
            {
                public int compare(pair a,pair b)
                {
                   return a.ee-b.ee;
                }
            });
            
            int prev_end=0;
            for(int i=0;i<n;i++)
            {
                if(activities[i].se>=prev_end)
                {
                    ans++;
                    prev_end=activities[i].ee;
                }
            }
            System.out.println(ans);
        }
    }
}