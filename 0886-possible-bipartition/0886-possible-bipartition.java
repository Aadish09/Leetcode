class Solution {
    public boolean possibleBipartition(int n, int[][] pre) {
        Map < Integer, List < Integer >> map = new HashMap < > ();
        for (int i = 0; i < pre.length; i++) {
          int key = pre[i][0];
            int value = pre[i][1];
          if (map.get(key) != null) {
            List < Integer > adj = map.get(key);
            adj.add(pre[i][1]);
            map.replace(key, adj);
          } else {
            
            map.put(key, new ArrayList < > () {
              {
                add(value);
              }
            });
          }
            if (map.get(value) != null) {
            List < Integer > adj = map.get(value);
            adj.add(key);
            map.replace(value, adj);
          } else {
            
            map.put(value, new ArrayList < > () {
              {
                add(key);
              }
            });
          }
        }
       
        // coloring to check bipartite
        int[] colors = new int[n+1];
        Arrays.fill(colors, -1);
        
        for(int parent=1;parent<=n;parent++) {
           if(colors[parent] ==-1){
               if(!bfs(parent, colors, map)) return false;
           }
        }
      
        return true;
    }
    
    public boolean bfs(int parent, int [] colors, Map < Integer, List < Integer >> map){
        Queue<Integer> q = new LinkedList<>();
        q.add(parent);
        colors[parent] = 1;

        while(!q.isEmpty()) {
            int temp = q.poll(); 
            if(map.get(temp) == null) continue;
            List<Integer> edges = map.get(temp);
            for(Integer child : edges) {
                if(colors[child] == -1) {
                   q.add(child);
                   colors[child] = 1-colors[temp];
                }
                else if(colors[child] == colors[temp]) return false; 
            }

          }
        return true;
    }
}