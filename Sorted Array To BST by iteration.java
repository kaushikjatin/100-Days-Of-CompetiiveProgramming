import java.util.Scanner;
import java.util.*;
public class Runner 
{
  static class Node<T>
  {
    T data;
    Node<T> left;
    Node<T> right;
    
     Node(T info)
    {
        data=info;
    }
    
  }
  
  
  static class Triplet<T,U>
  {
      T first;
      U second;
      U third;
      public Triplet(T first,U second,U third)
      {
          this.first=first;
          this.second=second;
          this.third=third;
      }
  }
    public static void main(String argd[])
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=scan.nextInt();
        }
        Node<Integer> root=new Node<>(0);
        int startindex=0,endindex=n-1;
        Stack<Triplet<Node<Integer>,Integer>> stack=new Stack<>();
        stack.push(new Triplet<Node<Integer>,Integer>(root,startindex,endindex));
        while(!stack.empty())
        {
            Triplet<Node<Integer>,Integer> temp=stack.pop();
            if(temp.third==temp.second)
            {
                temp.first.data=arr[temp.third];
                continue;
            }
            else 
            {
                int mid=(temp.second+temp.third)/2;
                temp.first.data=arr[mid];
                if(temp.third>mid)
                {
                    temp.first.right=new Node<Integer>(0);
                    stack.push(new Triplet<Node<Integer>,Integer>(temp.first.right,mid+1,temp.third));
        
                }
                if(temp.second<mid)
                {
                    temp.first.left=new Node<Integer>(0);
                    stack.push(new Triplet<Node<Integer>,Integer>(temp.first.left,temp.second,mid-1));
                }
            }
        }
        pre(root);
        
    }
    
    
    public static void pre(Node<Integer> head)
    {
        if(head==null)
        {
            return;
        }
        System.out.println(head.data);
        pre(head.left);
        pre(head.right);
        
    }
    
    public static Node<Integer> add(Node<Integer> root,int info)
    {
        if(root==null)
        {
            root=new Node<Integer>(info);
            return root;
        }
        else 
        {
            Node<Integer> temp=root;
            Node<Integer> last=null;
            while(temp!=null)
            {
                if(info>temp.data)
                {
                    last=temp;
                    temp=temp.right;
                }
                else
                {
                    last=temp;
                    temp=temp.left;
                }
            }
            if(info>last.data)
            {
                last.right=new Node<Integer>(info);
            }
            else 
            {
                last.left=new Node<Integer>(info);
            }
            return root;
        }
    }
    
}