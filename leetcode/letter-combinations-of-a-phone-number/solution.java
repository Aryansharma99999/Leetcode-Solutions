class Solution {
    private static final String[] KEYS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }
        backtrack(ans, new StringBuilder(), digits, 0);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder sb, String digits, int idx) {
        if (idx == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String letters = KEYS[digits.charAt(idx) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(ans, sb, digits, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}