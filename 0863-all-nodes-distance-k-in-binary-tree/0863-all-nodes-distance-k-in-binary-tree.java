/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void mapParent(TreeNode root, HashMap parentMap){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left!=null) {
                parentMap.put(current.left,current);
                queue.offer(current.left);
            }
            if(current.right!=null){
                parentMap.put(current.right,current);
                queue.offer(current.right);
            } 
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        mapParent(root,parentMap);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        int level = 0;
        queue.offer(target);
        visited.put(target,true);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(level==k) break;
            level++;

            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.left!=null && visited.get(current.left)==null){
                    queue.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right!=null && visited.get(current.right)==null){
                    queue.offer(current.right);
                    visited.put(current.right,true);
                }
                if(parentMap.get(current)!=null && visited.get(parentMap.get(current))==null){
                    queue.offer(parentMap.get(current));
                    visited.put(parentMap.get(current),true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }
}