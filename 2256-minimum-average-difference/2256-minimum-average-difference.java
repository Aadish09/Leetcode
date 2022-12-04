class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum = sum+nums[i];
        }
        long curr_sum =0;
        long min_avg_diff = Integer.MAX_VALUE;
        int ind =0;
        for(int i=0;i<n;i++){
            curr_sum = curr_sum + nums[i];
            long rem_sum = sum - curr_sum;
            long left_avg = curr_sum/(i+1);
            long right_avg = (n-i-1>0?(rem_sum/(n-i-1)):0);
            long avg = Math.abs(left_avg - right_avg);
            if(avg < min_avg_diff){
                ind  = i;
                min_avg_diff = avg;
            }  
        }
        return ind;
        
    }
}