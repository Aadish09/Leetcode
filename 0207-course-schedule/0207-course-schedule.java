class Solution {
    public boolean canFinish(int n, int[][] pre) {
        Set < Integer > set = new HashSet < > ();
        Map < Integer, List < Integer >> map = new HashMap < > ();
        for (int i = 0; i < pre.length; i++) {
          int key = pre[i][1];
          if (map.get(key) != null) {
            List < Integer > adj = map.get(key);
            adj.add(pre[i][0]);
            map.replace(key, adj);
          } else {
            int course = pre[i][0];
            map.put(key, new ArrayList < > () {
              {
                add(course);
              }
            });
          }
        }
        boolean[] vis = new boolean[n];
        List < Integer > res = new ArrayList<> ();
        for (int i = 0; i < n; i++) {
          if (!dfs(map, i, vis, new HashSet < > ())) {
              return false;
          } 
        }
        return true;
    }
    
     public boolean dfs(Map<Integer, List<Integer>> map, int vertex, boolean[] vis, Set <Integer> set) {
        if(vis[vertex]) return true;
        vis[vertex] = true;
        set.add(vertex);
        List <Integer> dependencies = map.get(vertex);
        if (dependencies == null) {      
            return true;
        }
        for (Integer i: dependencies) {
            if(set.contains(i)) return false;
            if(!dfs(map, i, vis, set)) return false;
            set.remove(i);
        }
        return true;
    }
}