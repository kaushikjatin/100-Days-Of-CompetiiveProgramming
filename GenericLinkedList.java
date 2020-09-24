import java.util.*;

public class linkedlist<T>
{
    static class Node<T>
    {
        T info;
         Node<T> next;
         Node(T data)
         {
            info=data;
         }
    }


    Node<T> head=null;
    Node<T> tail=null;
    int size=0;

    public void add(T data)
    {
        Node<T> temp=new Node<>(data);
        size++;
        if(tail==null)
        {
            head=temp;
            tail=temp;
        }
        else 
        {
            tail.next=temp;
            tail=temp;
        }
    }


    public T remove()
    {
        if(size==1)
        {
            T lastnode=head.info;
            size--;
            head=null;
            tail=null;
            return lastnode;
        }
        else 
        {
            size--;
            Node<T> temp=head;
            while(temp.next!=tail)
              temp=temp.next;
            T lastnode=tail.info;
            tail=temp;
            tail.next=null;
            return lastnode;
        }

    }

    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        linkedlist<Integer> list1=new linkedlist<>();

        // adding the elements to the linkedlist
        int length=scan.nextInt();
        while(length--!=0)
            list1.add(scan.nextInt());

        // deleting and printing the elements from the linkedlist
        while(list1.size!=0)
        {
            System.out.println(list1.remove());
        }
    }
}