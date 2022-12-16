class Solution {
    static int count = 0;
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean [] possible = new boolean[n];
        utility(0 , possible, n-1, nums);
        count = 0;
        return possible[n-1];
    }
    public void utility(int index, boolean[] vis, int n, int [] nums){
        count++; 
        if(index > n) return;
        if(index == n) {
            vis[n] = true;
            return;
        }
        int el = nums[index];
        if(vis[index]) return;
        vis[index]  = true;
        System.out.println(index);

        for(int i=1;i<=el;i++) {
            int next = index + i;
            if(next > n) return;
            if(vis[next] == true) continue;
            utility(next, vis, n, nums);
        }
    }
}