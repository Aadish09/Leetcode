class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return count(n, m, grid);
    }
    
     public int count(int m, int n, int[][] grid) {
        int dp[][] = new int[m+1][n+1];
        dp[0][0]= grid[0][0]==0?1:0;
        for(int i=1; i<m; i++){     
            if(grid[i][0]!=1)
                dp[i][0] = grid[i][0]==0?dp[i-1][0]:0;
        }
        for(int j=1; j<n; j++){
            if(grid[0][j]!=1)
                dp[0][j] = grid[0][j]==0?dp[0][j-1]:0;
        }
		
       for(int i=1;i<m;i++) {
           for(int j=1;j<n;j++){
             if(grid[i][j]!=1)
               dp[i][j] = dp[i][j-1] + dp[i-1][j];
              else 
                 dp[i][j]=0;
           }
       }
        return dp[m-1][n-1];
    }
}