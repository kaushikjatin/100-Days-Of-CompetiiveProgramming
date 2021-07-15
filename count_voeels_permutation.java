class Solution {
    static HashMap<Character,char[]> map=new HashMap<>();
    static long dp[][];
    
    public int index(char x){
        switch(x){
            case 'a':
                return 0;
            case 'e':
                return 1;
            case 'i':
                return 2;
            case'o':
                return 3;
            case'u':
                return 4;
        } 
        return 0;
    }
    public int countVowelPermutation(int n) {
        map.put('a',new char[] {'e'});
        map.put('e',new char[] {'a','i'});
        map.put('i',new char[] {'a','e','o','u'});
        map.put('o',new char[] {'i','u'});
        map.put('u',new char[] {'a'});
        dp=new long[5][n+1];
        for(int i=0;i<5;i++)    
            for(int j=0;j<=n;j++)
                dp[i][j]=-1;
        long ans=0;
        ans=(ans+fill_dp('a',n))%1000000007l;
        ans=(ans+fill_dp('e',n))%1000000007l;
        ans=(ans+fill_dp('i',n))%1000000007l;
        ans=(ans+fill_dp('o',n))%1000000007l;
        ans=(ans+fill_dp('u',n))%1000000007l;
        return (int)ans;
    }
    
    public long fill_dp(char x,int n){
        if(dp[index(x)][n]!=-1)
            return dp[index(x)][n];
        if(n==1)
            return dp[index(x)][n]=1;
        else 
        {
            long ans=0;
            for(char temp :map.get(x))
                ans=(ans+fill_dp(temp,n-1))%1000000007l;
            return dp[index(x)][n]=ans;
        }
    }
};