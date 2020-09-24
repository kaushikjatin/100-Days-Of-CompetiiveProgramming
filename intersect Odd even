import java.util.Scanner;

/*class ListNode<t>
{
	public t data;
	public ListNode<t> next;
	public ListNode(t data)
	{
		this.data=data;
	}
}

public class runner 
{
	
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		ListNode<Integer> head1 = null, temp = null;
		//enter -1 to end
		int data = s.nextInt();
		while(data != -1){
			if(head1 == null){
				head1 = new ListNode<Integer>(data);
				temp = head1;
			}else{
				temp.next = new ListNode<Integer>(data);
				temp = temp.next;
			}
			data = s.nextInt();
		}
		
		ListNode<Integer> head2 = null;
		temp = null;
		//enter -1 to end
		data = s.nextInt();
		while(data != -1){
			if(head2 == null){
				head2 = new ListNode<Integer>(data);
				temp = head2;
			}else{
				temp.next = new ListNode<Integer>(data);
				temp = temp.next;
			}
			data = s.nextInt();
		}
		print(solution.AlterList(head1,head2));
	}
	
	public static void print(ListNode<Integer> head){
		while(head != null){
			System.out.print(head.data+" ");
			head = head.next;
		}
	}
}
*/

// The commented code runs in the backend which does the work of taking input.In this I have to just implement the provided function.






public class Solution
{
    
    public static ListNode<Integer> AlterList(ListNode<Integer> head1,ListNode<Integer> head2) 
    {
        /*Your class should be named solution.
         *Don't write main().
         *Don't take input, it is passed as function argument.
         *Don't print output.
         *Taking input and printing output is handled automatically.
         */ 
        ListNode<Integer> head_even,tail_even,head_odd,tail_odd;
        head_even=null;
        tail_even=null;
        head_odd=null;
        tail_odd=null;
        while(head1!=null && head2!=null)
        {
            //System.out.println(head1.data+" "+head2.data);
            if(head1.data-head2.data==0)
            {
                if(head1.data%2==0)
                {
                    if(head_even==null)
                    {
                        head_even=head1;
                        tail_even=head1;
                    }
                    else 
                    {
                        tail_even.next=head1;
                        tail_even=tail_even.next;
                    }
                    head1=head1.next;
                    head2=head2.next;
                }
                else 
                {
                    if(head_odd==null)
                    {
                        head_odd=head1;
                        tail_odd=head1;
                    }
                    else 
                    {
                        tail_odd.next=head1;
                        tail_odd=tail_odd.next;
                    }
                    head1=head1.next;
                    head2=head2.next;
                }
            }
            else if(head1.data-head2.data<0)
            {
                head1=head1.next;
            }
            else
            {
                head2=head2.next;
            }
        }
        if(head_odd==null)
        {
            if(tail_even!=null)
            tail_even.next=null;
            return head_even;
        }
        else 
        {
            tail_odd.next=head_even;
            if(tail_even!=null)
            tail_even.next=null;
            return head_odd;
        }
    }
    
}
