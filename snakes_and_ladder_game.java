//https://practice.geeksforgeeks.org/problems/snake-and-ladder-problem4816/1#    problem-link

class Solution
{
    static int graph[][]=new int[30][7];
    static int minThrow(int N, int arr[])
    {
       int n=N;
       HashMap<Integer,Integer> map1=new HashMap<>();
       HashMap<Integer,Integer> map2=new HashMap<>();
       for(int i=0;i<n;i++)
       {
           int a=arr[2*i];    int b=arr[2*i+1];
           a--;b--;
           if(a<b)
            map1.put(a,b);
           else 
            map2.put(a,b);
       }
       
       // built graph here
       for(int i=0;i<30;i++)
       {
           for(int j=1;j<=6;j++)
            {
                if(i+j>=30)
                    graph[i][j]=-1;
                else 
                {
                    if(map1.containsKey(i+j))
                        graph[i][j]=map1.get(i+j);
                    else if(map2.containsKey(i+j))
                        graph[i][j]=map2.get(i+j);
                    else 
                        graph[i][j]=i+j;
                }
            }
       }
       Queue<Integer> queue=new LinkedList<Integer>();
       queue.add(0);
       return bfs(queue);
    }
    
    static int bfs(Queue<Integer> queue)
    {
        Queue<Integer> temp=new LinkedList<Integer>();
        while(queue.size()!=0)
        {
            int node=queue.poll();
            if(node==29)
                return 0;
            for(int i=1;i<=6;i++)
            {
                if(node+i>29)
                    break;
                temp.add(graph[node][i]);
            }
        }
        return bfs(temp)+1;
    }
}