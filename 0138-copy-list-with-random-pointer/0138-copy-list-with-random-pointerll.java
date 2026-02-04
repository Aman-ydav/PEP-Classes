/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node copy = new Node(-1);
        Node curr = head;
        Node temp = copy;
        HashMap<Node,Node> map = new HashMap<>();
        while(curr!=null){

            temp.next = new Node(curr.val);

            // if(curr.random==null) temp.next.random = null;
            // else{
            //    if(map.containsKey(curr.random)){
            //         temp.next.random = map.get(curr.random);
            //    }
            // }
            map.put(curr,temp.next);
            curr = curr.next;
            temp = temp.next;
        }
        curr = head;
        temp = copy;
        while(curr!=null){

            if(curr.random==null) temp.next.random = null;
            else{
                if(map.containsKey(curr.random)){
                    temp.next.random = map.get(curr.random);
               }
            }
            temp = temp.next;
            curr = curr.next;
        }


        return copy.next;
    }
}