import java.util.*;
import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
class Main  
{
    static int n,e,marks[];
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> graph;
	public static void main (String[] args) throws IOException
	{
		String name="07.txt";
	    int ans=0;
		Scanner scan=new Scanner(new File("/Users/jatinkaushik/Downloads/MOST_SIMPLE_STATEMET_TESTCASES/input/input"+name));
		scan_the_input(scan);
		for(int i=0;i<n;i++)
		{
		    if(!visited[i])
		    {
		        int arr[]=dfs(i);
		        int temp=arr[0]+(arr[1]/2);
		        ans=(temp>ans)?(temp):(ans);
		    }
		}
		File file=new File("/Users/jatinkaushik/Downloads/MOST_SIMPLE_STATEMET_TESTCASES/output/output"+name);
        FileWriter fw = new FileWriter(file);
        PrintWriter pw=new PrintWriter(fw);
		pw.println(ans);
		pw.close();
	}
	
	public static int[] dfs(int node)
	{
	    int score=marks[node];
	    int temp[]; // temp[0] will be score and temp[1] will be connections
	    int connections=graph.get(node).size();
	    visited[node]=true;
	    for(int i=0;i<graph.get(node).size();i++)
	    {
	        int child=graph.get(node).get(i);
	        if(!visited[child])
	        {
	            temp=dfs(child);
	            connections+=temp[1];
	            score=(score>temp[0])?(score):(temp[0]);
	        }
	    }
	    temp=new int[2];    temp[0]=score;  temp[1]=connections;
	    return temp;
	}
	
	public static void scan_the_input(Scanner scan)
	{
	    n=scan.nextInt();
	    marks=new int[n];
	    visited=new boolean[n];
	    graph=new ArrayList<>();
	    for(int i=0;i<n;i++)
	    {
	        visited[i]=false;
	        marks[i]=scan.nextInt();
	        graph.add(new ArrayList<Integer>());
	    }
	    e=scan.nextInt();
	    for(int i=0;i<e;i++)
	    {
	        int a=scan.nextInt();
	        int b=scan.nextInt();
	        a--;    b--;
	        graph.get(a).add(b);
	        graph.get(b).add(a);
	    }
	    
	}
}