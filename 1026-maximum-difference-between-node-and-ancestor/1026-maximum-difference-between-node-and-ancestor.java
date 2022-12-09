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
    static int max_diff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        dfs(root, li);
        int res = max_diff;
        max_diff =  Integer.MIN_VALUE;
        return res;
    }
    
    public void dfs(TreeNode root, List<Integer> li) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            li.add(root.val);
            calc_Max_diff(li);
        }
        li.add(root.val);
        List<Integer> li2 = new ArrayList<>(li);
        dfs(root.left, li);
        dfs(root.right,li2);
    }
    
    public void calc_Max_diff(List<Integer> li){
        Collections.sort(li);
        if(li.size()<0) return;
        for(Integer i : li) {
            System.out.print(i + " ");
        }
        int val = li.get(li.size()-1) - li.get(0);
        if(max_diff< val){
            max_diff = val;
        }
    }
}