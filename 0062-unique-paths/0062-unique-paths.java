class Solution {
    public int uniquePaths(int m, int n) {
        return count(m,n);
    }
    
    public int count(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        if(m==1 && n==1) return 1;
       // initialize 0th row with 1
		// this is because there is only one path to reach at any column of 0th row
        for(int i=1; i<m; i++){
            dp[i][0] = 1;
        }
		
		// initialize 0th column with 1
		// this is because there is only one path to reach at any row of 0th column
        for(int j=1; j<n; j++){
            dp[0][j] = 1;
        }
		
       for(int i=1;i<m;i++) {
           for(int j=1;j<n;j++){
               dp[i][j] = dp[i][j-1] + dp[i-1][j];
           }
       }
        return dp[m-1][n-1];
    }
}