# Intuition
The problem essentially asks us to find two numbers in the array that:

1. Have a minimum difference in their values.
2. Their positions are at least x apart.

`Simple Case: Ignoring the Position Condition`
Without the second condition about the indices being x apart, the problem is simpler: you'd want to find two numbers in the array with the smallest difference between them. A straightforward way to achieve this would be to sort the numbers and then compare adjacent numbers to find the smallest difference. But for the current problem, sorting is not ideal because we lose the original indices of the elements.

However, to utilize this idea, we can use a TreeSet. It helps us maintain an ordered set of numbers and lets us search for the closest numbers efficiently.

`Incorporating the Index Distance Constraint`
Now, we need to incorporate the condition that the two numbers we pick should be at least x indices apart.

A neat approach is to iterate through the list of numbers backwards. As we move back, for every element, we check the difference with numbers that are x indices ahead and add them to our TreeSet. This way, our TreeSet always contains elements that are at least x indices ahead of our current element.

For every current element, we look for the nearest larger and smaller numbers present in the TreeSet (using the higher and lower methods). These will give us the smallest possible differences satisfying the conditions.



# Complexity
- Time complexity:
O( N log N ) : The iteration over the numbers is 
        O(N), and the TreeSet operations (add, higher, lower) are O(log N), O(logN) and O(logN) respectively.

- Space complexity:
O ( N ) - We're using a TreeSet to store up to N numbers

# Code
```
class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        final TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for (int i = n - 1 - x; i >= 0; i--) {
            int indexAhead = i + x;
            set.add(nums.get(indexAhead));

            int element = nums.get(i);
            Integer min = set.lower(element + 1);
            Integer max = set.higher(element - 1);

            if (min != null)
                ans = Math.min(ans, Math.abs(min - element));

            if (max != null)
                ans = Math.min(ans, Math.abs(max - element));
        }
        return ans;
    }
}
```
