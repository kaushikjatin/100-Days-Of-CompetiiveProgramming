class Solution
{
    int findMaxSum(int arr[], int n) 
    {
        int dp[]=new int[n];
        dp[n-1]=arr[n-1];
        if(n>1)
            dp[n-2]=Math.max(arr[n-1],arr[n-2]);
        for(int i=n-3;i>=0;i--)
            dp[i]=Math.max(arr[i]+dp[i+2],dp[i+1]);
        return dp[0];
    }
}