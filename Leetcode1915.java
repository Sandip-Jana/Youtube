class Solution {
    public long wonderfulSubstrings(String word) {
		int n = word.length();
		HashMap<Character , Integer> hashMap = new HashMap<>();
		int mask = 1;
		for (int i = 0 ; i < 10 ; i++) {
			hashMap.put( (char)('a' + i) , mask);
			mask = mask * 2;
		}

		mask = 0;
		long count = 0;
		int seen[] = new int[1024];
		seen[0] = 1;
		for (int i=0 ; i<n ; i++) {
			int original = hashMap.get(word.charAt(i));
			mask = mask ^ original;
			count+=seen[mask];

			for (int j=0 ; j<10 ; j++)
				count+=seen[ mask ^ (1<<j) ];

			++seen[mask];
		}
		return count;
	}
}
