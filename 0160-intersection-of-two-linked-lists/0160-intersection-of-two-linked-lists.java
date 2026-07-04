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
        HashMap<ListNode, Integer> hm = new HashMap<>();
        ListNode temp = headA;
        while(temp!=null){
            hm.put(temp,1);
            temp = temp.next;
        }

        temp = headB;
        while(temp!=null){
            if(hm.containsKey(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}