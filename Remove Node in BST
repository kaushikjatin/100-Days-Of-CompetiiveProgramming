public class Solution 
{

	public static BinaryTreeNode<Integer> removeNode(int data, BinaryTreeNode<Integer> root) 
    {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, they are passed as function arguments.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
        if(root.data==data)
        {
            if(root.left==null && root.right==null)
            {
                return null;
            }
            if(root.left==null && root.right!=null)
            {
                return root.right;
            }
            if(root.left!=null && root.right==null)
            {
                return root.left;
            }
            else 
            {
                BinaryTreeNode<Integer> inorder_sucessor=find(root.right);
                removeNode(inorder_sucessor.data,root.right);
                root.data=inorder_sucessor.data;
                return root;
            }
        }
        if(root.data<data)
        {
            root.right=removeNode(data,root.right);
            return root;
        }
        else 
        {
            root.left=removeNode(data,root.left);
            return root;
        }
		
	}
    
    
    public static BinaryTreeNode<Integer> find(BinaryTreeNode<Integer> root)
    {
        if(root.left==null && root.right==null)
        {
            return root;
        }
        if(root.left==null && root.right!=null)
        {
            return root.right;
        }
        return find(root.left);
    }
}
