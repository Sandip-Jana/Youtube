class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int ans = Integer.MIN_VALUE;
        int m = grid.size();
        int n = grid.get(0).size();
        int dp[][] = new int[m][n];
        for (int i = 0 ; i < m ; i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        dp[0][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                // left
                if (j - 1 >= 0) {
                    int c2 = grid.get(i).get(j);
                    int c1 = grid.get(i).get(j-1);
                    int optimalPathFromLeft = dp[i][j-1];

                    dp[i][j] = max( dp[i][j] , c2 - c1 ,  c2 - c1 + optimalPathFromLeft);
                }

                // upwards
                if (i - 1 >= 0) {
                    int c2 = grid.get(i).get(j);
                    int c1 = grid.get(i-1).get(j);
                    int optimalPathFromUp = dp[i-1][j];

                    dp[i][j] = max( dp[i][j] , c2 - c1 ,  c2 - c1 + optimalPathFromUp);
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    private int max(int i, int j, int p) {
        return Math.max(i, Math.max(j,p));
    }
}
