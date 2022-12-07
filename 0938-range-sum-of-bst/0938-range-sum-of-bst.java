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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        return inorderSum(root, low, high, 0);
    }

    public int inorderSum(TreeNode root, int low, int high, int sum) {
        if(root == null) return sum+0;
        if(root.val< high+1 && root.val>low-1) sum = sum + root.val;
        sum = inorderSum(root.left, low, high, sum);
        return inorderSum(root.right, low, high, sum);
    }
}