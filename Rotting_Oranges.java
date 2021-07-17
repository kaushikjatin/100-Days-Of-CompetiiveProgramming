class Solution {
    
    static class pair{
        int x;
        int y;
        int time;
        pair(int a,int b,int c){
            x=a;    y=b;    time=c;
        }
    }
    
    static int min_time[][];
    static Queue<pair> queue;
    static int n,m;
    static int visited[][];
    static int movement[][]={
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    
    
    public int orangesRotting(int[][] grid) {
        n=grid.length;  m=grid[0].length;
        visited=new int[n][m];
        min_time=new int[n][m];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                    min_time[i][j]=0;
                else 
                    min_time[i][j]=9999999;
            }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                {
                    set_visited(grid);
                    queue=new LinkedList<>();
                    bfs(i,j);
                }
            }
        }
        
        int max_time=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]!=0)
                    max_time=Math.max(min_time[i][j],max_time);
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                System.out.print(min_time[i][j]+" ");
            System.out.println();
        }
        
        if(max_time==9999999)
            return -1;
        return max_time;
    }
    
    public static void bfs(int i,int j){
        queue.add(new pair(i,j,0));
        
        while(queue.size()!=0){
            pair temp=queue.poll();
            visited[temp.x][temp.y]=2;
            min_time[temp.x][temp.y]=Math.min(min_time[temp.x][temp.y],temp.time);
            i=temp.x;   j=temp.y;
            for(int x=0;x<4;x++){
                int new_i=i+movement[x][0];
                int new_j=j+movement[x][1];
                if(new_i<n && new_i>=0 && new_j<m && new_j>=0 && visited[new_i][new_j]==1)
                    queue.add(new pair(new_i,new_j,temp.time+1));
            }
            
        }
    }
    
    public static void set_visited(int grid[][]){
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                visited[i][j]=grid[i][j];
    }
}