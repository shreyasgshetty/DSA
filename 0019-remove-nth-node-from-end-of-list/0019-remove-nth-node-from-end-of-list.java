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
        int count = 0;
        ListNode temp = head;

        while(temp!= null){
            count++;
            temp = temp.next;
        }
        int k = count - n + 1;

        if(head == null) return head;

        if(k==1){
            ListNode newTemp = head;
            head = head.next;
            return head;
        }
        count = 0;

        ListNode newTemp = head;
        ListNode prev = null;

        while(newTemp!= null){
            count++;
            if(count == k){
                prev.next = prev.next.next;
                break;
            }
            prev = newTemp;
            newTemp = newTemp.next;
        }
        return head;
    }
}