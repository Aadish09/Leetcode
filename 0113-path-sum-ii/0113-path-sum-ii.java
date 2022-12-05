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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> parent = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        if(root == null) return parent;
        sum(root, targetSum, parent, li);
        return parent;
    }
    public void sum(TreeNode root, int number, List<List<Integer>> parent, List<Integer> li) {
        if(root == null) return;
        if(root.left == null && root.right==null && number == root.val) {
            li.add(root.val);
            parent.add(li);
            li.remove(li.size()-1);
        }
        li.add(root.val);
        List<Integer> temp = new ArrayList<>(li);
        sum(root.left, number-root.val, parent, li);
        sum(root.right, number-root.val,parent, temp);
    }
}