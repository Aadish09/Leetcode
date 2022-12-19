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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res= new ArrayList<TreeNode>();
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        if(n%2==0)  return res;
        generate(n, res, map);
        return res;
    }
    
    public List<TreeNode> generate(int n, List<TreeNode> res, Map<Integer, List<TreeNode>> map){
        if(n==0) return res;
        if(n==1) { res.add(new TreeNode(0)); return res;}
        for(int i=0;i<n;i++) {
            int countOfLeft = i;
            int countOfRight = n - i - 1;
            
            List<TreeNode> leftList;
            if(map.get(countOfLeft)!=null) leftList = map.get(countOfLeft);
            else {
                leftList = generate(countOfLeft, new ArrayList<>(), map);
                map.put(countOfLeft, leftList);
            }
            
            List<TreeNode> rightList;
            if(map.get(countOfRight)!=null) rightList = map.get(countOfRight);
            else {
                rightList = generate(countOfRight, new ArrayList<>(), map);
                map.put(countOfRight, rightList);
            }
            
            for(TreeNode l : leftList) {
                for(TreeNode r : rightList) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
            
        }
        return res;
    }
}