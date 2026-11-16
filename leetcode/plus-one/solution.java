class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the rightmost digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // Digit is 9, so it becomes 0 and carries 1 to the left
            digits[i] = 0;
        }

        // All digits were 9 (e.g., [9] -> [1, 0])
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}