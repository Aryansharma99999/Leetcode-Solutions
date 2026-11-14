class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (except 0 itself) are never palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        // Check both even-length (x == rev) and odd-length (x == rev / 10) numbers
        return x == rev || x == rev / 10;
    }
}