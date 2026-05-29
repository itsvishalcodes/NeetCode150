/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public String normaliseString(String s) {
        String res = "";
        s = s.toLowerCase();
        for (char c:s.toCharArray()) {
            if ((c>='a' && c<='z') || (c>='0' && c<='9')) {
                res = res + c;
            }
        }

        return res;
    }
    public boolean isPalindrome(String s) {
        String normalized = normaliseString(s);
        return normalized.equals(new StringBuilder(normalized).reverse().toString());
    }
}
// @lc code=end

