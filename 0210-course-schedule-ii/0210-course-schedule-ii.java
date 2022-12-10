class Solution {
  public int[] findOrder(int n, int[][] pre) {
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
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      if (!dfs(map, i, vis, new HashSet < > (), st)) {
          return new int[0];
      } 
    }
      
    int[] courses = new int[n];
    int c = 0;
    while(!st.isEmpty()) {
      courses[c++] = st.pop();
    }
    return courses;
  }

  public boolean dfs(Map<Integer, List<Integer>> map, int vertex, boolean[] vis, Set <Integer> set, Stack<Integer> st) {
    if(vis[vertex]) return true;
      System.out.print(vertex);
    vis[vertex] = true;
    set.add(vertex);
    List <Integer> dependencies = map.get(vertex);
    if (dependencies == null) {      
        st.push(vertex);return true;
    }
    for (Integer i: dependencies) {
        if(set.contains(i)) return false;
        if(!dfs(map, i, vis, set, st)) return false;
        set.remove(i);
    }
    st.push(vertex);  // topological sorting
    return true;
  }
}