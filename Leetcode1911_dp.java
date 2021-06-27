class Solution {
     public long maxAlternatingSum(int[] nums) {
		int n = nums.length;
        long dp[][] = new long[n+1][2];
		for (int i=0 ; i<n ; i++) {
            dp[i+1][0] = Math.max( dp[i][0] , dp[i][1]-nums[i] );
            dp[i+1][1] = Math.max( dp[i][1] , dp[i][0]+nums[i] );
        }
        
		return dp[n][1];
	}
}
