// time O(n^2);     space O(n);

class Solution
{
    static int lds_for[];
    static int lds_back[];
    static int n;
    public int LongestBitonicSequence(int[] nums)
    {
        n=nums.length;
        lds_for=new int[n];
        lds_back=new int[n];
        fill_dp(nums);
        int ans=1;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,lds_for[i]+lds_back[i]-1);
        }
        return ans;
    }
    
    public static void fill_dp(int nums[])
    {
        lds_for[n-1]=1;
        for(int i=n-2;i>=0;i--)
        {
            int max=1;
            for(int j=i+1;j<n;j++)
            {
                if(nums[j]<nums[i])
                    max=Math.max(lds_for[j]+1,max);
            }
            lds_for[i]=max;
        }
        
        lds_back[0]=1;
        for(int i=1;i<n;i++)
        {
            int max=1;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[j]<nums[i])
                    max=Math.max(lds_back[j]+1,max);
            }
            lds_back[i]=max;
        }
    }
}