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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = new TreeNode(val);
        if(root==null) return temp;
        TreeNode node = root;
        while(node!=null){
            if(node.val<val ){
                if(node.right==null){
                    node.right = temp;
                    break;
                } else node = node.right;
            }
            else if(node.val>val){
                if(node.left==null){
                    node.left = temp;
                    break;
                } else node = node.left;
            }
        }
        return root;
    }
}