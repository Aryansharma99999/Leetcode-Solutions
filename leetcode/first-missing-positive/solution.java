class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Place each number in its correct position: nums[i] should be at index nums[i] - 1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int targetIndex = nums[i] - 1;
                int temp = nums[targetIndex];
                nums[targetIndex] = nums[i];
                nums[i] = temp;
            }
        }
        
        // Find the first index where the value is not index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all numbers from 1 to n are present, the missing positive is n + 1
        return n + 1;
    }
}