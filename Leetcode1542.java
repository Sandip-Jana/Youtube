class Solution {
    public int longestAwesome(String s) {
        int dp[] = new int[1024];
        Arrays.fill(dp , s.length());
        dp[0] = -1;
        int res = 0 , mask = 0;
        for (int i=0 ; i<s.length() ; i++) {
            mask = mask ^ ( 1 << s.charAt(i)-'0');
            res = Math.max(res , i - dp[mask]);
            for (int j=0 ; j<=9 ; j++)  
                res = Math.max( res , i - dp[mask^(1<<j)] );
            
            dp[mask] = Math.min(dp[mask] , i);    
        }
        return res;
    }
}
