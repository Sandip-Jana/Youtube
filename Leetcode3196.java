// https://leetcode.com/problems/maximize-total-cost-of-alternating-subarrays/

class Solution {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long dp[][] = new long[n][2];

        dp[0][0] = dp[0][1] = nums[0];
        int countOfSubarraySoFar = 1;

        for (int i = 1; i < nums.length; i++) {
            
            // if we split at this index what is best so far
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + nums[i];

            // if we dont split at this index what is best so far
            
            // either we take the sum after we made the last split
            long sumFromTop = dp[i - 1][0] - nums[i];

            // or we take sum from subarray where no split was done
            long factor = countOfSubarraySoFar % 2 == 0 ? 1 : -1;
            long sumFromBottom = dp[i - 1][1] + (nums[i] * factor);

            if (sumFromTop > sumFromBottom) {
                dp[i][1] = sumFromTop;
                countOfSubarraySoFar = 2;
            } else {
                dp[i][1] = sumFromBottom;
                countOfSubarraySoFar = countOfSubarraySoFar + 1;
            }
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
