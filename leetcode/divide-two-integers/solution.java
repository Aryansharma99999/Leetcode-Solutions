class Solution {
    public int divide(int dividend, int divisor) {
        // Only case where 32-bit signed int overflows
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Work with negative values because negative range holds one extra number (-2^31)
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;

        int ans = 0;

        while (a <= b) {
            int temp = b;
            int count = 1;

            // Keep doubling the divisor until it gets as close to 'a' as possible without going past it
            while (temp >= (Integer.MIN_VALUE >> 1) && a <= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }

            a -= temp;
            ans += count;
        }

        return isNegative ? -ans : ans;
    }
}