/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> inarr = new  ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int l = 0;
        int r = inarr.size()-1;

        while(r>l){
            if(inarr.get(l)+inarr.get(r)==k) return true;

            if((inarr.get(l)+inarr.get(r))>k) r--;
            else if((inarr.get(l)+inarr.get(r))<k) l++;
        }
        return false;
    }

    public void inorder(TreeNode root){
        if(root==null) return; 
        inorder(root.left);
        inarr.add(root.val);
        inorder(root.right);
    }
}