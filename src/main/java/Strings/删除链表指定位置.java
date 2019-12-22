package Strings;

import java.util.ArrayList;
import java.util.List;

public class 删除链表指定位置 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre =new ListNode(0);
        pre.next=head;
        ListNode start=pre;
        ListNode end=pre;
        int i=0;
         while (i != n){
             end=end.next;
             i++;
         }
         while (end.next!=null){
             end=end.next;
             start=start.next;
         }
         start.next=start.next.next;

        if(start==pre) head=start.next;
         return head;
    }
}


class ListNode{
    int val;
      ListNode next;
      ListNode(int x) { val = x; }
}