class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] min_steps = new int[n];
        Arrays.fill(min_steps, Integer.MAX_VALUE);
        if(n==0) return 0;
        min_steps[0]=0;
        return utility(0 , min_steps, n, nums);
    }
    public int utility(int index, int [] vis, int n, int [] nums){
        int i=1, j=0;
        while(i<n) {
                if(nums[j] + j >= i  && vis[j]!= Integer.MAX_VALUE){
                    vis[i]=Math.min(vis[i],vis[j]+1);
                    i++;
                } else j++;
        }
        return vis[n-1];
    }
}