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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
               List<List<Integer>> li = new ArrayList<List<Integer>>();

        if(root==null) return li;
        Queue<TreeNode>  q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> tempArray = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp!=null) {
                tempArray.add(temp.val);
                if(temp.left!=null){q.add(temp.left);}
                if(temp.right!=null){q.add(temp.right);}
            } else {
                li.add(tempArray);
                tempArray  = new ArrayList<>();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
        }
        Collections.reverse(li);
        return li;
    }
}