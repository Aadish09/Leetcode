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
    static int res =0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sum(root, 0);
        int temp = res;
        res = 0;
        return temp;
    }
    public void sum(TreeNode root, int number) {
        if(root == null) return;
        if(root.left == null && root.right==null) {
            res = res + (number * 10 + root.val);
            return;
        }
        sum(root.left, number * 10 + root.val);
        sum(root.right, number * 10 + root.val);
    }
}