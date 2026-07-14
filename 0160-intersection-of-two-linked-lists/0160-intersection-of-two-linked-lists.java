/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1 = getLen(headA);
        int n2 = getLen(headB);

        ListNode c1 = headA;
        ListNode c2 = headB;
        
        int diff = Math.abs(n1-n2);
        
        for(int i=0;i<diff;i++){
            if(n1>n2){
                c1 = c1.next;
            }else{
                c2 = c2.next;
            }
        }
        while(c1!=null && c2!=null){
            if(c1==c2) return c1;
            c1 = c1.next;
            c2 = c2.next;
        }
        return null;
    }
    public int getLen(ListNode node){
        ListNode curr = node;
        int count = 0;
        while(curr!=null){
            curr = curr.next;
            count++;
        }
        return count;
    }
}