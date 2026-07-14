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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d = new ListNode(0);
        ListNode d1 = d;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int carry = 0;
        while(c1!=null && c2!=null){
            int v = c1.val+c2.val+carry;
            d1.next = new ListNode(v%10);
            carry = v/10;
            d1 = d1.next;
            c1 = c1.next;
            c2 = c2.next;
        }
        while(c1!=null){
            int v = c1.val+carry;
            d1.next = new ListNode(v%10);
            carry = v/10;
            d1 = d1.next;
            c1 = c1.next;
        }
        while(c2!=null){
            int v = c2.val+carry;
            d1.next = new ListNode(v%10);
            carry = v/10;
            d1 = d1.next;
            c2 = c2.next;
        }
        if(carry==1){
            d1.next = new ListNode(1);
        }
        return d.next;
    }
}