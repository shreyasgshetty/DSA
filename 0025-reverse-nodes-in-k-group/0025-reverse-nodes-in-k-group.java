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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp!=null){
            ListNode kthNode = findkthNode(temp,k);
            if(kthNode == null){
                if(prev!=null) prev.next= temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;

            reverseLL(temp);

            if(temp == head){
                head = kthNode;
            }
            else{
                prev.next = kthNode;
            }
            prev = temp;
            temp = nextNode;
        }
        return head;
        
    }

    public ListNode findkthNode(ListNode temp,int k){
        k-= 1;
        while(temp!=null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    
    public ListNode reverseLL(ListNode temp){
        ListNode prevNode = null;
        ListNode t1 = temp;

        if(temp==null||temp.next==null){
            return temp;
        }

        while(t1!=null){
            ListNode newTemp = t1.next;
            t1.next = prevNode;
            prevNode = t1;
            t1 = newTemp;
        }
        return prevNode;
    }
}