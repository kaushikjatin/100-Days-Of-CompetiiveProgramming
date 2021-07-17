class Solution
{
    
	ArrayList <Integer> printBoundary(Node node)
	{
	    if(node==null)
	        return null;
	    ArrayList<Integer> ans=new ArrayList<Integer>();
	    ans.add(node.data);
	    print_left_boundary(node.left,ans);
	    print_leaves(node.left,ans);
	    print_leaves(node.right,ans);
	    print_right_boundary(node.right,ans);
	    return ans;
	}
	
	public void print_right_boundary(Node node,ArrayList<Integer> ans){
	    if(node==null)
	        return;
	     if(node.left==null && node.right==null)
	        return;
	        
	     if(node.right!=null)
	        print_right_boundary(node.right,ans);
	    else if(node.left!=null)
	        print_right_boundary(node.left,ans);
	     ans.add(node.data);
	}
	
	public void print_leaves(Node node,ArrayList<Integer> ans){
	    if(node==null)
	        return;
	     
	    if(node.left==null && node.right==null)
	        ans.add(node.data);
	    print_leaves(node.left,ans);
	    print_leaves(node.right,ans);
	}
	
	public void print_left_boundary(Node node,ArrayList<Integer> ans)
	{
	    if(node==null)
	        return;
	    if(node.left==null && node.right==null)
	       return;
	    
	    ans.add(node.data);
	    if(node.left!=null)
	        print_left_boundary(node.left,ans);
	    else if(node.right!=null)
	        print_left_boundary(node.right,ans);
	}
	
}
