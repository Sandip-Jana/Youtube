class Solution {
    public int maxScoreSightseeingPair(int[] values) {
		int best = values[0]+0;  
		int ans = 0;
		for (int j=1 ; j<values.length ; j++) {
            // for each j answer is values[j]-j + best value of (values[i]+i) we found so far
			ans = Math.max( best + values[j]-j , ans );
            
            // update the value of best values[i]+i.
			best = Math.max( best , values[j]+j );
		}
		return ans;
	}
}
