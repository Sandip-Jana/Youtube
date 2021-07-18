class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = n == 0 ? 0 : matrix[0].length;
        for(int i=1 ; i<n ; i++) {
            int temp[] = new int[m];
            for(int j=0 ; j<m ; j++) {
                int min = Integer.MAX_VALUE;
                for(int k=j-1 ; k<=j+1 ; k++) {
                    if ( k<0 || k>=m ) continue;
                    min = Math.min(matrix[i-1][k] , min );
                }
                temp[j] = matrix[i][j]+min;
            }
            matrix[i] = temp;
        }
        
        int ans = Integer.MAX_VALUE;
        for(int j=0 ; j<m ; j++)
            ans = Math.min(ans , matrix[n-1][j]);
        return ans;
    }
}
