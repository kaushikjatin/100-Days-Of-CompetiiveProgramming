class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans_list=null;
        ListNode answer=null;
        int carry=0;
        while(l1!=null && l2!=null){
            int new_digit=(l1.val+l2.val+carry)%10;
            carry=(l1.val+l2.val+carry)/10;
            if(ans_list==null)
            {
                ans_list=new ListNode(new_digit);
                answer=ans_list;
            }
            else {
                ans_list.next=new ListNode(new_digit);
                ans_list=ans_list.next;
            }
                
            l1=l1.next;
            l2=l2.next;
        }
        
        while(l1!=null){
            int new_digit=(l1.val+carry)%10;
            carry=(l1.val+carry)/10;
             if(ans_list==null)
            {
                ans_list=new ListNode(new_digit);
                answer=ans_list;
            }
            else
            {
                ans_list.next=new ListNode(new_digit);
                ans_list=ans_list.next;
            }
                
            l1=l1.next;
        }
        
        while(l2!=null){
            int new_digit=(l2.val+carry)%10;
            carry=(l2.val+carry)/10;
             if(ans_list==null)
            {
                ans_list=new ListNode(new_digit);
                answer=ans_list;
            }
            else 
            {
                ans_list.next=new ListNode(new_digit);
                 ans_list=ans_list.next;
            }
                
            l2=l2.next;
        }
        
        if(carry!=0)
            ans_list.next=new ListNode(carry);
        return answer;
    }
}