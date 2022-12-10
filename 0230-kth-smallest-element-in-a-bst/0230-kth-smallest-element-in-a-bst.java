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
    static int k = -1;
    public int kthSmallest(TreeNode root, int c) {
        if(root == null) return -1;
        k = c;
        return inorder(root);
    }
    
    public int inorder(TreeNode root) {
        if(root == null) return -1;
        int val = inorder(root.left);
        if(val != -1) return val;
        k--;
        System.out.println(val + "---" + k + "---" + root.val);
        if(k==0) return root.val;
        return inorder(root.right);
    }
}