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
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }

        int arr[] = new int[count];

        temp = head;

        for(int i = 0; i < arr.length;i++){
            arr[i] = temp.val;
            temp = temp.next;
        }

        int j = 0;
        int k = arr.length - 1;

        while(j <= k){
            if(arr[j]!=arr[k]){
                return false;
            }
            j++;
            k--;
        }
        return true;

    }
}