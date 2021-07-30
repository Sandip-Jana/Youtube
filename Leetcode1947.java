class Solution {
   	int memo[];

	public int maxCompatibilitySum(int[][] students, int[][] mentors) {
		int m = students.length;
		int n = students.length > 0 ? students[0].length : 0;

		int MAX = (1<<m)+4;
		memo = new int[MAX];
		
		Arrays.fill(memo , -1);
		
		int score[][] = new int[m][m];
		for (int i=0 ; i<m ; i++) {
			for (int j=0 ; j<m ; j++) {
				score[i][j] += compare( students[i] , mentors[j] );
			}
		}

		return rec( students , mentors, 0 , 0 , m , score);
	}

	private int compare(int[] student, int[] mentor) {
		int ans = 0;
		for (int i=0 ; i<student.length ; i++)
			ans += (student[i] == mentor[i]) ? 1 : 0;
		return ans;
	}


	private int rec(int[][] students, int[][] mentors, int student, int mentor, int m, int s[][]) {
		if ( mentor + 1 == 1<<m ) {
			return 0;
		}

		if (memo[mentor] != -1)
			return memo[mentor];

		int ans = 0;
        for (int j = 0 ; j < m ; j++) {
            if ( (mentor&(1<<j))==0 ) {
                ans = Math.max( ans , s[student][j] +
                        rec(students , mentors , student+1 , mentor|(1<<j) , m , s) );
            }
        }
		
		return memo[mentor] = ans;
	}

}
