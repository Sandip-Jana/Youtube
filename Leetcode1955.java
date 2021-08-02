class Solution {
    public int countSpecialSubsequences(int[] nums) {
		int n = nums.length;
		int mod = (int)1e9+7;
		long dp[][] = new long[n+1][3];
		for (int i=1 ; i<=n ; i++) {
			int element = nums[i-1];
            dp[i][0] = dp[i-1][0];
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-1][2];
			if ( element == 0 ) {
				dp[i][0] = (1 + dp[i-1][0]*1L*2)%mod;
			} else if (element == 1 && dp[i-1][0] > 0) {
				dp[i][1] = (dp[i-1][0] + dp[i-1][1]*2)%mod;
			} else if (element == 2 && dp[i-1][1] > 0) {
				dp[i][2] = (dp[i-1][1] + dp[i-1][2]*2)%mod;
			}
		}
		return (int)dp[n][2]%mod;
	}
}
