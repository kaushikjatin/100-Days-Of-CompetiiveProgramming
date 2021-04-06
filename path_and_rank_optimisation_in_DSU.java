import java.util.*;
class Solution
{
    static int V,E;
    static int parent[],rank[];
    public static boolean isCycle(Scanner scan)
    {
        parent=new int[V];
        rank=new int[V];
        memset();
        return solve(scan);
    }
    
    public static boolean solve(Scanner scan)
    {
        for(int i=0;i<E;i++)
        {
            int a=scan.nextInt();
            int b=scan.nextInt();
            int p1=find_parent(a);
            int p2=find_parent(b);
            if(p1==p2)
                return true;
            if(rank[p1]<rank[p2])
                parent[p2]=p1;
            else 
                parent[p1]=p2;
        }
        return false;
    }
    
    public static int find_parent(int node)
    {
        if(parent[node]==node)
            return node;
        return parent[node]=find_parent(parent[node]);
    }
    
    public static void memset()
    {
        for(int i=0;i<parent.length;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
    }

    public static void main(String jatin[])
    {
        Scanner scan=new Scanner(System.in);
        V=scan.nextInt();
        E=scan.nextInt();
        System.out.println(isCycle(scan));
    }
}