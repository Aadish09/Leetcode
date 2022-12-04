class Solution {
    public int minSwapsCouples(int[] rows) {
        int n = rows.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i=i+1) {
            map.put(rows[i], i);
        } 
        int swap = 0;
        for(int i=0;i<n;i=i+2) {
            int first = rows[i];
            int second = rows[i] ^ 1;
            if(rows[i+1] != second) {
                // swap needed
                int actual_index = map.get(second);
                map.replace(second, i+1);
                map.replace(rows[i+1], actual_index);
                int temp = rows[i+1];
                rows[i+1] = second;
                rows[actual_index] = temp;
                swap++;
            }
        } 
        return swap;
    }
}