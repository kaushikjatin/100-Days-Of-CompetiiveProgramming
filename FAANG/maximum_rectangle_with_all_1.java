class Solution {
    static int ans;
    public int maxArea(int matrix[][], int n, int m)
    {
        ans=0;
        for(int i=0;i<n;i++)
        {
            if(i==0)
                find_max_rect(matrix[i]);
            else 
            {
                for(int j=0;j<m;j++)
                {
                    if(matrix[i][j]!=0)
                        matrix[i][j]+=matrix[i-1][j];
                }   
                find_max_rect(matrix[i]);
            }
        }
        return ans;
    }
    
    public static void find_max_rect(int heights[])
    {
        Stack<Integer> stack=new Stack<>();
        int n=heights.length;
        int max=0;
        for(int i=0;i<n;i++)
        {
            if(stack.size()==0 || heights[stack.peek()]<heights[i])
                stack.push(i);
            else 
            {
                while(stack.size()!=0 && heights[stack.peek()]>=heights[i])
                {
                    int ind=stack.pop();
                    int right=i;
                    int left=-1;
                    if(stack.size()!=0)
                        left=stack.peek();
                    max=Math.max(max,(right-left-1)*heights[ind]);
                }
                stack.push(i);
            }
        }
        
        while(stack.size()!=0)
        {
            int ind=stack.pop();
            int right=n;
            int left=-1;
            if(stack.size()!=0)
                left=stack.peek();
            max=Math.max(max,(right-left-1)*heights[ind]);
        }
        ans=Math.max(ans,max);
    }
}