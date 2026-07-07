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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null || head.next == null){
            return head;
        }
        int length = 0;
        ListNode newTemp = head;
        while(newTemp!=null){
            length++;
            newTemp = newTemp.next;
        }

        k = k%length;
        
        while(k>0){
            ListNode temp = head;
            ListNode prev = null;
            while(temp.next!=null){
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
            temp.next = head;
            head = temp;
            k--;
        }
        return head;
    }
}