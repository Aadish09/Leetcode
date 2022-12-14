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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        return uil(root, p, q);
    }
    
    public TreeNode uil(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if((p.val<root.val && q.val>root.val) || (p.val>root.val && q.val<root.val) || p.val==root.val || q.val==root.val) return root;
        TreeNode res = null;
        if(p.val<root.val) { res  = uil(root.left, p, q); }
        if(res != null)  return res;
        if(p.val>root.val) res  = uil(root.right, p, q);

        return res;
    }
}