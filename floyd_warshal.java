import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// matrix arrray is th eedge weight matrix...and -1 in that will denote no diret path between edges....and in question all edges will be +ve

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n=matrix.length;
        for(int i=0;i<n;i++)
        {
            // include i in the path
            for(int j=0;j<n;j++)
            {
                if(j==i)
                    continue;
                for(int k=0;k<n;k++)
                {
                    // neew to go from j to k via i
                    if(k==i)
                        continue;
                    if(j==k)
                        continue;
                    if(matrix[j][i]==-1 || matrix[i][k]==-1)
                        continue;
                    int temp_dist=matrix[j][i]+matrix[i][k];
                    if(matrix[j][k]==-1)
                        matrix[j][k]=temp_dist;
                    else 
                        matrix[j][k]=Math.min(matrix[j][k],temp_dist);
                }
            }
        }
    }
}