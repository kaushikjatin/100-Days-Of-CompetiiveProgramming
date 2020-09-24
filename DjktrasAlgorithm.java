import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
class Main
{
    static class pair 
    {
        int v;
        int w;
        pair(int a,int b)
        {
            v=a;  w=b;
        }
    }

    static HashMap<Integer,ArrayList<pair>> map=new HashMap<>();
    static int no_of_e, no_of_v;
    static int ans[];
    static boolean visited[];

    public static void memset()
    {
        for(int i=0;i<no_of_v;i++)
          map.put(i+1,new ArrayList<pair>());

        for(int i=0;i<no_of_v;i++)
           visited[i]=false;
    }

	public static void main (String[] args)
	{
        Scanner scan=new Scanner(System.in);
        no_of_v=scan.nextInt();     no_of_e=scan.nextInt();
        ans=new int[no_of_v+1];
        visited=new boolean[no_of_v+1];
        memset();
        while(e--!=0)
        {
            int e1,e2,weight;
            e1=scan.nextInt();   e2=scan.nextInt();   weight=scan.nextInt();  
            map.get(e1).add(new pair(e2,weight));
            djktras();
        }
	}
}