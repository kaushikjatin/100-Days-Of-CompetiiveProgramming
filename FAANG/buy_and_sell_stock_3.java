class Solution 
{
    public int maxProfit(int[] prices)
    {
        int n=prices.length,  min=prices[0],  max=prices[n-1];
        int left[]=new int[n];
        int right[]=new int[n];
        
        for(int i=1;i<n;i++)
        {
            int op1=left[i-1]; // we didn't sell here so max profit is same.
            int op2=prices[i]-min;
            left[i]=Math.max(op1,op2);
            min=Math.min(prices[i],min);
        }
        
        for(int i=n-2;i>=0;i--)
        {
            int op1=right[i+1];
            int op2=max-prices[i];
            right[i]=Math.max(op1,op2);
            max=Math.max(prices[i],max);
        }
        
        int ans=0;
        for(int i=0;i<n;i++)
            ans=Math.max(left[i]+right[i],ans);
        return ans;
        
    }
}