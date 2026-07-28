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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int max = 0;
        int l = maxHeight(root.left);
        int r = maxHeight(root.right);
        int sum = l+r;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(sum,Math.max(right,left));
    }
    private int maxHeight(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(maxHeight(root.left),maxHeight(root.right));
    }
}