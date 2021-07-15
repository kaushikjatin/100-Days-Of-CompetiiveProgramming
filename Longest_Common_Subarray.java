class Solution 
{
    static int dp[][];
    public int findLength(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2=nums2.length;
        dp=new int[n1][n2];
        for(int i=0;i<n1;i++)
            for(int j=0;j<n2;j++)
                dp[i][j]=-1;
        int max_ans=0;
        for(int i=0;i<n1;i++)
            for(int j=0;j<n2;j++)
            {
                if(dp[i][j]==-1)
                    find_ans(nums1,nums2,i,j);
                max_ans=(max_ans<dp[i][j])?(dp[i][j]):(max_ans);
            }
        return max_ans;
    }
    
    public static int find_ans(int arr1[],int arr2[],int i,int j){
        if(i==arr1.length || j==arr2.length)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(arr1[i]!=arr2[j])
            return dp[i][j]=0;
        return dp[i][j]=find_ans(arr1,arr2,i+1,j+1)+1;
    }
}