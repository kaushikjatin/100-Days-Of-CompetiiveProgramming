import java.util.*;
public class Main 
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=scan.nextInt();
        }
        int dp[][]=new int[n][n];
        int answer=findanswer(0,n-2,arr,dp);
        System.out.println(answer);
    }
    public static int findanswer(int i,int j,int arr[],int dp[][])
    {
        int answer=99999999;
        if(j==i)
        {
            return 0;
        } 
        if(j==i+1)
        {
            dp[i][j]=arr[i]*arr[j]*arr[j+1];
            return (arr[i]*arr[j]*arr[j+1]);
        }
        else if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        else 
        {
            int temp;
            for(int k=i;k<j;k++)
            {
                temp=findanswer(i,k,arr,dp);
                temp+=findanswer(k+1,j,arr,dp);
                temp+=arr[i]*arr[k+1]*arr[j+1];
                if(temp<answer)
                answer=temp;
            }
            dp[i][j]=answer;
        }
        return answer;
    }
}