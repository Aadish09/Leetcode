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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> li = new ArrayList<>();
        li = inorder(root1, li);
        
        List<Integer> li2 = new ArrayList<>();
        li2 = inorder(root2, li2);
        
        return li.equals(li2);
    }
    
    public List<Integer> inorder(TreeNode root, List<Integer> li) {
        if(root==null) return li;
        li = inorder(root.left, li);
        if(root.left == null && root.right == null) li.add(root.val);
        li = inorder(root.right, li);
        return li;
    }
}