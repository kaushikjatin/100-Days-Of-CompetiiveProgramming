class Solution 
{
    public int largestRectangleArea(int[] heights)
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
                    System.out.println(left+" "+ind+" "+right);
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
            System.out.println(left+" "+ind+" "+right);
        }
        return max;
    }
}