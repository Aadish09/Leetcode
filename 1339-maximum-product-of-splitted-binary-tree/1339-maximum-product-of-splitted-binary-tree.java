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
    static long max_Product  = Integer.MIN_VALUE;
    public int maxProduct(TreeNode root) {
        int MOD = (int)(1e9 + 7);
        if(root == null) return 0;
        inorderSumProduct(root, sum(root));
        long res = max_Product;
        max_Product  = Integer.MIN_VALUE;
        return (int)(res%MOD);
    }
    
    public long sum(TreeNode root) {
        return (root == null) ? 0 : root.val + sum(root.left) + sum(root.right);
    }
    
    public long inorderSumProduct(TreeNode root, long totalSum) {
        if(root == null) return 0;
        long sumOfSubTree = root.val + inorderSumProduct(root.left, totalSum) + inorderSumProduct(root.right, totalSum) ;
        long product = sumOfSubTree*(totalSum-sumOfSubTree);
        if(product > max_Product) {
            max_Product = product;
        }
        return sumOfSubTree;
    }
}