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
      public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1== null && root2!=null) {root1 = root2;return root1;}
        inOrder(root1, root2);
        return root1;
    }
    
    public void inOrder (TreeNode root1 , TreeNode root2) {
        if(root1 == null && root2 == null) return;
        if(root1== null && root2!=null) {root1 = root2;return;}
        if(root1!=null && root2!=null ){ 
            if(root1.left==null && root2.left != null) root1.left = root2.left;
            else inOrder(root1.left , root2.left); 
            root1.val = root2.val + root1.val;
            if(root1.right==null && root2.right != null) root1.right = root2.right;
            else inOrder(root1.right , root2.right);
        }
        
    }
}