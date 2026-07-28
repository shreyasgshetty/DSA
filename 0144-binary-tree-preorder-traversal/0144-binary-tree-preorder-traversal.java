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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<Integer>();
        if(root==null) return ans;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node.right!=null) st.push(node.right);
            if(node.left!=null) st.push(node.left);
            ans.add(node.val);
        }
        return ans;
    }
}