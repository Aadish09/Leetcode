class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if(n==0) return 0;
        int m = grid[0].length;
        boolean [][] vis = new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(vis[i][j] == false && grid[i][j] == '1'){
                    if(dfs(grid, vis, true, i, j, n, m)) count ++;
                }
            }
        }
        return count;
    }
    
    public boolean dfs(char [][] grid, boolean [][] vis, boolean flag, int i, int j, int n , int m) {
        if(i >= n || j>=m || i<0 || j<0) return flag;
        if(vis[i][j]) return flag;
       
        vis[i][j] = true;
        if(grid[i][j]=='0') return true;

        return dfs(grid, vis, flag, i+1, j,n, m) && dfs(grid, vis, flag, i-1, j,n, m)
            && dfs(grid, vis, flag, i, j+1,n, m) && dfs(grid, vis, flag, i, j-1,n, m);
    }
}