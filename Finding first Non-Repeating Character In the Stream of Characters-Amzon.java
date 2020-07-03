import java.util.Scanner;
import java.util.*;
public class Runner 
{
  static class Node<T>
  {
    T data;
    Node<T> next;
    Node<T> prev;
    
     Node(T info)
    {
        data=info;
    }
    
  }
  
  
  static class Pair<T>
  {
      T head;
      T tail;
      public Pair(T head,T tail)
      {
          this.head=head;
          this.tail=tail;
      }
  }
    public static void main(String argd[])
    {
        Scanner scan=new Scanner(System.in);
        char ch;
        Node<Character> head=null;
        Node<Character> tail=null;
        ch=scan.next().charAt(0);
        HashMap<Character,Node<Character>> map= new HashMap<>();
        Pair<Node<Character>> pair1=add(ch,head,tail,map);
        head=pair1.head;
        tail=pair1.tail;
        //System.out.println(head);
        //System.out.println(tail);
        while(ch!='*')
        {
            if(head!=null)
            {
            System.out.println(head.data);
            }
            else 
            {
                System.out.println("-1");
            }
            ch=scan.next().charAt(0);
            if(map.containsKey(ch))
            {
                Pair<Node<Character>> pair=remove(map.get(ch),head,tail);
                head=pair.head;
                tail=pair.tail;
            }
            else 
            {
                Pair<Node<Character>> pair=add(ch,head,tail,map);
                head=pair.head;
                tail=pair.tail;
            }
        }
    }
    
    public static Pair<Node<Character>> add(char ch,Node<Character> head,Node<Character> tail,HashMap<Character,Node<Character>> map)
    {
        if(head==null)
        {
            head= new Node<Character>(ch);
            map.put(ch,head);
            tail=head;
           // System.out.println(head);
            //System.out.println(tail);
        }
        else 
        {
            tail.next=new Node<Character>(ch);
            map.put(ch,tail.next);
            tail.next.prev=tail;
            tail=tail.next;
        }
        Pair<Node<Character>> pair=new Pair<>(head,tail);
        return pair;
    }
    
    public static Pair<Node<Character>>  remove(Node<Character> ref,Node<Character> head,Node<Character> tail)
    {
       
      if(true)
      {
        if(head==ref)
        {
            head=head.next;
            if(head!=null)
            {
                head.prev=null;
            }
          Pair<Node<Character>> pair=new Pair<>(head,tail);
          return pair;
        }
        if(tail==ref)
            {
            tail=tail.prev;
            if(tail!=null)
            {
                tail.next=null;
            }
            Pair<Node<Character>> pair=new Pair<>(head,tail);
            return pair;
        }
      }
           ref.prev.next=ref.next;
           ref.next.prev=ref.prev;
           Pair<Node<Character>> pair=new Pair<>(head,tail);
           return pair;
    }
}