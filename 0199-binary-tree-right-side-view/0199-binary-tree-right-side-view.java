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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> li = new ArrayList<>();
         if(root==null) return li;
        Queue<TreeNode>  q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp == null){
                if(!q.isEmpty()){
                    q.add(null);
                }
                continue;
            }
            if(q.peek() == null) {
                li.add(temp.val);
            }
            if(temp.left!=null){q.add(temp.left);}
            if(temp.right!=null){q.add(temp.right);}
        }
        return li;
    }
}