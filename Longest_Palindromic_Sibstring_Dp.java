class Solution {
    static String ans="";
    static int dp[][];
    static String str="";
    public String longestPalindrome(String s) {
        ans=s.substring(0,1);
        str=s;
        int n=s.length();
        dp=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dp[i][j]=-1;
        for(int i=0;i<n;i++)
            for(int j=i;j<n;j++)
                if(dp[i][j]==-1)
                    find_ans(i,j);
        return ans;
    }
    
    public static void find_ans(int se,int ee){
        if(dp[se][ee]!=-1)
            return;
        int flag=0;
        if(se==ee)
            flag=1;
        else{
            if(se==ee-1 && str.charAt(se)==str.charAt(se+1))
                flag=1;
            else if(se==ee-1)
                flag=0;
            else{
                find_ans(se+1,ee-1);
                if(dp[se+1][ee-1]==1 && str.charAt(se)==str.charAt(ee))
                    flag=1;
                else
                    flag=0;
            }
                
        }
        dp[se][ee]=flag;
        if(flag==1 && (ee-se+1)>ans.length())
            ans=str.substring(se,ee+1);
    }
}