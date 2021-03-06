class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
 
        int[] frequencyEven = getHighestAndSecondHighestPair(even.toArray(new Integer[0]));
        int[] frequencyOdd = getHighestAndSecondHighestPair(odd.toArray(new Integer[0]));
 
        if (frequencyEven[0] != frequencyOdd[0]) {
            // Case 1 : top occurring elements are different so second condition is already satisfied.
            return nums.length - (frequencyEven[1] + frequencyOdd[1]);
        } else {
            /**
             *  Case 2 : top occurring elements in even and odd array is same and hence we take the best among
             *
             *  i. converting all elements in even array to maxOccurring element + converting all elements in odd array to secondMaxOccuringElement
             *  ii. converting all elements in odd array to maxOccurring element + converting all elements in even array to secondMaxOccuringElement
             */
            int X1 = frequencyEven[1] + frequencyOdd[2];
            int X2 = frequencyEven[2] + frequencyOdd[1];
            return nums.length - Math.max( X1 , X2 );
        }
    }
 
 
    /**
     * Returns an array containing three values : maxOccurringElement , count_of_max_occurring_element
     * and count_of_second_max_occurring_element
     * @param arr
     * @return array containing maxOccurredElement, frequency[maxOccurredElement], frequency[secondMaxOccurredElement]
     */
    int[] getHighestAndSecondHighestPair(Integer arr[]) {
        int first = 0, second = 0;
        int frequency[] = new int[1_00_005];
        for (int i = 0; i < arr.length; i++) {
            frequency[arr[i]] += 1;
            if (frequency[arr[i]] >= frequency[first]) {
                if (arr[i] != first) {
                    second = first;
                }
                first = arr[i];
            } else if (frequency[arr[i]] > frequency[second]) {
                second = arr[i];
            }
        }
        return new int[]{first, frequency[first], frequency[second]};
    }
}
