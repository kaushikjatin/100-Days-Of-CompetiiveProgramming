class Solution {
    public int lengthOfLongestSubstring(String s) {
        int se=0,ee=0,n=s.length(),ans=1;
        int arr[]=new int[200];
        Arrays.fill(arr,-1);
        
        if(n==1 || n==0)
            return n;
        
        while(ee<n)
        {
            int code=s.charAt(ee)-' ';
            if(arr[code]==-1 || arr[code]<se){
                arr[code]=ee;
                ee++;
                ans=Math.max(ee-se,ans);
            }else{
                ans=Math.max(ee-se,ans);
                se=arr[code]+1;
                arr[code]=ee;
                ee++;
            }
        }
        return ans;
    }
}