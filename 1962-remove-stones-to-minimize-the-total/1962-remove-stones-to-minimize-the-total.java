class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int n = piles.length;
        for(int i=0;i<n;i++){
            pq.add(piles[i]);
        }
        while(k>0 && !pq.isEmpty()) {
            int x = pq.poll();
            x = x - (int)Math.floor((int)x/2);
            k--;
            pq.add(x);
        }
        int sum =0;
        while(!pq.isEmpty()){
            sum = sum + pq.poll();
        }
        return sum;
    }
}