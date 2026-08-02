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

class NodeValue {
    int minNode;
    int maxNode;
    int sum;

    NodeValue(int minNode, int maxNode, int sum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
    }
}

class Solution {

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private NodeValue helper(TreeNode root) {

        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        // Current subtree is a BST
        if (left.maxNode < root.val && root.val < right.minNode) {

            int currSum = left.sum + right.sum + root.val;

            maxSum = Math.max(maxSum, currSum);

            return new NodeValue(
                    Math.min(root.val, left.minNode),
                    Math.max(root.val, right.maxNode),
                    currSum
            );
        }

        // Not a BST
        return new NodeValue(
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                0
        );
    }
}