class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        for(Integer k : rooms.get(0)) {
                set.add(k);
            }
        int c=0;
        int i=0;
        boolean vis [] = new boolean[rooms.size()];
        vis[0] = true;
        while(!set.isEmpty()){
            i = (int) set.iterator().next();
            if(!set.contains(i) && rooms.get(i).size()>0) return false;
            if(vis[i]==false) {
                for(Integer k : rooms.get(i)) {
                    set.add(k);
                }
            }
            set.remove(i);
            vis[i] = true;
        }
        for(int j=0;j<rooms.size();j++) {
            if(vis[j]==false) return false;
        }
        return true;
    }
}