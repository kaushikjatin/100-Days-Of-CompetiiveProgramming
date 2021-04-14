// it is used to find the shortest path from source to rest of the nodes.
// make a array names distance...set values inside it to infinity...for src set dis[src]=0
// relax all the edges n-1 times.
// try relaxing nth time...and if any vertice's distance get's decreased then it means it have negative weight style...but if any 
// anyone doesn't change then it means we have found our answer....

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
       int weight[]=new int[n];
       for(int i=0;i<n;i++)
            weight[i]=Integer.MAX_VALUE;
       weight[0]=0;
       
       // relaxing all edges v-1 times.
       for(int j=1;j<=n-1;j++)
       {
            for(int i=0;i<edges.length;i++)
           {
               int a=edges[i][0];
               int b=edges[i][1];
               int c=edges[i][2];
               if(weight[a]!=Integer.MAX_VALUE && weight[a]+c<weight[b])
                weight[b]=weight[a]+c;
           }   
       }
        for(int i=0;i<edges.length;i++)
       {
           int a=edges[i][0];
           int b=edges[i][1];
           int c=edges[i][2];
           if(weight[a]!=Integer.MAX_VALUE && weight[a]+c<weight[b])
            return 1;
       }  
       return 0;
    }
}