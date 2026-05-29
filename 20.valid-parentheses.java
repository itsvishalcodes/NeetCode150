
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> openingToClosingBraceMap =
            new HashMap<>();
        openingToClosingBraceMap.put(')', '(');
        openingToClosingBraceMap.put('}', '{');
        openingToClosingBraceMap.put(']', '[');

        for(int i=0; i<s.length(); i++) {
            char currentChar = s.charAt(i);
            if(openingToClosingBraceMap.values().contains(currentChar)) {
                st.add(currentChar);
            } else {
                char correspondingClosing = openingToClosingBraceMap.get(currentChar);
                try {
                    if (st.peek() != correspondingClosing) return false;
                    else st.pop();
                } catch (Exception e) {
                    return false;
                }
            }
        }

        if(!st.isEmpty()) return false;

        return true;
    }
}
// @lc code=end

