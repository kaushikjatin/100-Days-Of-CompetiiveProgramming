class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return k_reverse(head,k);
    }
    
    public ListNode k_reverse(ListNode head,int k){
        ListNode batch_tail=head;
        int i=0;
        while(batch_tail!=null && i<k-1){
            i++;
            batch_tail=batch_tail.next;
        }
        if(batch_tail==null)
            return head;
        ListNode next_batch_head=batch_tail.next;
        batch_tail.next=null;
        next_batch_head=k_reverse(next_batch_head,k);
        reverse_linked_list(head);
        head.next=next_batch_head;
        return batch_tail;
    }
    
    public static void reverse_linked_list(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=head.next;
        while(true){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next==null)
                break;
            next=next.next;   
        }
    }
}