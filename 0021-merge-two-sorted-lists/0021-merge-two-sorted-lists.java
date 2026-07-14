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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode c1 = list1;
        ListNode c2 = list2;
        ListNode d = new ListNode(0);
        ListNode d1 = d;
        while(c1!=null && c2!=null){
            if(c1.val<c2.val){
                d1.next = c1;
                c1 = c1.next;
            }
            else{
                d1.next = c2;
                c2 = c2.next;
            }
            d1 = d1.next;
        }
        if(c1!=null){
            d1.next = c1;
        }
        if(c2!=null){
            d1.next = c2;
        }
        return d.next;
    }
}