class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;

        // 1. Skip trailing spaces at the end of the string
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // 2. Count characters of the last word until a space or start of string
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}