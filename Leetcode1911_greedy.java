class Solution {
    public long maxAlternatingSum(int[] nums) {
		long ans = 0 , currentSum = 0;
		int n = nums.length;
		int i=0;
		while (i+1<n) {
			while ( i+1<n && nums[i] <= nums[i+1] ) {
				i+=1;
			}
			currentSum+=nums[i];
			ans = Math.max(ans , currentSum);

			while ( i+1<n && nums[i] >= nums[i+1] ) {
				i+=1;
			}

			currentSum-=nums[i];
		}
		return ans;
	}
}
