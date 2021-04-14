import java.util.*;
import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
class Solution 
{
    public static void main(String s[]) throws IOException
    {
        Random rand = new Random();
        File file=new File("/Users/jatinkaushik/Downloads/MOST_SIMPLE_STATEMET_TESTCASES/input/input05.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw=new PrintWriter(fw);
        int n=ThreadLocalRandom.current().nextInt(1000,9000); // value of n
        pw.println(n);
        for(int i=0;i<n;i++)
            pw.print(ThreadLocalRandom.current().nextInt(2, 3000)+" ");   // value of score
        pw.println();


        
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        graph.add(new ArrayList<>());
        int e=0;
        for(int i=1;i<n-2;i++)
        {
            HashSet<Integer> set=new HashSet<>();
            graph.add(new ArrayList<>());
            int min=0,max=2;
            int connections=ThreadLocalRandom.current().nextInt(min, max + 1);
            min=i+1;
            max=n;
            for(int j=0;j<connections;j++)
            {
                int node=ThreadLocalRandom.current().nextInt(min, max + 1);
                if(!set.contains(node))
                {
                    set.add(node);
                    graph.get(i).add(node);
                    e++;
                }
            }
        }


        pw.println(e);
        for(int i=1;i<n-2;i++)
        {
            for(int j=0;j<graph.get(i).size();j++)
            {
                pw.print(i+" ");
                pw.println(graph.get(i).get(j));
            }
        }

        pw.close();
    }
}