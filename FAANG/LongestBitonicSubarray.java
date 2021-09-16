class Solution
{
    static int inc[];
    static int dec[];
    static int n;
    public int LongestBitonicSequence(int[] nums)
    {
        n=nums.length;
        inc=new int[n];
        dec=new int[n];
        fill_dp(nums);
        int ans=0;
        for(int i=0;i<n;i++)
            ans=Math.max(ans,inc[i]+dec[i]-1);
        return ans;
        
    }
    
    public static void fill_dp(int nums[])
    {
        inc[0]=1;
        for(int i=1;i<n;i++)
        {
            if(nums[i]>nums[i-1])
                inc[i]=inc[i-1]+1;
            else 
                inc[i]=1;
        }
        
        dec[n-1]=1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]>nums[i+1])
                dec[i]=dec[i+1]+1;
            else 
                dec[i]=1;
                
        }
           
    }
}