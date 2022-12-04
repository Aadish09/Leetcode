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
   public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return inOrder(cloned, target);
    }
    
    public TreeNode inOrder (TreeNode node , TreeNode target) {
        if(node == null) return null;
        TreeNode res = inOrder(node.left , target);
        if(res != null) return res;
        if(node.val == target.val) return node;
        return inOrder(node.right, target);
    }
}