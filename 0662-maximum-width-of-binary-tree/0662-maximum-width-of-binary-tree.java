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

class Pair{
    TreeNode node;
    int num;

    Pair(TreeNode node, int num){
        this.num = num;
        this.node = node;
    }
}
class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        int maxWidth = 0;
        if(root==null) return maxWidth;
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int level = queue.size();
            int min = queue.peek().num;
            int first = 0; 
            int last = 0;
            for(int i = 0; i < level;i++){
                int curr = queue.peek().num-min;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i==0) first = curr;
                if(i==level-1) last = curr;
                if(node.left!=null) queue.offer(new Pair(node.left,curr*2+1));
                if(node.right!=null) queue.offer(new Pair(node.right,curr*2+2));
            }
            maxWidth = Math.max(maxWidth,last-first+1);
            
        }
        return maxWidth;
        
    }
}