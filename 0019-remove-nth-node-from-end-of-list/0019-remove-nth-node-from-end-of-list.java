/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode d = new ListNode(0);
        ListNode end = d;
        end.next = head;
        if(head==null) return head;
        if(head.next==null && n==1) return null;
        if(head.next==null) return head; 
        for(int i=0;i<=n;i++){
            end = end.next;
        }
        ListNode pvt = d;
    
        while(end!=null){
            end = end.next;
            pvt = pvt.next;
        }
      
        pvt.next = pvt.next.next;
       
        return d.next;
    }
}